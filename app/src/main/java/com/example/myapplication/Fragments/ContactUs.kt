package com.example.myapplication.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentContactUsBinding

class ContactUs<T> : Fragment() {

    private var _binding: FragmentContactUsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment using view binding
        _binding = FragmentContactUsBinding.inflate(inflater, container, false)
        val view = binding.root

        // Set an onClickListener for the button
        binding.button.setOnClickListener {
            // Clear the EditText fields
            binding.nome.setText("")
            binding.assunto.setText("")
            binding.email.setText("")
            binding.mensagem.setText("")

            // Show a Toast message
                Toast.makeText(requireContext(), "Agradecemos a sua mensagem. Assim que possível será contactado(a).", Toast.LENGTH_LONG).show()
        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}