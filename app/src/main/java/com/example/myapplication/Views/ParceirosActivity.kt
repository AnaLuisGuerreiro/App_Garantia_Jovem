package com.example.myapplication.Views

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityParceirosBinding

class ParceirosActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityParceirosBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        binding.mapa.setImageResource(R.drawable.mapa)

    }
}