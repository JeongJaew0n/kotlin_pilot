package org.ktor_lecture.types.storage

import org.jetbrains.exposed.sql.Table
import org.ktor_lecture.types.wire.CapsuleWire
import java.time.LocalDateTime

object TimeCapsules : Table(name = "time_capsules") {
    val id = char("id", 26)
    val creator_id = char("creator_id", 26).references(Users.id)
    val title = text("title")
    val description = text("description").nullable()
    val creationDate = integer("creation_date")
    val scheduledOpenDate = integer("scheduled_open_date")
    val status = enumerationByName("status", 10, CapsuleStatus::class)

    override val primaryKey = PrimaryKey(id)
}

enum class CapsuleStatus {
    sealed, opened
}


data class TimeCapsuleByIdStorage(
    val id : String,
    val title : String,
    val description : String?,
    val scheduledOpenDate : Int,
    val status : String,

    val contentType : String,
    val content : String?,
    val recipientEmail : String,
    val hasViewed : Boolean,

    val filePath : String?,
    val fileName : String?,
) {
    fun toWire() = CapsuleWire(
        id = id,
        title = title,
        description = description,
        scheduleOpenDate = scheduledOpenDate,
        status = status,

        contentType = contentType,
        content = content,
        recipientEmail = recipientEmail,
        hasViewed = hasViewed,

        filePath = filePath,
        fileName = fileName,
    )
}