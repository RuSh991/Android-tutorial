package com.example

import android.os.CountDownTimer
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.model.Post
import com.example.repository.Repository
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject
//
//@HiltViewModel
//
//class MainViewModel @Inject constructor(private val repository: Repository):ViewModel() {
//    val myResponse: MutableLiveData<Response<Post>> = MutableLiveData()
//    val myResponse2: MutableLiveData<Response<Post>> = MutableLiveData()
//    val myResponse3: MutableLiveData<Response<List<Post>>> = MutableLiveData()
//
//    fun getPost(){
//        viewModelScope.launch {
//            val response=repository.getPost()
//            myResponse.value=response
//        }
//    }
//
//    fun getPost2(number:Int){
//        viewModelScope.launch{
//            val response=repository.getPost2(number)
//            Log.d("Response", response.toString())
//            myResponse2.value=response
//        }
//    }
//
//    fun getPost3(number: Int){
//        viewModelScope.launch {
//            val response=repository.getPost3(number)
//            Log.d("Response", response.toString())
//            myResponse3.value=response
//        }
//    }
//}
//@HiltViewModel
//
//class MainViewModel @Inject constructor(private val repository: Repository):ViewModel() {
//    val myResponse: MutableLiveData<Response<Post>> = MutableLiveData()
//    val myResponse2: MutableLiveData<Response<Post>> = MutableLiveData()
//    val myResponse3: MutableLiveData<Response<List<Post>>> = MutableLiveData()
//
//    fun getPost(){
//        viewModelScope.launch {
//            val response=repository.getPost()
//            myResponse.value=response
//        }
//    }
//
//    fun getPost2(number:Int){
//        viewModelScope.launch{
//            val response=repository.getPost2(number)
//            Log.d("Response", response.toString())
//            myResponse2.value=response
//        }
//    }
//
//    fun getPost3(number: Int){
//        viewModelScope.launch {
//            val response=repository.getPost3(number)
//            Log.d("Response", response.toString())
//            myResponse3.value=response
//        }
//    }
//}

class NameViewModel : ViewModel() {

    val currentName: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }

    fun startTimeCounter() {
        object : CountDownTimer(50000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                currentName.value = (millisUntilFinished/1000).toInt()
            }

            override fun onFinish() {
            }
        }.start()
    }
}