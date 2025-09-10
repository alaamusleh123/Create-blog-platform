package com.mu.blog.common.infrastructure.db.dao

import com.mu.blog.common.models.ArticleDbo
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface ArticleDao : JpaRepository<ArticleDbo, Long>{
    @Query(""" 
     SELECT a FROM ArticleDbo a 
     WHERE a.id = :id
       AND a.author = :author
       AND a.title = :title
       And a.content = :content
       AND a.createdAt = :createdAt
     """)
    fun findByAuthor(
        @Param("author") author: String,
    ): List<ArticleDbo?>
}