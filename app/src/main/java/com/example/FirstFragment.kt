package com.example

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.navigation.fragment.findNavController
import com.example.new1.R
import com.example.new1.databinding.ActivityHomeBinding
import com.example.new1.databinding.FragmentFirstBinding
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import okhttp3.Dispatcher


class FirstFragment : Fragment() {

    private val scope= CoroutineScope(CoroutineName("Myscope"))
    private var _binding: FragmentFirstBinding?=null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ):View? {
        // Inflate the layout for this fragment
        _binding= FragmentFirstBinding.inflate(inflater,container, false)
        val mainJob=scope.launch {
            val job1=launch{
                while(true){
                    yield()
                    Log.d("Coroutine","Job 1 Running...")
                }
            }
            val job2=launch {
                Log.d("Coroutine","Job 2 Running...")
            }
            delay(1000L)
            Log.d("Coroutine","Job 1 Cancelling...")
            job2.cancelAndJoin()
            Log.d("Coroutine","Job 1 Cancelled")
        }
        runBlocking {
            delay(2000L)
            Log.d("Coroutine","Main job Cancelling...")
            mainJob.cancelAndJoin()
            Log.d("Coroutine","Main job Cancelled")
        }
        binding.clickButton.setOnClickListener {
            findNavController().navigate(R.id.action_firstFragment_to_secondFragment)
        }
        return binding.root
    }

    override fun onPause() {
        Log.d("Coroutine","Running...")
        super.onPause()
    }

    override fun onStop() {
        Log.d("Coroutine","Running...")
        super.onStop()
    }

    override fun onResume() {
        Log.d("Coroutine","Running...")
        super.onResume()
    }

    override fun onDestroy() {
        Log.d("Coroutine","Running...")
        super.onDestroy()
    }

}