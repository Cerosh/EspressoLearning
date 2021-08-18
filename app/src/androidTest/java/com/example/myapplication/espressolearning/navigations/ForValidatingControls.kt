package com.example.myapplication.espressolearning.navigations

import android.content.res.Resources
import android.provider.Settings.Secure.getString
import android.widget.RadioButton
import androidx.test.InstrumentationRegistry.getTargetContext
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.platform.app.InstrumentationRegistry
import com.example.myapplication.espressolearning.MainActivity
import com.example.myapplication.espressolearning.R
import org.hamcrest.CoreMatchers.containsString
import org.hamcrest.CoreMatchers.not
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.security.AccessController.getContext


@RunWith(AndroidJUnit4ClassRunner::class)
class ForValidatingControls {
    @get:Rule
    val activityScenario = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testControlsFragmentNavigation() {
        navigateFromHomePageToControls()
        onView(withId(R.id.control_view))
            .check(matches(isDisplayed()))
    }

    private fun navigateFromHomePageToControls() {
        onView(withId(R.id.home_title))
            .check(matches(withText(R.string.home_fragment_label)))
        onView(withId(R.id.control_button)).perform(click())
    }

    @Test
    fun testTextBoxInControlFragment() {
        val context = InstrumentationRegistry.getInstrumentation()
        val inputText = context.targetContext.getString(R.string.control_input_text)
        navigateFromHomePageToControls()
        onView(withId(R.id.control_text_input)).check(matches(isEnabled()))
        onView(withId(R.id.control_text_input)).perform(typeText(inputText))
        onView(withId(R.id.clickButton)).perform(click())
        Espresso.closeSoftKeyboard()
        onView(withId(R.id.display_textView)).check(matches(withText(containsString((inputText)))))

    }

    @Test
    fun testRadioButtonsInControlFragment() {
        navigateFromHomePageToControls()
        onView(withId(R.id.radio_male)).perform(click())
        onView(withId(R.id.radio_male)).check(matches(isChecked()))
        onView(withId(R.id.radio_female)).check(matches(not(isChecked())))
        onView(withId(R.id.selected_radio_button)).perform(click())
    }

    @Test
    fun testCheckBoxInControlFragment() {
        navigateFromHomePageToControls()
        onView(withId(R.id.checkbox_first_dose)).check(matches(not(isChecked()))).perform(click())
        onView(withId(R.id.checkbox_second_dose)).check(matches(isNotChecked())).perform(click());
        onView(withId(R.id.selected_checkbox_button)).perform(click())
    }

    @Test
    fun testToggleButtonInControlFragment() {
        navigateFromHomePageToControls()
        onView(withId(R.id.simpleToggleButton)).check(matches(isChecked())).perform(click());
    }

}

