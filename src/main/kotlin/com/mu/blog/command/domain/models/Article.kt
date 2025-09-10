package com.mu.blog.command.domain.models

import java.time.LocalDateTime

data class Article(
    val id: Long?,
    val title: String,
    val content: String,
    val author: String,
    val createdAt: LocalDateTime?,
) {
    companion object {
        fun createNew(title: String, content: String, author: String): Article {
            return Article(
                id = null,
                title = title,
                content = content,
                author = author,
                createdAt = LocalDateTime.now()
            )
        }
    }
}