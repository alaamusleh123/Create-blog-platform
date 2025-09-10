package com.mu.blog.queries.infrastructure.controllers

import com.mu.blog.command.application.models.ArticleResponseDTO
import com.mu.blog.command.domain.models.Article
import com.mu.blog.queries.application.usecases.GetArticlesByAuthorUseCase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/articles/author/{author}")
class GetArticlesByAuthorController(
    private val getArticlesByAuthorUseCase: GetArticlesByAuthorUseCase
) {
    @GetMapping
    fun getArticlesByAuthor(@PathVariable author: String): ResponseEntity<List<ArticleResponseDTO>> {
        val articles = getArticlesByAuthorUseCase.execute(author).mapNotNull { it?.toResponseDto() }
        return ResponseEntity.ok(articles)
    }

    fun Article.toResponseDto() = ArticleResponseDTO(
        id = this.id,
        title = this.title,
        content = this.content,
        author = this.author,
        createdAt = this.createdAt
    )
}