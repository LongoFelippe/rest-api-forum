package br.com.kotlin.forum.application.exception

import org.springframework.http.HttpStatus

open class ApiException(val status: HttpStatus, val error: String) : RuntimeException()