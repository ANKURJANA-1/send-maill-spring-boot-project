package com.example.mailsender.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.mail.SimpleMailMessage


@Configuration
class EmailConfig {
    @Bean
    fun emailTemplate(): SimpleMailMessage? {
        val message = SimpleMailMessage()
        message.setTo("ankurjana905@gmail.com")
        message.setFrom("rocknot914@gmail.com")
        message.setSubject("Important email")
        message.setText("FATAL - Application crash. Save your job !!")
        return message
    }
}