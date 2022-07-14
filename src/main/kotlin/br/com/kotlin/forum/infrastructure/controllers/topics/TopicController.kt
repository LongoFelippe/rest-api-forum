package br.com.kotlin.forum.infrastructure.controllers.topics

import br.com.kotlin.forum.application.topic.TopicApplicationService
import br.com.kotlin.forum.application.topic.TopicRequest
import br.com.kotlin.forum.application.topic.TopicResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/topics")
class TopicController(private val topicApplicationService: TopicApplicationService) {

    @GetMapping
    fun getTopics(): ResponseEntity<List<TopicResponse>> {
        return ResponseEntity.ok(topicApplicationService.getTopics())
    }

    @GetMapping("/{id}")
    fun getTopicById(@PathVariable id: Long): ResponseEntity<TopicResponse> {
        val topic = topicApplicationService.getTopicById(id)
        if (topic.isPresent) {
            return ResponseEntity.ok(topic.get())
        }
        return ResponseEntity.ok(null)
    }

    @PostMapping
    fun createTopic(@RequestBody @Valid topic: TopicRequest): ResponseEntity<TopicResponse> {
        val topicCreated = topicApplicationService.createTopic(topic)
        return ResponseEntity.ok(topicCreated)
    }

    @DeleteMapping("/{id}")
    fun deleteTopic(@PathVariable id: Long): ResponseEntity<Void> {
        topicApplicationService.deleteTopic(id)
        return ResponseEntity.noContent().build()
    }

    @PutMapping("/{id}")
    fun updateTopic(
        @PathVariable id: Long,
        @RequestBody @Valid topic: TopicRequest
    ): ResponseEntity<TopicResponse> {
        val topicUpdated = topicApplicationService.updateTopic(id, topic)
        return ResponseEntity.ok(topicUpdated)
    }

}