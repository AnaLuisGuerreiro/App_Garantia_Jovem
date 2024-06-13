package com.example.myapplication.Views

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.example.myapplication.Fragments.ContactUs
import com.example.myapplication.Fragments.Home
import com.example.myapplication.Fragments.UserProfile
import com.example.myapplication.Fragments.WhereAreWe
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private lateinit var bottomNavigationView: BottomNavigationView
    private lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        drawerLayout = binding.main

        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        loadFragment(Home())

        val topAppBar = binding.topAppBar

        topAppBar.setNavigationOnClickListener {
            drawerLayout.openDrawer(binding.hamburguerView)
        }

        topAppBar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.userIcon -> {
                    loadFragment(UserProfile())
                    true
                }
                else -> false
            }
        }

        bottomNavigationView = binding.bottomNav
        bottomNavigationView.selectedItemId = R.id.bottom_home
        bottomNavigationView.itemIconTintList = null

        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.bottom_geo -> {
                    loadFragment(WhereAreWe())
                    true
                }
                R.id.bottom_home -> {
                    loadFragment(Home())
                    true
                }
                R.id.bottom_phone -> {
                    loadFragment(ContactUs())
                    true
                }
                else -> false
            }
        }

        // Configuração do listener para os itens do menu do Drawer
        val navigationView = binding.hamburguerView
        navigationView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.hamburguerIcon -> {
                    loadFragment(Home())
                    drawerLayout.closeDrawers()
                    true
                }
                // Adicione outros casos conforme necessário
                else -> false
            }
        }
    }

    private fun loadFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frameLayout, fragment)
        transaction.commit()
    }
}
