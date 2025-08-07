package org.ktor_lecture

import io.ktor.server.application.Application
import io.ktor.server.netty.EngineMain
import org.ktor_lecture.plugins.callLogging
import org.ktor_lecture.plugins.configureDatabase
import org.ktor_lecture.plugins.contentNegotiation
import org.ktor_lecture.plugins.initialize
import org.ktor_lecture.plugins.registerRouting

fun main(args : Array<String>) {
    EngineMain.main(args)
}

fun Application.module() {
    initialize()
    contentNegotiation()
    configureDatabase()
    callLogging()

    registerRouting()
}