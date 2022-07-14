package br.com.kotlin.forum.domain.topic

import br.com.kotlin.forum.application.topic.TopicRequest

interface TopicService {
    fun getTopics(): List<Topic>
    fun getTopicById(id: Long): Topic
    fun createTopic(topic: TopicRequest): Topic
    fun deleteTopic(id: Long)
    fun updateTopic(id: Long, topic: TopicRequest): Topic
}