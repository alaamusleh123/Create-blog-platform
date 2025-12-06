package com.mu.blog.command.application.models

data class UpdateArticleCommand(
    val id: Long,
    val title: String,
    val content: String
)