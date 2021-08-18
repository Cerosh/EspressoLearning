package com.example.myapplication.espressolearning

import android.app.Dialog
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.text.format.DateUtils
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.view.isVisible
import androidx.fragment.app.DialogFragment
import com.example.myapplication.espressolearning.databinding.ResourceIdlingFragmentBinding
import java.lang.ref.WeakReference


class LoadingDialogFragment : DialogFragment() {
    companion object {
        const val TAG = "Loading"
        private const val DELAY = DateUtils.SECOND_IN_MILLIS * 5
    }
    private var _binding: ResourceIdlingFragmentBinding? = null
    private val binding get() = _binding!!
    private lateinit var textView: TextView
    private val handler = LoadingHandler(this)

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        handler.sendEmptyMessageDelayed(LoadingHandler.MSG_DISMISS, DELAY)

        return AlertDialog.Builder(requireActivity())
            .setTitle(R.string.loading)
            .setMessage(R.string.please_wait)
            .create()
    }

    override fun onDestroyView() {

        handler.removeMessages(LoadingHandler.MSG_DISMISS)
        super.onDestroyView()
        onLoadingFinished()

    }

    private fun onLoadingFinished() {
        Toast.makeText(context, "Toast Message for learning Espresso", Toast.LENGTH_SHORT).show()
    }


    private class LoadingHandler(fragment: DialogFragment) : Handler() {
        companion object {
            const val MSG_DISMISS = 0
        }

        private val ref = WeakReference(fragment)

        override fun handleMessage(msg: Message) {
            val fragment = ref.get() ?: return
            fragment.dismiss()
        }
    }
}
