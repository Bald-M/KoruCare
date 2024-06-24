package com.example.korucare

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class QuizCompletedFragment : Fragment(R.layout.fragment_quiz_completed) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val finishBtn = view.findViewById<Button>(R.id.finishBtn)

        finishBtn.setOnClickListener{
            findNavController().navigate(R.id.action_quizCompletedFragment_to_homeFragment)
        }

    }
}