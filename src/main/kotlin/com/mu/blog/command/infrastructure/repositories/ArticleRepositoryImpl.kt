package com.mu.blog.command.infrastructure.repositories

import com.mu.blog.command.domain.contracts.ArticleRepository
import com.mu.blog.command.domain.models.Article
import com.mu.blog.command.infrastructure.converters.toDbo
import com.mu.blog.command.infrastructure.converters.toDomain
import com.mu.blog.common.infrastructure.db.dao.ArticleDao
import org.springframework.stereotype.Repository

@Repository
class ArticleRepositoryImpl(
    private val articleDao: ArticleDao
) : ArticleRepository {

    override fun save(article: Article): Article {
        val savedDbo = articleDao.save(article.toDbo())
        return savedDbo.toDomain()
    }

    override fun findByAuther(author: String): List<Article?> {
        return articleDao.findByAuthor(author).map { it?.toDomain() }
    }

    override fun findAll(): List<Article> {
        return articleDao.findAll().map { it.toDomain() }
    }

    override fun findById(id: Long): Article? {
        return articleDao.findById(id).orElse(null)?.toDomain()
    }
}