package com.example.myapplication.Fragments

import android.graphics.Typeface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentUserProfileBinding

class UserProfile : Fragment() {
    private lateinit var binding: FragmentUserProfileBinding
    private lateinit var cardView: CardView
    private lateinit var buttonNewRequest: Button
    private lateinit var textNoRequests: TextView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUserProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val typeface = context?.let { ResourcesCompat.getFont(it, R.font.montserrat_bold) }
        binding.submited.typeface = typeface


        cardView = binding.cardViewRequest
        buttonNewRequest = binding.buttonNewRequest
        textNoRequests = binding.textNoRequests

        binding.underAnalysis.setOnClickListener {
            binding.underAnalysis.setTypeface(null, Typeface.BOLD)
            binding.submited.setTypeface(null, Typeface.NORMAL)

            cardView.visibility = View.GONE
            buttonNewRequest.visibility = View.GONE
            textNoRequests.visibility = View.VISIBLE
        }

        binding.submited.setOnClickListener {
            binding.submited.setTypeface(null, Typeface.BOLD)
            binding.underAnalysis.setTypeface(null, Typeface.NORMAL)

            textNoRequests.visibility = View.GONE
            buttonNewRequest.visibility = View.VISIBLE
            cardView.visibility = View.VISIBLE
        }
    }
}