package br.com.kotlin.forum.domain.response

import br.com.kotlin.forum.domain.topic.Topic
import br.com.kotlin.forum.domain.user.User
import java.time.LocalDateTime

data class Response(
    val id: Long? = null,
    val message: String,
    val datCreation: LocalDateTime = LocalDateTime.now(),
    val author: User,
    val topic: Topic,
    val solution: Boolean,
)
