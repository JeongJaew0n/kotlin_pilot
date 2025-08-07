package org.ktor_lecture.router.auth.route

import io.ktor.http.HttpStatusCode
import io.ktor.server.application.call
import io.ktor.server.response.respond
import io.ktor.server.routing.Route
import io.ktor.server.routing.route
import org.koin.ktor.ext.get
import org.ktor_lecture.common.validation.postAPI
import org.ktor_lecture.router.auth.service.AuthService
import org.ktor_lecture.router.auth.types.CreateNewAccountRequest
import org.ktor_lecture.router.auth.types.LoginRequest

fun Route.AuthRouter() {
    val authService  = get<AuthService>()

    route("/auth") {
        postAPI<CreateNewAccountRequest>("/create") { req ->
            val res = authService.createAccount(req.email, req.password)
            call.respond(HttpStatusCode.OK, res)
        }

        postAPI<LoginRequest>("/login") { req ->
            val res =  authService.login(req.email, req.password)
            call.respond(HttpStatusCode.OK, res)
        }
    }
}