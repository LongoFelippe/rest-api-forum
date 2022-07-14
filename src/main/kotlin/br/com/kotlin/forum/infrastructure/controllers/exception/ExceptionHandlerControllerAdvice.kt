package br.com.kotlin.forum.infrastructure.controllers.exception

import br.com.kotlin.forum.application.exception.ApiException
import br.com.kotlin.forum.application.exception.ResponseError
import mu.KLogger
import mu.KotlinLogging.logger
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import javax.servlet.http.HttpServletRequest

@RestControllerAdvice
class ExceptionHandlerControllerAdvice(private val log: KLogger = logger {}) {

    private fun makeResponseError(status: Int, error: String, message: String, path: String): ResponseError {
        return ResponseError(status, error, message, path)
    }

    @ExceptionHandler(Exception::class)
    fun handlerException(ex: Exception, req: HttpServletRequest): ResponseEntity<ResponseError> {
        log.error { "m=handlerException, error=${ex.message}" }
        val responseError = makeResponseError(
            status = HttpStatus.INTERNAL_SERVER_ERROR.value(),
            error = HttpStatus.INTERNAL_SERVER_ERROR.name,
            message = "Internal Server Error",
            path = req.servletPath
        )
        return ResponseEntity<ResponseError>(responseError, HttpStatus.INTERNAL_SERVER_ERROR)
    }

    @ExceptionHandler(ApiException::class)
    fun handlerApiException(ex: ApiException, req: HttpServletRequest): ResponseEntity<ResponseError> {
        log.error { "m=handlerApiException, message=${ex.error}" }
        val responseError = makeResponseError(
            status = ex.status.value(),
            error = ex.status.name,
            message = ex.error,
            path = req.servletPath
        )
        return ResponseEntity<ResponseError>(responseError, ex.status)
    }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handlerValidateException(
        ex: MethodArgumentNotValidException,
        req: HttpServletRequest
    ): ResponseEntity<ResponseError> {
        log.error { "m=handlerValidateException, error=${ex.message}" }
        val errorMessage = HashMap<String, String?>()
        ex.bindingResult.fieldErrors.forEach { e -> errorMessage[e.field] = e.defaultMessage }
        val responseError = makeResponseError(
            status = HttpStatus.BAD_REQUEST.value(),
            error = HttpStatus.BAD_REQUEST.name,
            message = errorMessage.toString(),
            path = req.servletPath
        )
        return ResponseEntity<ResponseError>(responseError, HttpStatus.BAD_REQUEST)
    }

}