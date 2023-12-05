package com.example.myrecipeapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide


class RecipeDetailFragment : Fragment(R.layout.fragment_recipe_detail) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recipe: Recipe = RecipeDetailFragmentArgs.fromBundle(requireArguments()).recipe

        val imageview1: ImageView = view.findViewById(R.id.imageview1)
        val textview1: TextView = view.findViewById(R.id.textview1)
        val textview2: TextView = view.findViewById(R.id.textview2)
        val textview3: TextView = view.findViewById(R.id.textview3)

        Glide.with(requireContext())
            .load(recipe.imageUrl)
            .into(imageview1)

        textview1.text = recipe.title
        textview2.text = recipe.cooking_time
        textview3.text = recipe.details
    }
}