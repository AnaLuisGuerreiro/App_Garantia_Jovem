package com.example.myapplication.Views

import android.content.Intent
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

        binding.criaOTeuEmprego.setOnClickListener{
            val intent = Intent(this, SelectedInfoActivity::class.java)
            startActivity(intent)
        }


        val imageView1: ImageView = findViewById(R.id.imageView1)
        imageView1.setImageResource(R.drawable.image2)

        val imageView2: ImageView = findViewById(R.id.imageView2)
        imageView2.setImageResource(R.drawable.image3)


    }
}
