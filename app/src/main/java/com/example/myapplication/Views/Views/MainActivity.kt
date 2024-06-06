package com.example.myapplication.Views.Views

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager2.widget.ViewPager2
import com.example.myapplication.Adapters.ViewPagerAdapter
import com.example.myapplication.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var viewPagerMain: ViewPager2
    private lateinit var viewPagerAdapter: ViewPagerAdapter
    private lateinit var bottomNavigationView: BottomNavigationView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        bottomNavigationView = findViewById(R.id.bottomNav)
        viewPagerMain = findViewById(R.id.viewPagerMain)
        viewPagerAdapter = ViewPagerAdapter(this)
        viewPagerMain.adapter = viewPagerAdapter

        bottomNavigationView.itemIconTintList = null

        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.bottom_geo -> {
                    viewPagerMain.currentItem = 0
                    true
                }
                R.id.bottom_home -> {
                    viewPagerMain.currentItem = 1
                    true
                }
                R.id.bottom_phone -> {
                    viewPagerMain.currentItem = 2
                    true
                }
                else -> false
            }
        }

        // Register page change callback
        viewPagerMain.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                when (position) {
                    0 -> bottomNavigationView.selectedItemId = R.id.bottom_geo
                    1 -> bottomNavigationView.selectedItemId = R.id.bottom_home
                    2 -> bottomNavigationView.selectedItemId = R.id.bottom_phone
                }
            }
        })
    }



}