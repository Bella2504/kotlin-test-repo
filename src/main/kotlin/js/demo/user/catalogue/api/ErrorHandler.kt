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
    @ExceptionHandler
    fun handleIllegalStateException(ex: IllegalStateException): ResponseEntity<ErrorMessageResponse> {

        val errorMessage = ErrorMessageResponse(
            HttpStatus.NOT_FOUND.value(),
            ex.message
        )
        return ResponseEntity(errorMessage, HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler
    fun handleArticleNotFoundException(ex: UserNotFoundException): ResponseEntity<ErrorMessageResponse> {
        val errorMessage = ErrorMessageResponse(
            HttpStatus.NOT_FOUND.value(),
            ex.message
        )
        return ResponseEntity(errorMessage, HttpStatus.NOT_FOUND)
    }

    @ExceptionHandler
    fun handleDefaultException(e: DefaultException): ResponseEntity<ErrorMessageResponse> {
        val errorMessage = ErrorMessageResponse(
            HttpStatus.INTERNAL_SERVER_ERROR.value(),
            e.message
        )
        logger.error("Could not update user: ${e.message}")
        return ResponseEntity(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR)
    }
}