package com.example.repository

import com.example.api.RetrofitInstance
import com.example.model.Post
import retrofit2.Response
import retrofit2.Retrofit

class Repository {

    suspend fun getPost(): Response<Post> {
        return RetrofitInstance.api.getPost()
    }

    suspend fun getPost2(number: Int): Response<Post>{
        return RetrofitInstance.api.getPost2(number)
    }

    suspend fun getPost3(number: Int): Response<List<Post>>{
        return RetrofitInstance.api.getPost3(number)
    }
}