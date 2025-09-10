package com.mu.blog.common.infrastructure.db.dao

import com.mu.blog.common.models.ArticleDbo
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface ArticleDao : JpaRepository<ArticleDbo, Long>{
    @Query("SELECT a FROM ArticleDbo a WHERE a.author = :author")
    fun findByAuthor(
        @Param("author") author: String,
    ): List<ArticleDbo?>
}