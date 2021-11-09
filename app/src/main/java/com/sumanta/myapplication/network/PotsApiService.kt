package com.sumanta.myapplication.network

import com.sumanta.myapplication.model.Post
import retrofit2.http.GET

interface PotsApiService {

    @GET("posts")
    suspend fun getPost(): List<Post>


}