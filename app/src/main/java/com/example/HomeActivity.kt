package com.example

import android.graphics.ColorSpace
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.new1.databinding.ActivityHomeBinding
import java.lang.NullPointerException
import android.view.*
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.BlurTransformation
import coil.transform.RoundedCornersTransformation
import com.example.model.Post
import com.example.new1.R
import com.example.repository.Repository
import retrofit2.Response

class HomeActivity : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel
    private lateinit var binding: ActivityHomeBinding
    private lateinit var adapter: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        adapter = MyAdapter()
        binding.recyclerView.adapter=adapter

        viewModel.getPost3(2)
        viewModel.myResponse3.observe(this, Observer { response ->
            Log.d("GET", response.toString())
            if (response.isSuccessful) {
                this.adapter.submitList(response.body()!!)
            }
        })
    }
}
