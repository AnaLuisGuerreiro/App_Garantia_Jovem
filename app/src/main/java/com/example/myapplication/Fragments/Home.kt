package com.example.myapplication.Fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.Adapters.ItemAdapter
import com.example.myapplication.Models.Item
import com.example.myapplication.R
import com.example.myapplication.Views.RegisterActivity
import com.example.myapplication.databinding.FragmentHomeBinding


class Home : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var adapter: ItemAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val list = listOf(
            Item(R.drawable.img1_carousel, "Se tens entre\n15 e 29 anos\nde idade"),
            Item(R.drawable.img2_carousel, "Se não estás\na trabalhar\nnem a estudar"),
            Item(R.drawable.img3_carousel, "Se não estás\ninscrito no\nIEFP-Centro\nde Emprego"),
            Item(R.drawable.img4_carousel, "Basta uma\ninscrição para\ncomeçar")
        )

        adapter = ItemAdapter(list)


        binding.carousel.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.carousel.adapter = adapter

        binding.carousel.setHasFixedSize(true)

        binding.imageLetsGo.setOnClickListener {
            val intent = Intent(requireContext(), RegisterActivity::class.java)
            startActivity(intent)
        }


        binding.buttonJobs.setOnClickListener{
            loadFragment(SelectionMenuFragment())
        }

        binding.buttonInternship.setOnClickListener{
            loadFragment(EstagioFragment())
        }
    }

    private fun loadFragment(fragment: Fragment) {
        val transaction = parentFragmentManager.beginTransaction()
        transaction.replace(R.id.frameLayout, fragment)
        transaction.commit()
    }
}



