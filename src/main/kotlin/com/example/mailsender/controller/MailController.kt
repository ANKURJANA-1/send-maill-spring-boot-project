package com.example.mailsender.controller

import com.example.mailsender.service.EmailService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.io.FileSystemResource
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.mail.javamail.MimeMessageHelper
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.thymeleaf.TemplateEngine
import java.io.File
import java.util.*
import javax.mail.MessagingException
import javax.naming.Context


@RestController
@RequestMapping("mail")
class MailController {

    @Autowired
    private lateinit var sender: JavaMailSender

    @Autowired
    private lateinit var emailService: EmailService


    @GetMapping("/sendMail")
    fun sendMail(): String? {
        val message = sender.createMimeMessage()
        val helper = MimeMessageHelper(message, true)
        //val htmlPart = MimeBodyPart()
        val res = FileSystemResource(File("d:/Sample.jpg"))

        val allUser = emailService.allUser()
        for (user in allUser) {
            try {
                helper.setTo(user.email)
                helper.setText("<b>${user.subject}<\b>")
                helper.setSubject("Mail From AgpayTech")
                helper.setText(
                    "<html>" +
                            "<body>" +
                            "<h4>${"Dear," + "\n" + user.name}</h4>" +
                            "<h6>${user.subject}</h6>" +
                            "<h6>${user.email}</h6>" +
                            "<p>${user.desc}</p>" +
                            "<img src='cid:identifier1234'>" +
                            "<h6>regards,</h6>" +
                            "</body>" +
                            "</html>",
                    true
                )
                helper.addInline("identifier1234", res)

            } catch (e: MessagingException) {
                e.printStackTrace()
                return "Error while sending mail .."
            }
            sender.send(message)
        }

        return "Mail Sent Success!"
    }

    @GetMapping("/send")
    fun sendMailFromService(): String {
        try {
            emailService.sendMail(
                "ankur@agpaytech.co.uk",
                "hi how are you",
                "this is a test email sending from spring boot application"
            )
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return "Message send"

    }

}

private operator fun Any.plus(s: String) {

}

private operator fun String.unaryPlus() {
    TODO("Not yet implemented")
}
