package com.example.korucare

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.appcompat.widget.SearchView

class SearchFragment : Fragment(R.layout.fragment_search) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val searchView = view.findViewById<SearchView>(R.id.searchView)

        searchView.clearFocus()

        searchView.setOnQueryTextListener(object  : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                TODO("Not yet implemented")
                // import androidx.fragment.app.viewModels
                // private val viewModel by viewModels<GalleryViewModel>()
                // viewModel.searchPhotos(query)
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                Log.i("test", newText!!)
                return true
            }
        })

    }
}