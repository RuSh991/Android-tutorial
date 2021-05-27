package com.example.new1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.new1.databinding.ActivityMainBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.submit.setOnClickListener {
            var new = binding.emailid.text.toString()
            var neww = binding.password.text.toString()
            if ((new.isNotEmpty()) && (neww.isNotEmpty()) && (neww.length >= 8)) {
                myFunction(new, neww)
            } else {
                Toast.makeText(this, "Invalid Input", Toast.LENGTH_LONG).show()
            }

        }
    }

    fun myFunction(x: String, y: String) {

        if ((x == "xyz@mail.com") && (y == "xyzzxcct")) {
            Toast.makeText(this, "Successful", Toast.LENGTH_LONG).show()
        }
        else{
            Log.i("TAG", "myFunction: ")
        }
    }

}