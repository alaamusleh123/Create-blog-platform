package com.mu.blog.command.infrastructure.controllers

import com.mu.blog.command.application.models.ArticleResponseDTO
import com.mu.blog.command.application.models.UpdateArticleCommand
import com.mu.blog.command.application.usecases.UpdateArticleUseCase
import com.mu.blog.command.domain.exceptions.ArticleNotFound
import com.mu.blog.command.domain.models.Article
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.ErrorResponse
import org.springframework.web.bind.annotation.*
import java.time.LocalTime

@RestController
@RequestMapping("/api/articles/{id}")
class UpdateArticleController(
    private val updateArticleUseCase: UpdateArticleUseCase
) {
    @PutMapping
    fun updateArticle(@PathVariable id: Long, @RequestBody command: UpdateArticleCommand):
            ResponseEntity<ArticleResponseDTO> {
        val updated = updateArticleUseCase.execute(command.copy(id = id))
        return ResponseEntity.ok(updated.toResponseDto())
    }

    fun Article.toResponseDto() = ArticleResponseDTO(
        id = this.id,
        title = this.title,
        content = this.content,
        author = this.author,
        createdAt = this.createdAt,
        updatedAt = this.updatedAt
    )
}