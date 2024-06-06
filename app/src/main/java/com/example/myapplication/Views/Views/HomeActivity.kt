package com.example.myapplication.Views.Views

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.example.myapplication.Adapters.ImageAdapter
import com.example.myapplication.R
import kotlin.math.abs

class HomeActivity : AppCompatActivity() {
    private lateinit var viewPagerCarousel: ViewPager2
    private lateinit var handler: Handler
    private lateinit var imageList: ArrayList<Int>
    private lateinit var adapter: ImageAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        init()
        setUpTransformer()
    }

    private fun init() {
        viewPagerCarousel = findViewById(R.id.viewPagerCarousel)
        handler = Handler(Looper.myLooper()!!)
        imageList = ArrayList()

        imageList.add(R.drawable.img1_carousel)
        imageList.add(R.drawable.img2_carousel)
        imageList.add(R.drawable.img3_carousel)
        imageList.add(R.drawable.img4_carousel)

        adapter = ImageAdapter(viewPagerCarousel, imageList)

        viewPagerCarousel.adapter = adapter
        viewPagerCarousel.offscreenPageLimit = 3
        viewPagerCarousel.clipToPadding = false
        viewPagerCarousel.clipChildren = false
        viewPagerCarousel.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER
    }

    private fun setUpTransformer() {
        val transform = CompositePageTransformer()
        transform.addTransformer(MarginPageTransformer(40))
        transform.addTransformer { page, position ->
            val r = 1 - abs(position)
            page.scaleY = 0.85f + r * 0.15f
        }
        viewPagerCarousel.setPageTransformer(transform)
    }
}