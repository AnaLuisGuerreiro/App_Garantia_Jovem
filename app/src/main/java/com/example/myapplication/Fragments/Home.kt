package com.example.myapplication.Fragments

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.example.myapplication.Adapters.ImageAdapter
import com.example.myapplication.R
import kotlin.math.abs

class Home : Fragment() {

    private lateinit var viewPagerCarousel: ViewPager2
    private lateinit var handler: Handler
    private lateinit var imageList: ArrayList<Int>
    private lateinit var adapter: ImageAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        init(view)
        setUpTransformer()
        return view
    }

    private fun init(view: View) {
        viewPagerCarousel = view.findViewById(R.id.viewPagerCarousel)
        viewPagerCarousel = view.findViewById(R.id.viewPagerCarousel)
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
        transform.addTransformer(MarginPageTransformer(30))
        transform.addTransformer { page, position ->
            val r = 1 - abs(position)
            page.scaleY = 0.90f + r * 0.10f
        }
        viewPagerCarousel.setPageTransformer(transform)
    }
}
