package com.example.myapplication.espressolearning


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.example.myapplication.espressolearning.databinding.ListFragmentBinding
import com.raywenderlich.android.alltherecipes.Recipe


class ListFragment : Fragment() {

    private var _binding: ListFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = ListFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recipeList = Recipe.getRecipesFromFile("recipes.json", requireContext())
        val listOfActivity = arrayOfNulls<String>(recipeList.size)
        for (i in 0 until recipeList.size) {
            val recipe = recipeList[i]
            listOfActivity[i] = recipe.title
        }
        val context = view.context
        val listView = binding.activityLifeCycle
        val adapter = ArrayAdapter(context, android.R.layout.simple_list_item_1, listOfActivity)
        listView.adapter = adapter
        listView.onItemClickListener =
            AdapterView.OnItemClickListener { parent, view, position, id ->
                val selectedItemText = parent.getItemAtPosition(position)
                val textView = binding.selectedItemLabel
                textView.text = "$selectedItemText"
            }

    }


    class Item(private val value: Int) {
        override fun toString(): String {
            return value.toString()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

