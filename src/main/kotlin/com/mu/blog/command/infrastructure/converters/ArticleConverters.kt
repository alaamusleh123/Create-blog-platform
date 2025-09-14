package com.mu.blog.command.infrastructure.converters

import com.mu.blog.command.domain.models.Article
import com.mu.blog.common.models.ArticleDbo

fun Article.toDbo() = ArticleDbo(
    id = this.id,
    title = this.title,
    author = this.author,
    content = this.content,
    createdAt = this.createdAt!!
)

fun ArticleDbo.toDomain(): Article =
    Article(
        id = this.id,
        title = this.title,
        content = this.content,
        author = this.author,
        createdAt = this.createdAt
    )