package com.example.myapplication.Views.Views

import android.animation.LayoutTransition
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivitySelectedInfoBinding
import com.example.myapplication.databinding.ActivitySelectionMenuBinding

class SelectedInfoActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivitySelectedInfoBinding.inflate(layoutInflater)
    }

    private lateinit var information:TextView
    private lateinit var layout: LinearLayout
    private lateinit var expandable: CardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        information = findViewById(R.id.information)
        layout = findViewById(R.id.layouts)
        expandable = findViewById(R.id.expandable)

        layout.layoutTransition.enableTransitionType(LayoutTransition.CHANGING)
        expandable.setOnClickListener {
            val v = if (information.visibility == View.GONE) View.VISIBLE else View.GONE
            information.visibility = v
        }
        val imageView1: ImageView = findViewById(R.id.imageView1)
        imageView1.setImageResource(R.drawable.image2)
    }
}