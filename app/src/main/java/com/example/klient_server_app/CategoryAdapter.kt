package com.example.klient_server_app.ui

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.klient_server_app.R
import com.example.klient_server_app.data.AppDatabase
import com.example.klient_server_app.data.Category
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CategoryAdapter(private val categories: List<Category>) :
    RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    class CategoryViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val categoryTitle: TextView = view.findViewById(R.id.categoryTitle)
        val categoryContainer: LinearLayout = view.findViewById(R.id.categoryContainer)
        val subcategoryList: LinearLayout = view.findViewById(R.id.subcategoryList)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_category, parent, false)
        return CategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val category = categories[position]
        holder.categoryTitle.text = category.name
        holder.categoryContainer.setBackgroundColor(Color.parseColor(category.color))

        // Загружаем подкатегории
        CoroutineScope(Dispatchers.Main).launch {
            val db = AppDatabase.getDatabase(holder.itemView.context).appDao()
            val subcategories = db.getSubcategoriesByCategory(category.id)

            holder.subcategoryList.removeAllViews()

            subcategories.forEach { subcategory ->
                val subcategoryButton = LayoutInflater.from(holder.itemView.context)
                    .inflate(R.layout.item_subcategory, holder.subcategoryList, false) as LinearLayout

                val subcategoryText = subcategoryButton.findViewById<TextView>(R.id.subcategoryText)
                subcategoryText.text = subcategory.name

                holder.subcategoryList.addView(subcategoryButton)
            }
        }
    }

    override fun getItemCount(): Int = categories.size
}
