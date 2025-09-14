package com.mu.blog.command.infrastructure.controllers

import com.mu.blog.command.application.models.ArticleResponseDTO
import com.mu.blog.command.application.models.CreateArticleCommand
import com.mu.blog.command.application.usecases.CreateArticleUseCase
import com.mu.blog.command.domain.models.Article
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/articles")
class ArticleController(
    private val createArticleUseCase: CreateArticleUseCase
) {
    @PostMapping
    fun createArticle(@RequestBody command: CreateArticleCommand): ResponseEntity<ArticleResponseDTO> {
        val request = CreateArticleCommand(
            title = command.title,
            content = command.content,
            author = command.author
        )
        val article = createArticleUseCase.execute(request)
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(article.toResponseDto())
    }

    fun Article.toResponseDto() = ArticleResponseDTO(
        id = this.id,
        title = this.title,
        content = this.content,
        author = this.author,
        createdAt = this.createdAt
    )
}