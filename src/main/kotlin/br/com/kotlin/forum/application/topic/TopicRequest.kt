package br.com.kotlin.forum.application.topic

import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

data class TopicRequest(

    @field:NotBlank
    @field:Size(min = 5, max = 50, message = "Título deve ter entre 5 e 50 caracteres")
    val title: String,

    @field:NotBlank
    @field:Size(min = 5, max = 1000, message = "Mensagem deve ter entre 5 e 1000 caracteres")
    val message: String,

    @field:NotNull(message = "userID não pode ser nulo")
    val userId: Long,

    @field:NotNull(message = "couseId não pode ser nulo")
    val courseId: Long,

    )