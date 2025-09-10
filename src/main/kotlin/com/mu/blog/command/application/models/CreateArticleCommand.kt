package com.mu.blog.command.application.models

data class CreateArticleCommand(
    val title: String,
    val content: String,
    val author: String
)