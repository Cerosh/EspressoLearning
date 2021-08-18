package com.example.myapplication.espressolearning.intent

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.espressolearning.R

class IntentLandingActivity : AppCompatActivity() {
  companion object {
    val KEY_THEME = "theme"
    val KEY_NAME = "name"
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.intent_landing_activity)

    val themeView = findViewById<TextView>(R.id.theme)

    val theme = intent.getStringExtra(KEY_THEME)
    if (theme == null) {
      themeView.setText(R.string.missing_theme)
      return
    }

    themeView.text = theme
    println(theme)
    val ideasId = when (theme) {

      getString(R.string.ViewMatcher) -> R.array.ViewMatcher
      getString(R.string.ViewAction) -> R.array.ViewAction
      getString(R.string.ViewAssertion) -> R.array.ViewAssertion
      else -> 0
    }

    if (ideasId == 0) {
      themeView.text = getString(R.string.unknown_theme, theme)
      return
    }

    val ideas = resources.getStringArray(ideasId)

    val recyclerView = findViewById<RecyclerView>(R.id.ideas)

    recyclerView.setHasFixedSize(true)
    recyclerView.layoutManager = LinearLayoutManager(this)
    recyclerView.adapter = IntentAdapter(ideas, object : IntentAdapter.OnItemClickListener {
      override fun onItemClick(position: Int) {
        val data = Intent()
        data.putExtra(KEY_NAME, ideas[position])
        setResult(RESULT_OK, data)
        finish()
      }
    })
  }
}