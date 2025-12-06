package com.mu.blog.queries.infrastructure.controllers

import com.mu.blog.command.application.models.ArticleResponseDTO
import com.mu.blog.command.domain.models.Article
import com.mu.blog.queries.application.usecases.GetAllArticlesUseCase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/articles")
class GetArticlesController(
    private val getAllArticlesUseCase: GetAllArticlesUseCase
) {
    @GetMapping
    fun getAllArticles(): ResponseEntity<List<ArticleResponseDTO>> {
        val articles = getAllArticlesUseCase.execute().map { it.toResponseDto() }
        return ResponseEntity.ok(articles)
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