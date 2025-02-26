package com.example.klient_server_app

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        // Добавляем макет поиска в Toolbar
        layoutInflater.inflate(R.layout.toolbar_search, toolbar)

        val searchField = findViewById<EditText>(R.id.etSearch)
        val searchButton = findViewById<Button>(R.id.btnSearch)

        searchButton.setOnClickListener {
            val query = searchField.text.toString()
            searchProducts(query)
        }

        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottomNavigation)
        bottomNavigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> loadFragment(HomeFragment())
                R.id.nav_catalog -> loadFragment(CatalogFragment())
                R.id.nav_favorites -> loadFragment(FavoritesFragment())
                R.id.nav_cart -> loadFragment(CartFragment())
                R.id.nav_profile -> loadFragment(ProfileFragment())
            }
            true
        }

        // Загружаем главный фрагмент по умолчанию
        if (savedInstanceState == null) {
            loadFragment(HomeFragment())
        }
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()
    }

    private fun searchProducts(query: String) {
        // Логика поиска (можно передавать в нужный фрагмент)
    }
}
