package com.example.myapplication.Views

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityLocalizacaoBinding

class LocalizacaoActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityLocalizacaoBinding.inflate(layoutInflater)
    }

    val listaConselhos = arrayOf("Conselhos","Arouca","Espinho","Guarda", "Moita", "Portel")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        val mapa: ImageView = findViewById(R.id.mapa)
        mapa.setImageResource(R.drawable.mapa)

        val spinner = findViewById<Spinner>(R.id.spinner)
        val arrayAdapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,listaConselhos)
        spinner.adapter=arrayAdapter
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                Toast.makeText(applicationContext, "Conselho selecionado: " + listaConselhos[position], Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }


    }
}