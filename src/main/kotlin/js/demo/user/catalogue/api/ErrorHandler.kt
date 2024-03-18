package js.demo.user.catalogue.api

import js.demo.user.catalogue.api.exceptions.DefaultException
import js.demo.user.catalogue.api.exceptions.UserNotFoundException
import js.demo.user.catalogue.api.model.ErrorMessageResponse
import mu.KotlinLogging
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class ExceptionControllerAdvice {
    private val logger = KotlinLogging.logger {}
    @ExceptionHandler(IllegalStateException::class)
    fun handleIllegalStateException(e: IllegalStateException): ResponseEntity<ErrorMessageResponse> {

        val errorMessage = ErrorMessageResponse(
            HttpStatus.NOT_FOUND.value(),
            e.message
        )
        logger.error(e.message)
        return ResponseEntity(errorMessage, HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(UserNotFoundException::class)
    fun handleArticleNotFoundException(e: UserNotFoundException): ResponseEntity<ErrorMessageResponse> {
        val errorMessage = ErrorMessageResponse(
            HttpStatus.NOT_FOUND.value(),
            e.message
        )
        logger.error(e.message)
        return ResponseEntity(errorMessage, HttpStatus.NOT_FOUND)
    }

    @ExceptionHandler(DefaultException::class)
    fun handleDefaultException(e: DefaultException): ResponseEntity<ErrorMessageResponse> {
        val errorMessage = ErrorMessageResponse(
            HttpStatus.INTERNAL_SERVER_ERROR.value(),
            e.message
        )
        logger.error(e.message)
        return ResponseEntity(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR)
    }

    @ExceptionHandler(Exception::class)
    fun handleException(e: Exception): ResponseEntity<ErrorMessageResponse> {
        val errorMessage = ErrorMessageResponse(
            HttpStatus.INTERNAL_SERVER_ERROR.value(),
            e.message
        )
        logger.error("Unexpected error: ${e.message}")
        return ResponseEntity(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR)
    }
}