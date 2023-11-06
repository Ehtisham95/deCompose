package com.example.demo_app.network

import com.example.demo_app.model.PostCommentsResponse
import com.example.demo_app.model.PostsResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface PostsService {

    @GET("posts")
    suspend fun getPosts(): PostsResponse

    @GET("posts/{postId}/comments")
    suspend fun getPostComments(@Path("postId") postId: String): PostCommentsResponse
}
