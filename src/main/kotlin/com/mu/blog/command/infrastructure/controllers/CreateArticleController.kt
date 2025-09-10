package com.mu.blog.command.infrastructure.controllers

import com.mu.blog.command.application.usecases.CreateArticleUseCase
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/articles")
class CreateArticleController(
    private val createArticleUseCase: CreateArticleUseCase
) {



}