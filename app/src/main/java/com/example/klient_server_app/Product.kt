package com.example.klient_server_app.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "products")
data class Product(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val price: String,
    val description: String,
    val categoryId: Int,
    val imageUrls: List<String> // Список URL картинок
)
