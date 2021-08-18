package com.example.myapplication.espressolearning

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapplication.espressolearning.databinding.ControlFragmentBinding


class ControlFragment : Fragment() {
    private var _binding: ControlFragmentBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = ControlFragmentBinding.inflate(inflater, container, false)
        return binding.root

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.clickButton.setOnClickListener {
            val displayText = binding.controlTextInput.text.toString()
            "Hello $displayText !!!".also { binding.displayTextView.text = it }

        }
        binding.selectedCheckboxButton.setOnClickListener {
            val displayText = StringBuilder()
            binding.checkboxFirstDose
            if (binding.checkboxFirstDose.isChecked) displayText.append("Vaccinated First dose")
            if (binding.checkboxSecondDose.isChecked) displayText.append("\nVaccinated Second dose")
            binding.selectedCheckboxLabel.text= displayText
        }
       binding.selectedRadioButton.setOnClickListener {
           var displayText = "You selected: "
           val intSelectButton: Int = binding.radioGroup2!!.checkedRadioButtonId
           displayText += if (intSelectButton == binding.radioMale.id) "Male" else "female"
           binding.selectedRadioButtonLabel.text = displayText
       }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    }

