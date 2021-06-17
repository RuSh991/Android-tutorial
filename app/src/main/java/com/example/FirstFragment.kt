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

    private val scope = CoroutineScope(CoroutineName("Myscope"))
    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentFirstBinding.inflate(inflater, container, false)

        GlobalScope.launch(Dispatchers.IO) {
            Log.d("Coroutine", this.coroutineContext.toString())
            withContext(Dispatchers.Main){
                Log.d("Coroutine", this.coroutineContext.toString())
            }
        }
        binding.clickButton.setOnClickListener {
            findNavController().navigate(R.id.action_firstFragment_to_secondFragment)
        }
        return binding.root
    }
}