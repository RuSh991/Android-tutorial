package com.example.api

import com.example.model.Post
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface SimpleApi {
    @GET("posts/1 ")
    suspend fun getPost(): Response<Post>
    @GET("posts/{postNumber}")
    suspend fun getPost2(
        @Path("postNumber")number: Int
    ):Response<Post>
    @GET("posts")
    suspend fun getPost3(
        @Query("userid")number: Int
    ):Response<List<Post>>
}