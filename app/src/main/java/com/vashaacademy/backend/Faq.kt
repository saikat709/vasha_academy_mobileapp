package com.vashaacademy.backend

data class Faq(
    val id: Int,
    val question_bangla: String,
    val question_english: String,
    val answer_bangla: String,
    val answer_english: String
)