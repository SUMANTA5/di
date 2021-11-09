package com.sumanta.myapplication.viewmodel

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.sumanta.myapplication.model.Post
import com.sumanta.myapplication.rapo.PostRepository
import kotlinx.coroutines.flow.catch

class PostViewModel
@ViewModelInject
constructor
    (private val postRepository: PostRepository) : ViewModel() {

        val response: LiveData<List<Post>> = postRepository.getPost()
            .catch { e->
                Log.d("main","${e.message}")
            }.asLiveData()
}