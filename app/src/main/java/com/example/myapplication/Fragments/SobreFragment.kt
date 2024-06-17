package com.example.myapplication.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentSobreBinding

class SobreFragment : Fragment() {
    private lateinit var binding: FragmentSobreBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSobreBinding.inflate(inflater, container, false)
        val view = binding.root

        val imageView1: ImageView = binding.imageView1
        imageView1.setImageResource(R.drawable.rapaz_sobre)

        val imageView2: ImageView = binding.imageView2
        imageView2.setImageResource(R.drawable.image3)

        return view
    }

}