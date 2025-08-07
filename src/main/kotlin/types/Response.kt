package org.ktor_lecture.types

import io.ktor.http.HttpStatusCode

class GlobalResponse<T>(
    val code : Int,
    val message : String,
    val data : T?
)


object GlobalResponseProvider {
    fun <T> new(code : Int, message : String, data: T?): GlobalResponse<T> = GlobalResponse(code, message, data)
}