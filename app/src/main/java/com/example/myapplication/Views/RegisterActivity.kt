package com.example.myapplication.Views

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.R

class RegisterActivity : AppCompatActivity() {


    val listaOpcoes = arrayOf("O que procuras?", "Emprego", "Estágio", "Estudar", "Aprender Profissão", "Estudar/Trabalhar no Estrangeiro", "Ajuda")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_register)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.register)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val spinnerOptions: Spinner = findViewById(R.id.spinnerRegister)
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, listaOpcoes)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerOptions.adapter = adapter

        val buttonStart: Button = findViewById(R.id.buttonStart)

        buttonStart.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

            val firstNameEditText = findViewById<EditText>(R.id.firstName)
            val userName = firstNameEditText.text.toString().capitalize()

            val toast = Toast.makeText(applicationContext, "${userName}, o teu pedido foi submetido com sucesso", Toast.LENGTH_SHORT)
            toast.show()
        }



    }
}