package br.com.kotlin.forum.application.exception

import java.time.LocalDateTime

data class ResponseError(
    val status: Int,
    val error: String,
    val message: String,
    val path: String,
    val timeStamp: LocalDateTime = LocalDateTime.now()
)