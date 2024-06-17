package com.example.myapplication.Fragments
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.example.myapplication.R


class NovoPedidoFragment : Fragment() {

    val listaOpcoes = arrayOf("O que procuras?", "Emprego", "Estágio", "Estudar", "Aprender Profissão", "Estudar/Trabalhar no Estrangeiro", "Ajuda")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_novo_pedido, container, false)

        // Set up the spinner
        val spinnerOptions: Spinner = view.findViewById(R.id.spinnerRegisto)
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, listaOpcoes)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerOptions.adapter = adapter

        return view
    }

}