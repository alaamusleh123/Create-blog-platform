package com.mu.blog.common.models

import jakarta.persistence.*
import org.springframework.data.annotation.CreatedDate
import java.time.LocalDateTime

@Entity
@Table(name = "articles", schema = "public")
@SequenceGenerator(name = "baseSequence", sequenceName = "articles_id_seq", allocationSize = 1)
data class ArticleDbo(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "baseSequence")
    var id: Long? = null,

    @Column(nullable = false)
    val title: String,

    @Column(nullable = false, columnDefinition = "text")
    val content: String,

    @Column(nullable = false)
    val author: String,

    @Column(name = "created_at", nullable = false, updatable = false)
    @CreatedDate
    var createdAt: LocalDateTime = LocalDateTime.now()
)