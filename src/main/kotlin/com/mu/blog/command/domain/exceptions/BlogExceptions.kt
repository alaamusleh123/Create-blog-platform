package com.mu.blog.command.domain.exceptions

open class BlogExceptions(message: String, cause: Throwable? = null) : RuntimeException(message, cause)

class ArticleNotFound(id: Long):
    BlogExceptions("Article with id $id not found")