package com.example.klient_server_app.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.klient_server_app.R

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 2) // 2 карточки в ряд
        recyclerView.adapter = ProductAdapter(getProductList())

        return view
    }

    private fun getProductList(): List<Product> {
        return listOf(
            Product("Банан", "999 руб.", R.drawable.banana),
            Product("Яблоко", "299 руб.", R.drawable.apple),
            Product("Апельсин", "399 руб.", R.drawable.orange),
            Product("Груша", "599 руб.", R.drawable.pear),
        )
    }
}
