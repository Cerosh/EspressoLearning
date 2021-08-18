package com.example.myapplication.espressolearning.utils

import androidx.fragment.app.FragmentManager
import androidx.test.espresso.IdlingResource

class DialogFragmentIdlingResource(private val manager: FragmentManager, private val tag: String):
  IdlingResource {
  override fun getName(): String {
    return DialogFragmentIdlingResource::class.java.name + ":" + tag
  }

  override fun isIdleNow(): Boolean {
    val idle = (manager.findFragmentByTag(tag) == null)
    if (idle) {
      callback?.onTransitionToIdle()
    }
    return idle
  }

  private var callback: IdlingResource.ResourceCallback? = null

  override fun registerIdleTransitionCallback(callback: IdlingResource.ResourceCallback?) {
    this.callback = callback
  }
}