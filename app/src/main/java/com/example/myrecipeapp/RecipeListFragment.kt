package com.example.myrecipeapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.View
import androidx.navigation.fragment.findNavController

class RecipeListFragment : Fragment(R.layout.fragment_recipe_list) {

    private val recipes: List<Recipe> by lazy {
        listOf(
            Recipe(getString(R.string.title1),
                getString(R.string.time1),
                getString(R.string.desc1),
                getString(R.string.link1)
            ) ,
            Recipe(getString(R.string.title2),
                getString(R.string.time2),
                getString(R.string.desc2),
                getString(R.string.link2)
            ),
            Recipe(getString(R.string.title3),
                getString(R.string.time3),
                getString(R.string.desc3),
                getString(R.string.link3)
            ),
            Recipe(getString(R.string.title4),
                getString(R.string.time4),
                getString(R.string.desc4),
                getString(R.string.link4)
            ),
            Recipe(getString(R.string.title5),
                getString(R.string.time5),
                getString(R.string.desc5),
                getString(R.string.link5)
            )
        )
    }

   override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
       super.onViewCreated(view, savedInstanceState)

       val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)
       recyclerView.layoutManager = LinearLayoutManager(requireContext())
       recyclerView.adapter = RecipeAdapter(recipes) { selectedRecipe ->
           showRecipeDetail(selectedRecipe)
       }
   }

    private fun showRecipeDetail(recipe: Recipe) {
        val action = RecipeListFragmentDirections.toFragment2(recipe)
        findNavController().navigate(action)
    }

}