package com.example.myapplication.espressolearning

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.example.myapplication.espressolearning.databinding.ResourceIdlingFragmentBinding


class ResourceIdlingFragment : Fragment() {
    private var _binding: ResourceIdlingFragmentBinding? = null
    private val binding get() = _binding!!
    private lateinit var textView: TextView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = ResourceIdlingFragmentBinding.inflate(inflater, container, false)
        return binding.root

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonResourceIdling.setOnClickListener {
            textView = binding.resourceIdlingLabel
            val fragment = LoadingDialogFragment()
            fragment.isCancelable = false
            var fragmentManager = (activity as FragmentActivity).supportFragmentManager
        fragment.show(fragmentManager, LoadingDialogFragment.TAG)

        }


    }
//    fun onLoadingFinished() {
//        println("Inside on Loading Finished")
//        textView.setText(R.string.done)
//    }

}
