package com.example.klient_server_app.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "subcategories")
data class Subcategory(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val imageUrl: String,
    val categoryId: Int
)
