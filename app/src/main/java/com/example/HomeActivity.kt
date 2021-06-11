package com.example

import android.graphics.ColorSpace
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
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.new1.R

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private val viewModel by viewModels<MainActivityViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.seconds().observe(this, Observer{
            binding.numberTxt.text=it.toString()
        })
        viewModel.finished.observe(this,Observer{
            if(it){
                Toast.makeText(this,"Finished!",Toast.LENGTH_SHORT).show()
            }
        })
        binding.button1.setOnClickListener {
            if(binding.editTextTextPersonName.text.isEmpty() || binding.editTextTextPersonName.text.length<4){
                Toast.makeText(this,"Invalid input",Toast.LENGTH_LONG).show()
            }
            else{
                viewModel.timerValue.value=binding.editTextTextPersonName.text.toString().toLong()
                viewModel.startTimer()
            }
        }
        binding.button2.setOnClickListener {
            viewModel.stopTimer()
        }
    }
}