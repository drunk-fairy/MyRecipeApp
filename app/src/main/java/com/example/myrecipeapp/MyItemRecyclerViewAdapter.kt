package com.example.myrecipeapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class RecipeAdapter(
    private val recipes: List<Recipe>, private val onItemClick: (Recipe) -> Unit) : 
    RecyclerView.Adapter<RecipeAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.recipe_element, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val recipe = recipes[position]
        holder.bind(recipe)
    }

    override fun getItemCount(): Int = recipes.size

    inner class ViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        val textview1: TextView = itemView.findViewById(R.id.textview1)
        val textview2: TextView = itemView.findViewById(R.id.textview2)
        val imageview1: ImageView = itemView.findViewById(R.id.imageview1)

        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    onItemClick(recipes[position])
                }
            }
        }

        fun bind(recipe: Recipe) {
            textview1.text = recipe.title
            textview2.text = recipe.cooking_time
            Glide.with(itemView.context)
                .load(recipe.imageUrl)
                .into(imageview1)
        }
    }

}