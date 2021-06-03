package com.example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.new1.databinding.ActivityHomeBinding
import java.lang.NullPointerException

class HomeActivity : AppCompatActivity() {
    private lateinit var binding:ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.Plus.setOnClickListener {
            val one =binding.First.text.toString()
            val two =binding.Second.text.toString()

            if(one.isNotEmpty() && two.isNotEmpty()){
                val result=one.toInt()+two.toInt()
                binding.textView.text= result.toString()
            }
        }
        binding.Minus.setOnClickListener {
            val one =binding.First.text.toString()
            val two =binding.Second.text.toString()

            if(one.isNotEmpty() && two.isNotEmpty()){
                binding.textView.text= subtract(one.toInt(), two.toInt())
            }
        }
    }
    fun subtract(x: Int, y: Int):String{
        val result=x-y
        return result.toString()
    }
}