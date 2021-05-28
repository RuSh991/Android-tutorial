package com.example.new1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.new1.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navController=findNavController(R.id.fragment)
        val appBarConfiguration= AppBarConfiguration(setOf(R.id.fragmentOne,R.id.fragmentTwo,R.id.fragmentThree) )
        binding.bottomNavigationView.setupWithNavController(navController)
    }
}
