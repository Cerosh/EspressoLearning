package com.example.myapplication.espressolearning

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.example.myapplication.espressolearning.databinding.SpinnerFragmentBinding

class SpinnerFragment : Fragment() {

    private var _binding: SpinnerFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonForSpinner.setOnClickListener {
            val languages: Array<String> = resources.getStringArray(R.array.gestures)
            val spinner = binding.spinner
            val arrayAdapter = context?.let {
                ArrayAdapter(
                    it,
                    android.R.layout.simple_spinner_item, languages
                )
            }
            spinner.adapter = arrayAdapter
            spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    val itemValue = getString(R.string.selected_item) + " " + languages[position]
                    binding.selectedSpinner.text = itemValue
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }

            }

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = SpinnerFragmentBinding.inflate(inflater, container, false)
        return binding.root

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}


