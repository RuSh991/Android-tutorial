package com.example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.new1.databinding.ActivityHomeBinding
import java.lang.NullPointerException
import android.view.*
import com.example.new1.R

class HomeActivity : AppCompatActivity() {
    private lateinit var binding:ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.ruch.setOnClickListener {
            if(binding.cardy.visibility==View.VISIBLE){
                binding.cardy.visibility=View.INVISIBLE
            }
            else{
                binding.cardy.visibility=View.VISIBLE
            }
        }
        binding.btn.setOnClickListener {
            binding.root.setBackgroundColor(R.color.purple_700)
        }
    }
}