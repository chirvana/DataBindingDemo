package com.example.bindingdemo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.bindingdemo.databinding.FragmentListDemoBinding
import com.example.bindingdemo.databinding.FragmentListDemoListBinding

class MyMovieRecyclerViewAdapter(
    private val values: List<String>
) : RecyclerView.Adapter<MyMovieRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = FragmentListDemoBinding.inflate( LayoutInflater.from(parent.context))
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.itemNumber.text = values[position]
        // execute pending binding if using databinding
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(val binding: FragmentListDemoBinding) : RecyclerView.ViewHolder(binding.root)

}