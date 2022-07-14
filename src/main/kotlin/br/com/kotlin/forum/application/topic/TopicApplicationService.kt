package br.com.kotlin.forum.application.topic

import br.com.kotlin.forum.domain.topic.TopicService
import org.springframework.stereotype.Service
import java.util.*

@Service
class TopicApplicationService(
    private val topicService: TopicService,
    private val topicResponseMapper: TopicResponseMapper
) {

    fun getTopics(): List<TopicResponse> {
        val topics = topicService.getTopics()
        return topics.stream()
            .map { topic -> topicResponseMapper.mapTo(topic) }
            .toList()
    }

    fun getTopicById(id: Long): Optional<TopicResponse> {
        val topic = topicService.getTopicById(id)
        return Optional.of(topicResponseMapper.mapTo(topic))
    }

    fun createTopic(topic: TopicRequest): TopicResponse {
        val newTopic = topicService.createTopic(topic)
        return topicResponseMapper.mapTo(newTopic)
    }

    fun deleteTopic(id: Long) {
        topicService.deleteTopic(id)
    }

    fun updateTopic(id: Long, topic: TopicRequest): TopicResponse {
        val updatedTopic = topicService.updateTopic(id, topic)
        return topicResponseMapper.mapTo(updatedTopic)
    }

}
