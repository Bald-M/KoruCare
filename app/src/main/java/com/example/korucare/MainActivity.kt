package com.example.korucare

import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.FragmentContainerView
import androidx.navigation.findNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.util.Locale
import android.app.AlertDialog
import android.net.Uri

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_nav_view)
        val navHostFragment = findViewById<FragmentContainerView>(R.id.nav_host_fragment)

        // Initialize language selection dialog method
        fun showLanguageSelectionDialog() {
            val languages = arrayOf("English", "Māori")
            val languageCodes = arrayOf("en", "mi")

            AlertDialog.Builder(this)
                .setTitle("Select Language")
                .setItems(languages) { dialog, which ->
                    // Set the selected language
                    setLocale(this, languageCodes[which])
                }
                .create()
                .show()
        }

        // Bottom navigation setup
        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.homeFragment -> {
                    navHostFragment.findNavController().navigate(R.id.homeFragment)
                    true
                }
                R.id.searchFragment -> {
                    navHostFragment.findNavController().navigate(R.id.searchFragment)
                    true
                }
                R.id.languageFragment -> {
                    showLanguageSelectionDialog()
                    true
                }
                R.id.infoFragment -> {
                    navHostFragment.findNavController().navigate(R.id.infoFragment)
                    true
                }
                else -> false
            }
        }
    }

    // Handle "Read More" button click
    fun onEscortingReadMoreClicked(view: android.view.View) {
        val url = "https://practice.orangatamariki.govt.nz/policy/escorting-tamariki-and-rangatahi/"
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    }

    // Method to update locale
    private fun setLocale(context: Context, lang: String) {
        val locale = Locale(lang)
        Locale.setDefault(locale)
        val config = Configuration()
        config.setLocale(locale)
        context.resources.updateConfiguration(config, context.resources.displayMetrics)

        // Restart the activity to apply changes
        val refreshIntent = Intent(context, MainActivity::class.java)
        refreshIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
        context.startActivity(refreshIntent)
    }
}
