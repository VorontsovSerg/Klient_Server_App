package com.example.klient_server_app.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface AppDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCategory(category: Category)

    @Query("SELECT * FROM categories")
    suspend fun getAllCategories(): List<Category>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProduct(product: Product)

    @Query("SELECT * FROM products WHERE categoryId = :categoryId")
    suspend fun getProductsByCategory(categoryId: Int): List<Product>

    @Query("SELECT * FROM products WHERE id = :productId")
    suspend fun getProductById(productId: Int): Product

    @Query("SELECT * FROM subcategories WHERE categoryId = :categoryId")
    suspend fun getSubcategoriesByCategory(categoryId: Int): List<Subcategory>
}
