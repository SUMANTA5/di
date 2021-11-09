package com.sumanta.myapplication.network

import com.sumanta.myapplication.model.Post
import javax.inject.Inject

class PostServiceImp
@Inject constructor(
    private val potsApiService: PotsApiService
    ) {
    suspend fun getPost(): List<Post> = potsApiService.getPost()
}