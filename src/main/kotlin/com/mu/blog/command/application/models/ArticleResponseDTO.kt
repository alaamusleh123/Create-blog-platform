package com.mu.blog.command.application.models

import java.time.LocalDateTime

data class ArticleResponseDTO(
    val id: Long?,
    val title: String,
    val content: String,
    val author: String,
    val createdAt: LocalDateTime?
)