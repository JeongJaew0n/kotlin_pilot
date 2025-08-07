package org.ktor_lecture.types.wire

data class CapsuleWire (
    val id : String,
    val title : String,
    val description : String?,
    val scheduleOpenDate : Int,
    val status : String,

    val contentType: String,
    val content : String?,
    val recipientEmail : String,
    val hasViewed : Boolean,

    val filePath : String?,
    val fileName : String?
)