package com.example.myapplication.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentWhereAreWeBinding

class WhereAreWe : Fragment() {

    private var _binding: FragmentWhereAreWeBinding? = null
    private val binding get() = _binding!!

    val listaConcelhos = arrayOf("Concelhos","Abrantes","Águeda","Aguiar da Beira","Alandroal","Albergaria-a-Velha","Albufeira","Alcácer do Sal","Almada","Arouca","Baião", "Barcelos", "Barrancos", "Barreiro", "Batalha", "Beja", "Belmonte", "Benavente", "Bombarral", "Borba", "Boticas", "Braga","Espinho","Guarda", "Moita", "Portel")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentWhereAreWeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val mapa: ImageView = binding.mapa
        mapa.setImageResource(R.drawable.mapa)

        val spinner = binding.spinner
        val arrayAdapter = ArrayAdapter<String>(requireContext(), android.R.layout.simple_spinner_dropdown_item, listaConcelhos)
        spinner.adapter = arrayAdapter
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                Toast.makeText(requireContext(), "Conselho selecionado: " + listaConcelhos[position], Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // No action needed
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}