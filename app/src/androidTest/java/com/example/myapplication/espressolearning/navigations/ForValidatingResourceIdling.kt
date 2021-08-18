package com.example.myapplication.espressolearning.navigations

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.example.myapplication.espressolearning.MainActivity
import com.example.myapplication.espressolearning.R
import com.example.myapplication.espressolearning.utils.ToastMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class ForValidatingResourceIdling {
    @get:Rule
    val activityScenario = ActivityScenarioRule(MainActivity::class.java)
    @Test
    fun testResourceIdlingFragmentNavigation() {
        navigateFromHomePageToResourceIdlingFragment()
    }

    private fun navigateFromHomePageToResourceIdlingFragment() {
        onView(withId(R.id.home_title))
            .check(matches(withText(R.string.home_fragment_label)))
        onView(withId(R.id.resource_idling_button))
            .perform(ViewActions.click())

    }
    @Test
    fun validateResourceIdling(){
        testResourceIdlingFragmentNavigation()
        onView(withId(R.id.button_resource_idling))
            .perform(ViewActions.click())
        onView(withText(R.string.toast_message)).inRoot(ToastMatcher())
            .check(matches(ViewMatchers.isDisplayed()))
    }

}