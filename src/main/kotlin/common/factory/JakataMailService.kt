package org.ktor_lecture.common.factory

import jakarta.mail.Authenticator
import jakarta.mail.Session
import jakarta.mail.*
import jakarta.mail.internet.InternetAddress
import jakarta.mail.internet.MimeMessage
import org.ktor_lecture.config.EmailException
import org.ktor_lecture.config.EmailServiceImpl
import org.slf4j.LoggerFactory
import java.util.Date
import java.util.Properties

class JakataMailService(
    private val host : String,
    private val port : String,
    private val username : String,
    private val password : String,
    private val fromEmail : String,
    private val fromName : String,
) : EmailServiceImpl {
    private val logger = LoggerFactory.getLogger(JakataMailService::class.java)
    private val session : Session

    init {
        val properties = Properties().apply {
            put("mail.smtp.host", host)
            put("mail.smtp.port", port)
            put("mail.smtp.auth", "true")

            // TLS 설정
            put("mail.smtp.starttls.enable", "true")
            put("mail.smtp.starttls.required", "true")

            // 디버깅 활성화 (로그)
            put("mail.debug" , "true")
        }

        session = Session.getInstance(properties, object: Authenticator() {
            override fun getPasswordAuthentication() : PasswordAuthentication {
                return PasswordAuthentication(username, password)
            }
        })
    }

    @Throws(EmailException::class)
    override fun sendEmail(to: String, subject: String, body: String) {
        sendEmailInternal(to, subject, body)
    }

    @Throws(EmailException::class)
    private fun sendEmailInternal(to: String, subject: String, body: String) {
        try {
            val message  = MimeMessage(session)
            message.setFrom(InternetAddress(fromEmail, fromName))
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to))
            message.subject = subject
            message.sentDate = Date()
            message.setContent(body, "text/html; charset=utf-8")

            Transport.send(message)

            logger.info("Email sent to $to")
        } catch (e: Exception) {
            logger.error("Failed to send email : ${e.message}")
            throw EmailException("Failed to send email : ${e.message}", e)
        }
    }

    override fun provider() : String {
        return "jakata"
    }
}