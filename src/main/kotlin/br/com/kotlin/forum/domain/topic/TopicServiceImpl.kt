package br.com.kotlin.forum.domain.topic

import br.com.kotlin.forum.application.exception.NotFoundException
import br.com.kotlin.forum.application.topic.TopicRequest
import br.com.kotlin.forum.domain.curso.CourseService
import br.com.kotlin.forum.domain.user.UserService
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class TopicServiceImpl(
    private val courseService: CourseService,
    private val userService: UserService
) : TopicService {

    private var topics: List<Topic> = ArrayList()

    override fun getTopics(): List<Topic> {
        return topics
    }

    override fun getTopicById(id: Long): Topic {
        return topics
            .stream()
            .filter { topic -> topic.id == id }
            .findFirst()
            .orElseThrow { NotFoundException("Tópico não encontrado") }
    }

    override fun createTopic(topic: TopicRequest): Topic {
        val course = courseService.getCourseById(topic.courseId)
        val author = userService.getUserById(topic.userId)

        val newTopic = Topic(
            id = topics.count().toLong() + 1,
            title = topic.title,
            message = topic.message,
            course = course,
            author = author
        )

        topics = topics.plus(newTopic)
        return newTopic
    }

    override fun deleteTopic(id: Long) {
        val topic = topics
            .stream()
            .filter { topic -> topic.id == id }
            .findFirst()
            .orElseThrow { NotFoundException("Tópico não encontrado") }

        topics = topics.minus(topic)
    }

    override fun updateTopic(id: Long, topic: TopicRequest): Topic {
        val topicFounded = getTopicById(id)
        topics = topics.minus(topicFounded).plus(
            Topic(
                id = topicFounded.id,
                title = topic.title,
                message = topic.message,
                dateCreation = topicFounded.dateCreation,
                dateUpdate = LocalDateTime.now(),
                course = topicFounded.course,
                author = topicFounded.author,
                status = topicFounded.status,
                responses = topicFounded.responses
            )
        )
        return getTopicById(id)
    }

}