package com.example.myapplication.Adapters

import android.annotation.SuppressLint
import android.graphics.drawable.VectorDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.FAQ
import com.example.myapplication.R

class RecyclerViewAdapter (private var faqList: ArrayList<FAQ>) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    inner class ViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){

        val text_title = itemView.findViewById<TextView>(R.id.text_title)
        val text_description = itemView.findViewById<TextView>(R.id.text_description)
        val imgExpand: ImageView = itemView.findViewById(R.id.image_expand)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_design_faq, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return faqList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = faqList[position]

        holder.text_title.text = currentItem.questions
        holder.text_description.text = currentItem.answers
        holder.imgExpand.setImageResource(currentItem.image_expand)

        holder.imgExpand.setOnClickListener {

        if(holder.text_description.visibility == View.GONE) {
            holder.text_description.visibility = View.VISIBLE

            holder.imgExpand.setImageResource(R.drawable.minus)
        } else {
            holder.text_description.visibility = View.GONE

            holder.imgExpand.setImageResource(R.drawable.cross)
        }

        }

    }

}