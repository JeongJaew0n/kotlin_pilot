package org.ktor_lecture.repository

import com.github.f4b6a3.ulid.UlidCreator
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.update
import org.ktor_lecture.types.storage.CapsuleContents
import org.ktor_lecture.types.storage.ContentType

class CapsuleContentRepository {


    fun create(
        capsuleId : String,
        contentType : ContentType,
        content : String
    ) : String {
        val id = UlidCreator.getUlid().toString()
        val now = (System.currentTimeMillis() / 1000).toInt()

        CapsuleContents.insert {
            it[CapsuleContents.id] = id
            it[CapsuleContents.capsuleId] = capsuleId
            it[CapsuleContents.contentType] = contentType
            it[CapsuleContents.content] = content
            it[createdAt] = now
        }

        return id
    }

    fun updateContentById(capsuleId : String, content : String)  {
        CapsuleContents.update( { CapsuleContents.capsuleId eq capsuleId })  {
            it[CapsuleContents.content] = content
        }
    }
}