package com.example.korucare

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.FragmentContainerView
import androidx.navigation.findNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import android.content.Intent
import android.content.res.Configuration
import java.util.Locale
import android.app.AlertDialog


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
        //awaiLogo.visibility = View.VISIBLE
        //korucareLogo.visibility = View.GONE


        fun switchLogoVisibility(showKorucareLogo: Boolean) {
            if (showKorucareLogo) {
                awaiLogo.visibility = View.GONE
                korucareLogo.visibility = View.VISIBLE
            } else {
                awaiLogo.visibility = View.VISIBLE
                korucareLogo.visibility = View.GONE
            }
        }

        fun setLocale(context: Context, lang: String) {
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

        // Bot Nav
        bottomNav.setOnItemSelectedListener {
            item -> when(item.itemId) {

                R.id.homeFragment -> {
                    navHostFragment.findNavController().navigate(R.id.homeFragment)
                    //switchLogoVisibility(true)
                    true
                }

                R.id.searchFragment -> {
                    navHostFragment.findNavController().navigate(R.id.searchFragment)
                    //switchLogoVisibility(true)
                    true
                }

                R.id.languageFragment -> {
                    showLanguageSelectionDialog()
                    true
                }

                R.id.infoFragment -> {
                    navHostFragment.findNavController().navigate(R.id.infoFragment)
                    //switchLogoVisibility(true)
                    true
                }

                else -> false
            }
        }

    }

}