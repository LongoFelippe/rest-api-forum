package br.com.kotlin.forum.application.topic

import br.com.kotlin.forum.domain.topic.StatusTopic
import java.time.LocalDateTime

data class TopicResponse(
    val id: Long?,
    val title: String,
    val message: String,
    val status: StatusTopic,
    val dateCreation: LocalDateTime,
    val dateUpdate: LocalDateTime,
) {
}