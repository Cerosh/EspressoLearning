package com.example.myapplication.espressolearning

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.myapplication.espressolearning.databinding.ToastMatcherFragmentBinding

class ToastMatcherFragment : Fragment() {

    private var _binding: ToastMatcherFragmentBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = ToastMatcherFragmentBinding.inflate(inflater, container, false)
        return binding.root

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonForToastMessage.setOnClickListener {
            Toast.makeText(context,R.string.toast_message,Toast.LENGTH_SHORT).show()

        }

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    }

