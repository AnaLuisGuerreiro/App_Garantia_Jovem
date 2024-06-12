package com.example.myapplication.Views

import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityLocalizacaoBinding

class LocalizacaoActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityLocalizacaoBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        val mapa: ImageView = findViewById(R.id.mapa)
        mapa.setImageResource(R.drawable.mapa)

    }
}