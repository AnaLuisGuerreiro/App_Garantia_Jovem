package com.example.myapplication.Views

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityLoginBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.login) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }



        binding.buttonLogin.setOnClickListener {

            val email = binding.email.text.toString()
            val password = binding.password.text.toString()

            if (email == "filipe.araujo.prt_a@msft.cesae.pt" && password == "12345") {

                val i = Intent(this, MainActivity::class.java)
                i.putExtra("codeFrag","userProfile")
                startActivity(i)
            } else {
                Toast.makeText(applicationContext, "E-mail ou password inválido", Toast.LENGTH_LONG).show()
            }

        }

        binding.buttonLetsGo.setOnClickListener{
            val i = Intent(this, RegisterActivity::class.java)
            startActivity(i)
        }
    }

}