package org.ktor_lecture.router.auth.types

import org.ktor_lecture.common.validation.Request
import org.ktor_lecture.common.validation.RequestInfo
import org.ktor_lecture.common.validation.RequestSource

@Request
data class CreateNewAccountRequest(
    @RequestInfo(name = "email", source = RequestSource.BODY, required = true)
    val email : String,

    @RequestInfo(name = "password", source = RequestSource.BODY, required = true)
    val password : String
)


@Request
data class LoginRequest(
    @RequestInfo(name = "email", source = RequestSource.BODY, required = true)
    val email : String,

    @RequestInfo(name = "password", source = RequestSource.BODY, required = true)
    val password : String
)