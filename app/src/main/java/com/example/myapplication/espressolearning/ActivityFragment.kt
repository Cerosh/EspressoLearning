package com.example.myapplication.espressolearning


import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.navigation.fragment.findNavController
import com.example.myapplication.espressolearning.databinding.ActivityFragmentBinding
import kotlinx.android.synthetic.main.activity_fragment.*


/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class ActivityFragment : Fragment(), CallbackListener {

    private var _binding: ActivityFragmentBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = ActivityFragmentBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonSecond.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }
        binding.buttonShowDialog.setOnClickListener {
            showDialog()
        }
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_main, menu);

        super.onCreateOptionsMenu(menu, inflater)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.getItemId()
        if (id == R.id.action_settings) {
            showDialog()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun showDialog() {
        val dialogFragment = FullScreenDialogExample(this)
        val fragmentManager = (activity as FragmentActivity).supportFragmentManager
        dialogFragment.show(fragmentManager, "signature")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onDataReceived(data: String) {
        textViewReceivedData.text = data
    }
}