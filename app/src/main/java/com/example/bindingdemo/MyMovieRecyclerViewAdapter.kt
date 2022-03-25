package com.example.bindingdemo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyMovieRecyclerViewAdapter(
    private val values: List<String>
) : RecyclerView.Adapter<MyMovieRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.fragment_list_demo, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.idView.text = values[position]
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        val idView: TextView = itemView.findViewById(R.id.item_number)
    }

}