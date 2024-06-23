package com.example.korucare

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class HomeFragment : Fragment(R.layout.fragment_home) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val infoBtn = view.findViewById<Button>(R.id.infoBtn)
        val processOfEscorting = view.findViewById<Button>(R.id.processOfEscortBtn)


        infoBtn.setOnClickListener{
            findNavController().navigate(R.id.action_homeFragment_to_informationFragment)
        }

        processOfEscorting.setOnClickListener{
            findNavController().navigate(R.id.action_homeFragment_to_escortingFragment)
        }
    }
}