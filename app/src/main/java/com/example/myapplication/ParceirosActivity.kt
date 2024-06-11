package com.example.myapplication

import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.databinding.ActivityLocalizacaoBinding
import com.example.myapplication.databinding.ActivityParceirosBinding

class ParceirosActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityParceirosBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        val mapa: ImageView = findViewById(R.id.mapa)
        mapa.setImageResource(R.drawable.mapa)

    }
}