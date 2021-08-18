package com.example.myapplication.espressolearning.navigations

import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.example.myapplication.espressolearning.MainActivity
import com.example.myapplication.espressolearning.R
import org.hamcrest.CoreMatchers.allOf
import org.hamcrest.`object`.HasToString.hasToString
import org.hamcrest.core.Is.`is`
import org.hamcrest.core.IsInstanceOf.instanceOf
import org.hamcrest.core.StringStartsWith.startsWith
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4ClassRunner::class)
class ForValidatingList {
    @get:Rule
    val activityScenario = ActivityScenarioRule(MainActivity::class.java)
    private val activityLifecycleState = "onStart(): activity enters the Started state"

    @Test
    fun testListFragmentNavigation() {
        navigateFromHomePageToList()
        onView(withId(R.id.activity_life_cycle))
            .check(matches(isDisplayed()))
    }

    private fun navigateFromHomePageToList() {
        onView(withId(R.id.home_title))
            .check(matches(withText(R.string.home_fragment_label)))
        onView(withId(R.id.list_button)).perform(click())

    }

    @Test
    fun testListItemSelection() {
        testListFragmentNavigation()
        onData(hasToString(startsWith("onStart()")))
            .inAdapterView(withId(R.id.activity_life_cycle))
            .perform(click())
        onView(withId(R.id.selectedItemLabel)).check(matches(withText(activityLifecycleState)))
            .check(matches(isDisplayed()))

    }

    @Test
    fun testListItemSelectionUsingString() {
        testListFragmentNavigation()
        onData(hasToString((activityLifecycleState)))
            .inAdapterView(withId(R.id.activity_life_cycle)).atPosition(0)
            .perform(click())
        onView(withId(R.id.selectedItemLabel)).check(matches(withText(activityLifecycleState)))
            .check(matches(isDisplayed()))

    }

    @Test
    fun testListItemSelectionWithInstance() {
        testListFragmentNavigation()
        onData(allOf(instanceOf(String::class.java), `is`(activityLifecycleState))).perform(click())
        onView(withId(R.id.selectedItemLabel)).check(matches(withText(activityLifecycleState)))
            .check(matches(isDisplayed()))

    }


}