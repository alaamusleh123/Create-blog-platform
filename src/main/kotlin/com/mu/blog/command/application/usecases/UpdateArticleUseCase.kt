package com.mu.blog.command.application.usecases

import com.mu.blog.command.application.models.UpdateArticleCommand
import com.mu.blog.command.domain.contracts.ArticleRepository
import com.mu.blog.command.domain.exceptions.ArticleNotFound
import com.mu.blog.command.domain.models.Article
import org.springframework.stereotype.Service

@Service
class UpdateArticleUseCase(
    private val articleRepository: ArticleRepository
) {
    fun execute(command: UpdateArticleCommand): Article {
        val existing = articleRepository.findById(command.id)
            ?: throw ArticleNotFound(command.id)

        val updated = existing.update(command.title, command.content)
        return articleRepository.save(updated)
    }
}