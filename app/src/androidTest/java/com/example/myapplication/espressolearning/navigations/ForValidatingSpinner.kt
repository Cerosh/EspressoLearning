package com.example.myapplication.espressolearning.navigations

import android.content.res.Resources
import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.platform.app.InstrumentationRegistry
import com.example.myapplication.espressolearning.MainActivity
import com.example.myapplication.espressolearning.R
import org.hamcrest.CoreMatchers.*
import org.hamcrest.core.AllOf.allOf
import org.hamcrest.core.IsInstanceOf.instanceOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4ClassRunner::class)
class ForValidatingSpinner {
    @get:Rule
    val activityScenario = ActivityScenarioRule(MainActivity::class.java)
    private val gestureValue = "swipeUp()"

    @Test
    fun testSpinnerFragmentNavigation() {
        navigateFromHomePageToSpinner()
        onView(withId(R.id.spinner_view))
            .check(matches(isDisplayed()))
        onView(withId(R.id.buttonForSpinner)).perform(click())


    }

    private fun navigateFromHomePageToSpinner() {
        onView(withId(R.id.home_title))
            .check(matches(withText(R.string.home_fragment_label)))
        onView(withId(R.id.spinner_button)).perform(click())

    }

    @Test
    fun testSpinnerFragmentWithText() {
        testSpinnerFragmentNavigation()
        onView(withId(R.id.spinner)).perform(click())
        onData(allOf(`is`(instanceOf(String::class.java)), `is`(gestureValue))).perform(click())
        onView(withId(R.id.spinner)).check(matches(withSpinnerText(containsString(gestureValue))))

    }

    @Test
    fun testSpinnerFragmentWithPosition() {
        testSpinnerFragmentNavigation()
        onView(withId(R.id.spinner)).perform(click())
        onData(anything()).atPosition(3).perform(click())
        onView(withId(R.id.spinner)).check(matches(withSpinnerText(containsString(gestureValue))))
    }

    @Test
    fun testSpinnerFragmentForAllItems() {
        testSpinnerFragmentNavigation()
        val resources: Resources =
            InstrumentationRegistry.getInstrumentation().targetContext.resources
        val myArray: Array<String> = resources.getStringArray(R.array.gestures)
        for (i in myArray.indices) {
            onView(withId(R.id.spinner)).perform(click())
            onData(`is`(myArray[i])).perform(click())
            onView(withId(R.id.selectedSpinner))
                .check(matches(withText(containsString(myArray[i]))))
        }
    }

}