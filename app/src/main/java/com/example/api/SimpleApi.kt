package com.example.api

import com.example.model.Post
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface SimpleApi {
    @GET("/posts/1 ")
    suspend fun getPost(): Response<Post>
    @GET("posts{postNumber")
    suspend fun getPost2(
        @Path("postnumber")number: Int
    ):Response<Post>

}