package com.example.myapplication.Views

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.example.myapplication.Fragments.ContactUs
import com.example.myapplication.Fragments.FAQsFragment
import com.example.myapplication.Fragments.Home
import com.example.myapplication.Fragments.PoliticsFragment
import com.example.myapplication.Fragments.Rgpd
import com.example.myapplication.Fragments.SecondUserProfileFragment
import com.example.myapplication.Fragments.SobreFragment
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


        val fragmentToLoad = when {
            intent.extras?.getString("codeFrag") == "userProfile" -> UserProfile()
            intent.extras?.getString("fragment") == "secondUserProfile" -> SecondUserProfileFragment()
            else -> Home()
        }

        loadFragment(fragmentToLoad)


        // -------------------- Top navbar, buttons listeners
        val topAppBar = binding.topAppBar

        // User icon - user profile
        topAppBar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.userIcon -> {
                    val intent = Intent(this, LoginActivity::class.java)
                    startActivity(intent)
                    true

                }

                else -> false
            }
        }

        // Open hamburguer menu
        topAppBar.setNavigationOnClickListener {
            drawerLayout.openDrawer(binding.hamburguerView)
        }

        binding.hamburguerView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.hamburguerIcon -> {
                    loadFragment(Home())
                    drawerLayout.closeDrawers()
                    true
                }

                R.id.aboutUs -> {
                    loadFragment(SobreFragment())
                    drawerLayout.closeDrawers()
                    true
                }

                R.id.rgpd -> {
                    loadFragment(Rgpd())
                    drawerLayout.closeDrawers()
                    true
                }

                R.id.privacy -> {
                    loadFragment(PoliticsFragment())
                    drawerLayout.closeDrawers()
                    true
                }

                R.id.faqs -> {
                    loadFragment(FAQsFragment())
                    drawerLayout.closeDrawers()
                    true
                }

                else -> false
            }
        }


        // --------------      Bottom navbar, buttons listeners
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
                    loadFragment(ContactUs<Any>())
                    true
                }

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
