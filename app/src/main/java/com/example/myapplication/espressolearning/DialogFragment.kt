package com.example.myapplication.espressolearning

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.example.myapplication.espressolearning.databinding.DialogFragmentBinding


open class DialogFragment : Fragment() {

    private var _binding: DialogFragmentBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = DialogFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonForDialog.setOnClickListener {
            onCreateDialog().show()
        }

    }

    private fun onCreateDialog(): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            builder.setMessage(R.string.dialog_message)
                .setPositiveButton(R.string.positive_dialog_button) { dialog, id -> }
                .setNegativeButton(R.string.negative_dialog_button) { _, _ -> }
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}

