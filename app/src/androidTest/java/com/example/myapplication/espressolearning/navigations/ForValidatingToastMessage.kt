package com.example.myapplication.espressolearning.navigations

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.example.myapplication.espressolearning.MainActivity
import com.example.myapplication.espressolearning.R
import com.example.myapplication.espressolearning.utils.ToastMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4ClassRunner::class)
class ForValidatingToastMessage {
    @get:Rule
    val activityScenario = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testToastMessageFragmentNavigation() {
        navigateFromHomePageToToastMessage()
        onView(withId(R.id.toast_message_view))
            .check(matches(isDisplayed()))
    }

    private fun navigateFromHomePageToToastMessage() {
        onView(withId(R.id.home_title))
            .check(matches(withText(R.string.home_fragment_label)))
        onView(withId(R.id.toast_matcher_button)).perform(click())
    }

    @Test
    fun testToastMessageInFragment() {
        navigateFromHomePageToToastMessage()
        onView(withId(R.id.buttonForToastMessage)).perform(click())
        onView(withText(R.string.toast_message)).inRoot(ToastMatcher())
            .check(matches(isDisplayed()))

    }


}





