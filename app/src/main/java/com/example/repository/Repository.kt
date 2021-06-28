package com.example.repository

import com.example.api.SimpleApi
import com.example.model.Post
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Repository @Inject constructor(private val simpleApi: SimpleApi) {

    suspend fun getPost(): Response<Post> {
        return simpleApi.getPost()
    }

    suspend fun getPost2(number: Int): Response<Post>{
        return simpleApi.getPost2(number)
    }

    suspend fun getPost3(number: Int): Response<List<Post>>{
        return simpleApi.getPost3(number)
    }
}