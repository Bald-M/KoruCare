package com.example.korucare

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class ProcessOfEscortingFragment : Fragment(R.layout.fragment_process_of_escorting) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val assessmentBtn = view.findViewById<Button>(R.id.assessmentBtn)
        val custodianBtn = view.findViewById<Button>(R.id.custodianBtn)
        val conditionsBtn = view.findViewById<Button>(R.id.conditionsBtn)
        val informedEscortStrategyBtn = view.findViewById<Button>(R.id.informedEscortStrategyBtn)

        // Set click listeners for buttons
        assessmentBtn.setOnClickListener {
            // Navigate to appropriate destination
            findNavController().navigate(R.id.action_processOfEscortingFragment_to_assessmentFragment)
        }

        custodianBtn.setOnClickListener {
            // Navigate to appropriate destination
            findNavController().navigate(R.id.action_processOfEscortingFragment_to_custodianFragment)
        }

        conditionsBtn.setOnClickListener {
            // Navigate to appropriate destination
            findNavController().navigate(R.id.action_processOfEscortingFragment_to_conditionsFragment)
        }

        informedEscortStrategyBtn.setOnClickListener {
            // Navigate to appropriate destination
            findNavController().navigate(R.id.action_processOfEscortingFragment_to_informedEscortStrategyFragment)
        }
    }
}