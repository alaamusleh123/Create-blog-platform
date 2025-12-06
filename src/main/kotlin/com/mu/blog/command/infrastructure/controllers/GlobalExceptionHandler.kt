package com.mu.blog.command.infrastructure.controllers

import com.mu.blog.command.domain.exceptions.ArticleNotFound
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {

    private val logger = LoggerFactory.getLogger(UpdateArticleController::class.java)

    @ExceptionHandler(ArticleNotFound::class)
    fun handleArticleNotFoundException(ex: ArticleNotFound): ResponseEntity<ErrorResponse> {
        logger.error("Error: {}", ex.message)
        return ResponseEntity
            .status(HttpStatus.NOT_FOUND)
            .body(ErrorResponse(message = ex.message ?: "Article not found"))
    }
}

data class ErrorResponse(
    val message: String
)