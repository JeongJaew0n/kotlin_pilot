package org.ktor_lecture.common.factory

import org.ktor_lecture.config.EmailException
import org.ktor_lecture.config.EmailServiceImpl

class AWSMailService() : EmailServiceImpl {

    @Throws(EmailException::class)
    override fun sendEmail(to: String, subject: String, body: String) {
    }

    override fun provider() : String {
        TODO()
    }
}