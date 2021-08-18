package com.example.myapplication.espressolearning

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import com.example.myapplication.espressolearning.databinding.ProgressBarFragmentBinding


class ProgressBarFragment : Fragment() {
    private var _binding: ProgressBarFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = ProgressBarFragmentBinding.inflate(inflater, container, false)
        return binding.root


    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var progressBar: ProgressBar? = null
        var i = 0
        var txtView: TextView? = null
        val handler = Handler()
        binding.showProgressBarButton.setOnClickListener{
            progressBar = binding.progressBar as ProgressBar
            txtView = binding.progressBarTextview as TextView
            binding.showProgressBarButton as Button
            i = progressBar!!.progress
            Thread(Runnable {
                while (i < 100) {
                    i += 5
                    handler.post(Runnable {
                        progressBar!!.progress = i
                        txtView!!.text = i.toString() + "/" + progressBar!!.max
                    })

                    try {
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }
                progressBar!!.visibility = View.INVISIBLE
            }).start()

        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    }

