package com.example.myapplication.espressolearning.intent

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.espressolearning.R

class IntentActivity : AppCompatActivity() {

  private lateinit var nameView: TextView

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.intent_activity)
    nameView = findViewById(R.id.select_component_text_box)
  }

  fun goToIntentLandingActivity(v: View) {
    val button = v as Button

    val intent = Intent(this, IntentLandingActivity::class.java)
    intent.putExtra(IntentLandingActivity.KEY_THEME, button.text)

    startActivityForResult(intent, REQUEST_CODE_IDEAS)
  }

  override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
    when (requestCode) {
      REQUEST_CODE_IDEAS -> {
          nameView.text = data?.getStringExtra(IntentLandingActivity.KEY_NAME)
      }
      else -> super.onActivityResult(requestCode, resultCode, data)
    }
  }

  companion object {
    private const val REQUEST_CODE_IDEAS = 1
  }
}