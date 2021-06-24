
package com.example

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.model.Post
import com.example.new1.R
import com.google.android.material.imageview.ShapeableImageView

class MyAdapter() : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
private var rList= emptyList<Post>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView=LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem=rList[position]
        holder.titleText.text=currentItem.title
        holder.body.text=currentItem.body
    }

    override fun getItemCount(): Int {
        return rList.size
    }

    fun submitList(rList: List<Post>){
        this.rList=rList
        notifyDataSetChanged()
    }

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val titleText: TextView= itemView.findViewById(R.id.title)
        val body: TextView=itemView.findViewById(R.id.body)
    }
}

