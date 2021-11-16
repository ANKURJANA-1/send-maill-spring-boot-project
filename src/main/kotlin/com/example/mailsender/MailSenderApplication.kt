package com.example.mailsender

import com.example.mailsender.service.EmailService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication


@SpringBootApplication
class MailSenderApplication

fun main(args: Array<String>) {
    runApplication<MailSenderApplication>(*args)
}




