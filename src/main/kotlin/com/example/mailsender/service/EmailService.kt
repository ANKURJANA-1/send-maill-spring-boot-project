package com.example.mailsender.service

import com.example.mailsender.model.MailUser
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.mail.SimpleMailMessage
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.stereotype.Service
import java.util.*
import kotlin.collections.ArrayList


@Service
class EmailService {

    @Autowired
    private lateinit var mailSender: JavaMailSender

    @Autowired
    private lateinit var preConfiguredMessage: SimpleMailMessage


    fun sendMail(to: String?, subject: String?, body: String?) {
        val message = SimpleMailMessage()
        message.setTo(to)
        message.setSubject(subject!!)
        message.setText(body!!)
        mailSender!!.send(message)
    }

    fun sendPreConfiguredMail(message: String?) {
        val mailMessage = SimpleMailMessage(preConfiguredMessage!!)
        mailMessage.setText(message!!)
        mailSender!!.send(mailMessage)
    }

    fun allUser(): List<MailUser> {
        return listOf(
            MailUser("Ankur Jana", "ankurjana905@gmail.com", "this is a test ", "testing"),
            MailUser("Ankur Jana", "ankur@agpaytech.co.uk", "this is a test ", "testing"),

            )
    }
}