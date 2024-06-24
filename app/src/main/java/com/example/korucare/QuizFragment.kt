package com.example.korucare

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class QuizFragment : Fragment(R.layout.fragment_quiz) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val yesBtn = view.findViewById<Button>(R.id.yesBtn)
        val noBtn = view.findViewById<Button>(R.id.noBtn)

        yesBtn.setOnClickListener{
            findNavController().navigate(R.id.action_quizFragment_to_quizCompletedFragment)
        }

        noBtn.setOnClickListener{
            findNavController().navigate(R.id.action_quizFragment_to_quizCompletedFragment)
        }
    }
}