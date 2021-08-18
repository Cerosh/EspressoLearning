package com.example.myapplication.espressolearning.navigations

import android.content.res.Resources
import android.provider.Settings.Secure.getString
import android.widget.RadioButton
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.RootMatchers.isDialog
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.example.myapplication.espressolearning.MainActivity
import com.example.myapplication.espressolearning.R
import org.hamcrest.CoreMatchers.containsString
import org.hamcrest.CoreMatchers.not
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.security.AccessController.getContext


@RunWith(AndroidJUnit4ClassRunner::class)
class ForValidatingDialog {
    @get:Rule
    val activityScenario = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testDialogFragmentNavigation() {
        navigateFromHomePageToDialog()
        onView(withId(R.id.dialog_view))
            .check(matches(isDisplayed()))
    }

    private fun navigateFromHomePageToDialog() {
        onView(withId(R.id.home_title))
            .check(matches(withText(R.string.home_fragment_label)))
        onView(withId(R.id.dialog_button)).perform(click())
    }

    @Test
    fun testTextBoxInControlFragment() {
        navigateFromHomePageToDialog()
        onView(withId(R.id.buttonForDialog)).check(matches(isEnabled())).perform(click())
        onView(withText(R.string.dialog_message)).inRoot(isDialog()).check(matches(isDisplayed()))
        onView(withText(R.string.positive_dialog_button)).perform(click())

    }

}

