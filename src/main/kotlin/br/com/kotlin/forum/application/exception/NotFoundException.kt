package br.com.kotlin.forum.application.exception

import org.springframework.http.HttpStatus

class NotFoundException(mesage: String) : ApiException(HttpStatus.NOT_FOUND, mesage) {
}