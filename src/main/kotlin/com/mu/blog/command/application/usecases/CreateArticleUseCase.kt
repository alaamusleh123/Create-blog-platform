package com.mu.blog.command.application.usecases

import com.mu.blog.command.application.models.CreateArticleCommand
import com.mu.blog.command.domain.contracts.ArticleRepository
import com.mu.blog.command.domain.models.Article
import org.springframework.stereotype.Service

@Service
class CreateArticleUseCase(
    private val articleRepository: ArticleRepository
) {
    fun execute(command: CreateArticleCommand): Article {

    }
}