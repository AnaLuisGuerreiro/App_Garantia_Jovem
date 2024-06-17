package com.example.myapplication.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.Models.Item
import com.example.myapplication.databinding.ImageContainerBinding


data class Item(val image: Int, val text: String)

class ItemAdapter(private val itemList: List<Item>) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    class ItemViewHolder(var binding: ImageContainerBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = ImageContainerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = itemList[position]
        holder.binding.apply {
            imageCarousel.setImageResource(item.image)
            textOnImage.text = item.text
            layoutCarousel.setOnClickListener {
                Toast.makeText(holder.binding.root.context, item.text, Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun getItemCount() = itemList.size
}