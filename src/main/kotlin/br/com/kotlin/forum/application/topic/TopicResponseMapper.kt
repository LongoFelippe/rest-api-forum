package br.com.kotlin.forum.application.topic

import br.com.kotlin.forum.application.shared.Mapper
import br.com.kotlin.forum.domain.topic.Topic
import org.springframework.stereotype.Component

@Component
class TopicResponseMapper : Mapper<Topic, TopicResponse> {

    override fun mapTo(origin: Topic): TopicResponse {
        return TopicResponse(
            id = origin.id,
            title = origin.title,
            message = origin.message,
            status = origin.status,
            dateCreation = origin.dateCreation,
            dateUpdate = origin.dateUpdate
        )
    }
}