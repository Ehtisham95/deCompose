package com.example.demo_app.repository

import com.example.demo_app.model.PostCommentsResponse
import com.example.demo_app.model.PostsResponse
import com.example.demo_app.network.PostsService
import com.example.demo_app.network.handleRequest
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class PostRepo @Inject constructor(
    private val postsService: PostsService
) {

    suspend fun getAllPosts(): Result<PostsResponse> {
        return handleRequest { postsService.getPosts() }
    }

    suspend fun getPostComments(postId: String): Result<PostCommentsResponse> {
        return handleRequest { postsService.getPostComments(postId) }
    }
}
