package com.example.mailsender.model

import javax.swing.text.AbstractDocument

data class MailUser(
    val name: String = "",
    val email: String = "",
    val desc: String = "",
    val subject: String,
    val document: ArrayList<String> = ArrayList(),
    val senderDetails: String = ""

)