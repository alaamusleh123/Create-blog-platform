package com.mu.blog.queries.application.usecases

import com.mu.blog.command.domain.contracts.ArticleRepository
import com.mu.blog.command.domain.models.Article
import org.springframework.stereotype.Service

@Service
class GetArticlesByAuthorUseCase(
    private val articleRepository: ArticleRepository
) {
    fun execute(author: String): List<Article?> = articleRepository.findByAuther(author)
}