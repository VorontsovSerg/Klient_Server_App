package com.example.klient_server_app.ui

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.klient_server_app.R
import com.example.klient_server_app.data.AppDatabase
import com.example.klient_server_app.data.Category
import kotlinx.coroutines.launch

class CatalogFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_catalog, container, false)
        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)

        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        lifecycleScope.launch {
            val db = AppDatabase.getDatabase(requireContext()).appDao()
            val categories: List<Category> = db.getAllCategories()
            recyclerView.adapter = CategoryAdapter(categories)
        }

        return view
    }
}
