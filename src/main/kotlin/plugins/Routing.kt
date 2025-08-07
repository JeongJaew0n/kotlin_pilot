package org.ktor_lecture.plugins

import io.ktor.server.application.Application
import io.ktor.server.application.call
import io.ktor.server.response.respondText
import io.ktor.server.routing.get
import io.ktor.server.routing.route
import io.ktor.server.routing.routing
import org.ktor_lecture.router.auth.route.AuthRouter
import org.ktor_lecture.router.capsule.route.CapsuleRoute


fun Application.registerRouting() {

    routing {
        get("/healthCheck") {
            call.respondText("OK")
        }

        route("/api/v1") {
            AuthRouter()
            CapsuleRoute()
        }
    }
}