package com.example.demo_app.model

data class PostsResponse(
    val limit: Int,
    val posts: List<Post>,
    val skip: Int,
    val total: Int
)

data class Post(
    val body: String,
    val id: Int,
    val reactions: Int,
    val tags: List<String>,
    val title: String,
    val userId: Int
)