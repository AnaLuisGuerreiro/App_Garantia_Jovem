package com.example.myapplication.Views.Views

import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.databinding.ActivitySelectionMenuBinding

class SelectionMenuActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivitySelectionMenuBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)


        val imageView1: ImageView = findViewById(R.id.imageView1)
        imageView1.setImageResource(R.drawable.image2)

        val imageView2: ImageView = findViewById(R.id.imageView2)
        imageView2.setImageResource(R.drawable.image3)


    }
}
