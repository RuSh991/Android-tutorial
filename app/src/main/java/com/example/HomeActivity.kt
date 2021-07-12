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
import androidx.core.widget.doAfterTextChanged
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
import dagger.hilt.android.AndroidEntryPoint
import retrofit2.Response
import timber.log.Timber

@AndroidEntryPoint

class HomeActivity : AppCompatActivity() {

    private val model: NameViewModel by viewModels()
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // Other code to setup the activity...

        // Create the observer which updates the UI.
        // Observe the LiveData, passing in this activity as the LifecycleOwner and the observer.
        model.currentName.observe(this){
            binding.name.text=it.toString()
        }

        binding.clickButton.setOnClickListener {
            model.startTimeCounter()
        }
    }
}
//    private val viewModel by viewModels<MainViewModel>()
//    private lateinit var binding: ActivityHomeBinding
//    private lateinit var adapter: MyAdapter
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = ActivityHomeBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        adapter = MyAdapter()
////        binding.recyclerView.adapter=adapter
//        binding.password.doAfterTextChanged {
//            var input=it.toString()
//            if(input.matches("^(?=.*[0-9])(?=.*[a-z])([a-z0-9_-]+)\$".toRegex())){
//                Timber.i("Matched")
//            }
//            else{
//                Timber.i("Non-Matched")
//            }
//        }
//        viewModel.getPost3(2)
//        viewModel.myResponse3.observe(this, Observer { response ->
//            Timber.i(response.toString())
//            if (response.isSuccessful) {
//                this.adapter.submitList(response.body()!!)
//            }
//        })
//    }
//    override fun onStart(){
//        super.onStart()
//        Timber.i("onStart")
//    }
//    override fun onDestroy(){
//        super.onDestroy()
//        Timber.i("onDestroy")
//    }


