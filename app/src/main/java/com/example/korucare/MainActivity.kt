package com.example.korucare

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.FragmentContainerView
import androidx.navigation.findNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_nav_view)
        val navHostFragment = findViewById<FragmentContainerView>(R.id.nav_host_fragment)

        // Logo Change
        val awaiLogo = findViewById<ImageView>(R.id.awaiLogo)
        val korucareLogo = findViewById<ConstraintLayout>(R.id.korucareLogo)

        // Default Values
        awaiLogo.visibility = View.VISIBLE
        korucareLogo.visibility = View.GONE


        fun switchLogoVisibility(showKorucareLogo: Boolean) {
            if (showKorucareLogo) {
                awaiLogo.visibility = View.GONE
                korucareLogo.visibility = View.VISIBLE
            } else {
                awaiLogo.visibility = View.VISIBLE
                korucareLogo.visibility = View.GONE
            }
        }

        // Bot Nav
        bottomNav.setOnItemSelectedListener {
            item -> when(item.itemId) {

                R.id.homeFragment -> {
                    navHostFragment.findNavController().navigate(R.id.homeFragment)
                    switchLogoVisibility(true)
                    true
                }

                R.id.searchFragment -> {
                    navHostFragment.findNavController().navigate(R.id.searchFragment)
                    switchLogoVisibility(true)
                    true
                }

                R.id.infoFragment -> {
                    navHostFragment.findNavController().navigate(R.id.infoFragment)
                    switchLogoVisibility(true)
                    true
                }

                else -> false
            }
        }

    }
}