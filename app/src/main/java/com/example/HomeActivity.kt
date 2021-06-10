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
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.new1.R

class HomeActivity : AppCompatActivity() {

    private lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayList: ArrayList<Unicorn>
    lateinit var imageId: Array<Int>
    lateinit var heading: Array<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        imageId= arrayOf(
            R.drawable.ic_home,
            R.drawable.ic_profile,
            R.drawable.ic_snow,
            R.drawable.ic_settings
        )

        heading= arrayOf(
            "ONE",
            "TWO",
            "THREE",
            "FOUR"
        )

        newRecyclerView=findViewById(R.id.recyclerView)
        newRecyclerView.layoutManager=LinearLayoutManager(this)
        newRecyclerView.setHasFixedSize(true)
        newArrayList= arrayListOf<Unicorn>()
        getUserData()

    }

    private fun getUserData() {
        for(i in imageId.indices){
            val unicorn=Unicorn(imageId[i],heading[i])
            newArrayList.add(unicorn)
            newRecyclerView.adapter=MyAdapter(newArrayList)
        }
    }
}