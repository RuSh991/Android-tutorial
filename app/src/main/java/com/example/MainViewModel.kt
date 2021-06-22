package com.example

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.model.Post
import com.example.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val repository: Repository):ViewModel() {
    val myResponse: MutableLiveData<Response<Post>> = MutableLiveData()
    val myResponse2: MutableLiveData<Response<Post>> = MutableLiveData()
    val myResponse3: MutableLiveData<Response<List<Post>>> = MutableLiveData()

    fun getPost(){
        viewModelScope.launch {
            val response=repository.getPost()
            myResponse.value=response
        }
    }

    fun getPost2(number:Int){
        viewModelScope.launch{
            val response=repository.getPost2(number)
            Log.d("Response", response.toString())
            myResponse2.value=response
        }
    }

    fun getPost3(number: Int){
        viewModelScope.launch {
            val response=repository.getPost3(number)
            Log.d("Response", response.toString())
            myResponse3.value=response
        }
    }
}