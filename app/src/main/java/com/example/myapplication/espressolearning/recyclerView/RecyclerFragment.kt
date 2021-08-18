package com.example.myapplication.espressolearning.recyclerView

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.espressolearning.databinding.RecyclerFragmentBinding

class RecyclerFragment : Fragment() {

    private var _binding: RecyclerFragmentBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = RecyclerFragmentBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val context = view.context
        val recyclerView = binding.recyclerview
        val textView = binding.recyclerTextview
        textView.setBackgroundColor(Color.LTGRAY)
        textView.visibility = View.GONE
        recyclerView.setHasFixedSize(true)

        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = NumberedAdapter(
            30,
            object : NumberedAdapter.OnItemClickListener {
                override fun onItemClick(position: Int) {
                    textView.text = position.toString()
                    textView.visibility = View.VISIBLE
                }
            }
        )
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}

