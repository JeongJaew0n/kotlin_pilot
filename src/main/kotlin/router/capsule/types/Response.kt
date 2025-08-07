package org.ktor_lecture.router.capsule.types

import org.ktor_lecture.types.storage.ContentType

data class CapsuleCreateResponse(
    val capsuleId : String,
    val recipientEmail : String,
    val contentType : ContentType,
    val fileSize : Int? = null,
    val filePath : String? = null,
    val fileName : String? = null,
)

data class OpenCapsuleResponse(
    val capsuleId : String,
    val recipientEmail : String,
    val mailSendSuccess : Boolean
)