package com.sumanta.myapplication.rapo

import com.sumanta.myapplication.model.Post
import com.sumanta.myapplication.network.PostServiceImp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class PostRepository
@Inject
constructor(private val postApiServiceImp: PostServiceImp) {

    fun getPost(): Flow<List<Post>> = flow {
        val response = postApiServiceImp.getPost()
        emit(response)
    }.flowOn(Dispatchers.IO)

}