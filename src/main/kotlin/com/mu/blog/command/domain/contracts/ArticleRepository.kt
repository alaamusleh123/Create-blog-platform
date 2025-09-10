package com.mu.blog.command.domain.contracts

import com.mu.blog.command.domain.models.Article

interface ArticleRepository {
    fun save(article: Article): Article
    fun findByAuther(author: String): List<Article?>
}