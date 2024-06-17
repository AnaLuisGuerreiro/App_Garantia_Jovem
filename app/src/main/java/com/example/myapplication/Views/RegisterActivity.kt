package com.example.myapplication.Views

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.R

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_register)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.register)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val buttonStart: Button = findViewById(R.id.buttonStart)

        buttonStart.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            val toast = Toast.makeText(applicationContext, "Filipe, o teu pedido foi submetido com sucesso", Toast.LENGTH_SHORT)
            toast.show()
        }

    }
}