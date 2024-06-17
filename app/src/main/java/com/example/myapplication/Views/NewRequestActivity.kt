package com.example.myapplication.Views

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityNewRequestBinding

class NewRequestActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNewRequestBinding

    val listaOpcoes = arrayOf("O que procuras?", "Emprego", "Estágio", "Estudar", "Aprender Profissão", "Estudar/Trabalhar no Estrangeiro", "Ajuda")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_new_request)

        binding = ActivityNewRequestBinding.inflate(layoutInflater)
        val root = binding.root
        setContentView(root)

        // Set up insets listener using binding
        ViewCompat.setOnApplyWindowInsetsListener(binding.newRequest) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Set up the spinner using binding
        val spinnerOptions = binding.spinnerRegister
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, listaOpcoes)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerOptions.adapter = adapter

        binding.makeNewRequest.setOnClickListener{
            val i = Intent(this, MainActivity::class.java)
            i.putExtra("fragment","secondUserProfile")
            startActivity(i)
        }
    }
}