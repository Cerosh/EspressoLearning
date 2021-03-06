package com.example.myapplication.espressolearning.intent


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.espressolearning.R

class IntentAdapter(private val ideas: Array<String>, private val listener: OnItemClickListener) : RecyclerView.Adapter<TextViewHolder>() {
  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextViewHolder {
    val view = LayoutInflater.from(parent.context).inflate(R.layout.idea, parent, false)
    return TextViewHolder(view)
  }

  override fun onBindViewHolder(holder: TextViewHolder, position: Int) {
    val label = ideas[position]
    holder.textView.text = label
    holder.textView.setOnClickListener { listener.onItemClick(position) }
  }

  override fun getItemCount(): Int {
    return ideas.size
  }

  interface OnItemClickListener {
    fun onItemClick(position: Int)
  }
}