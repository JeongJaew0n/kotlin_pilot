CREATE database app;
use app;

CREATE TABLE users (
   id char(26) PRIMARY KEY,
   email varchar(100) UNIQUE NOT NULL,
   password_hash VARCHAR(255) NOT NULL,
   created_at int DEFAULT 0,
   updated_at int DEFAULT 0,
   is_active BOOLEAN DEFAULT TRUE
);

CREATE TABLE user_token_mapper(
      user_id char(26) primary key,
      token VARCHAR(500)
);

CREATE TABLE time_capsules (
   id char(26) PRIMARY KEY,
   creator_id char(26) NOT NULL,
   title TEXT NOT NULL,
   description TEXT,
   creation_date int DEFAULT 0,
   scheduled_open_date int NOT NULL,
   status ENUM('sealed', 'opened') DEFAULT 'sealed'
);

CREATE TABLE capsule_contents (
      id char(26) PRIMARY KEY,
      capsule_id char(26) NOT NULL,
      content_type ENUM('text', 'image', 'video', 'audio', 'file') NOT NULL,
      content TEXT,
      created_at int DEFAULT 0
);

CREATE TABLE recipients (
    id char(26) PRIMARY KEY,
    capsule_id char(26) NOT NULL,
    recipient_email varchar(100),
    has_viewed BOOLEAN DEFAULT FALSE,
    notification_sent BOOLEAN DEFAULT FALSE
);

CREATE TABLE time_capsule_encryption_mapper (
    id char(26) PRIMARY KEY,
    capsule_id char(26) NOT NULL,
    encrypted_data_key VARCHAR(500),
    time_salt VARCHAR(500)
);

CREATE TABLE capsule_file_key_mapper (
     id char(26) PRIMARY KEY,
     capsule_id char(26) NOT NULL,
     file_path VARCHAR(500) NOT NULL,
     file_name VARCHAR(500) NOT NULL,
     storage char(26) NOT NULL
)