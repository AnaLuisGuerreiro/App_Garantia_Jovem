package com.example.myapplication.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentPartnersBinding
import com.example.myapplication.databinding.FragmentPartnersEstagioBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [PartnersEstagioFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PartnersEstagioFragment : Fragment() {
    private var _binding: FragmentPartnersEstagioBinding? = null
    private val binding get() = _binding!!

    val listaConselhos = arrayOf("Porto")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPartnersEstagioBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.mapa.setImageResource(R.drawable.mapa)

        val spinner = binding.spinner
        val arrayAdapter = ArrayAdapter<String>(
            requireContext(),
            android.R.layout.simple_spinner_dropdown_item,
            listaConselhos
        )
        spinner.adapter = arrayAdapter
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }


    }
}