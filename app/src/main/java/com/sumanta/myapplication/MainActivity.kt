package com.sumanta.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sumanta.myapplication.adapter.PostAdapter
import com.sumanta.myapplication.model.Post
import com.sumanta.myapplication.viewmodel.PostViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val postViewModel: PostViewModel by viewModels()
    private lateinit var recyclerView: RecyclerView
    private lateinit var postAdapter: PostAdapter
    private val progressBar: ProgressBar
        get() = findViewById(R.id.progressBar)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        postViewModel.response.observe(this, Observer {
            Log.d("main", it[0].body)
        })

    }
    private fun initUi() {
        recyclerView=findViewById(R.id.recyclerView)
        postAdapter= PostAdapter(this, ArrayList())
        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager= LinearLayoutManager(this@MainActivity)
            adapter=postAdapter
        }
    }
}