package com.example.myapplication.espressolearning

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.myapplication.espressolearning.databinding.HomeFragmentBinding


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class HomeFragment : Fragment() {

    private var _binding: HomeFragmentBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = HomeFragmentBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.activityButton.setOnClickListener {
            findNavController().navigate(R.id.action_HomeFragment_to_ActivityFragment)
        }
        binding.progressBarButton.setOnClickListener{
            findNavController().navigate(R.id.action_HomeFragment_to_ActionBarFragment)
        }
        binding.dialogButton.setOnClickListener{
            findNavController().navigate(R.id.action_HomeFragment_to_DialogFragment)
        }
        binding.controlButton.setOnClickListener{
            findNavController().navigate(R.id.action_HomeFragment_to_ControlFragment)
        }
        binding.toastMatcherButton.setOnClickListener{
            findNavController().navigate(R.id.action_HomeFragment_to_ToastMatcherFragment)
        }
        binding.listButton.setOnClickListener{
            findNavController().navigate(R.id.action_HomeFragment_to_ListFragment)
        }
        binding.recyclerViewButton.setOnClickListener{
            findNavController().navigate(R.id.action_HomeFragment_to_RecyclerFragment)
        }
        binding.mockButton.setOnClickListener{
            findNavController().navigate(R.id.action_HomeFragment_to_MockFragment)
        }
        binding.intentButton.setOnClickListener{
            findNavController().navigate(R.id.action_HomeFragment_to_IntentFragment)
        }
        binding.resourceIdlingButton.setOnClickListener{
            findNavController().navigate(R.id.action_HomeFragment_to_ResourceIdlingFragment)
        }
        binding.spinnerButton.setOnClickListener{
            findNavController().navigate(R.id.action_HomeFragment_to_SpinnerFragment)
        }
        binding.dateTimePickerButton.setOnClickListener{
            findNavController().navigate(R.id.action_HomeFragment_to_DateTimePickerFragment)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}