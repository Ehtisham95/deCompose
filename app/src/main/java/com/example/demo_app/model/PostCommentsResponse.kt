package com.example.demo_app.model

data class PostCommentsResponse(
    val comments: List<Comment>,
    val limit: Int,
    val skip: Int,
    val total: Int
)

data class Comment(
    val body: String,
    val id: Int,
    val postId: Int,
    val user: User
)

data class User(
    val id: Int,
    val username: String
)