package br.com.kotlin.forum.domain.topic

import br.com.kotlin.forum.domain.curso.Course
import br.com.kotlin.forum.domain.response.Response
import br.com.kotlin.forum.domain.user.User
import java.time.LocalDateTime

data class Topic(
    var id: Long? = null,
    val title: String,
    val message: String,
    val dateCreation: LocalDateTime = LocalDateTime.now(),
    val dateUpdate: LocalDateTime = LocalDateTime.now(),
    val course: Course,
    val author: User,
    val status: StatusTopic = StatusTopic.NOT_ANSWERED,
    val responses: List<Response> = ArrayList()
)