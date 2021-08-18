package com.example.myapplication.espressolearning.navigations

import android.view.View
import android.widget.TextView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.PickerActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.example.myapplication.espressolearning.MainActivity
import com.example.myapplication.espressolearning.R
import junit.framework.Assert.assertEquals
import org.hamcrest.Matcher
import org.hamcrest.core.AllOf.allOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class ForValidatingDateAndTime {
    private val year = 2021
    private val month = 12
    private val day = 1
    private var hour = 15
    private val minute = 9

    @get:Rule
    val activityScenario = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testDateAndTimeFragmentNavigation() {
        navigateFromHomePageToDateAndTime()
    }

    private fun navigateFromHomePageToDateAndTime() {
        onView(withId(R.id.home_title))
            .check(matches(withText(R.string.home_fragment_label)))
        onView(withId(R.id.date_time_picker_button)).perform(click())

    }

    @Test
    fun testDateSelectionUsingDatePicker() {
        testDateAndTimeFragmentNavigation()
        onView(withId(R.id.datePicker)).perform(PickerActions.setDate(year, month, day))
        val selectedDateVI: ViewInteraction = onView(withId(R.id.date_textView))
        assertEquals(getText(selectedDateVI), "You selected: $day/$month/$year")
        onView(withId(R.id.date_textView)).check(
            matches(
                allOf(
                    withText("You selected: $day/$month/$year"),
                    isDisplayed()
                )
            )
        );

    }

    @Test
    fun testTimeSelectionUsingTimeSpinner() {
        testDateAndTimeFragmentNavigation()
        onView(withId(R.id.timePicker)).perform(PickerActions.setTime(hour, minute))
        val selectedTimeVI: ViewInteraction = onView(withId(R.id.time_textView))
        assertEquals(getText(selectedTimeVI), makeExpectedTime())
    }

    private fun makeExpectedTime(): String {
        var AM_PM = "AM"
        var mm_precede = ""
        var hr_precede = ""
        if (hour >= 12) {
            AM_PM = "PM"
            if (hour in 13..23) {
                hour -= 12
            } else {
                hour = 12
            }
        } else if (hour === 0) {
            hour = 12
        }
        if (minute < 10) {
            mm_precede = "0"
        }
        if (hour < 10) {
            hr_precede = "0"
        }
        return "Time is: $hr_precede$hour : $mm_precede$minute $AM_PM"

    }

    private fun getText(matcher: ViewInteraction): String {
        var text = String()
        matcher.perform(object : ViewAction {
            override fun getConstraints(): Matcher<View> {
                return isAssignableFrom(TextView::class.java)
            }
            override fun getDescription(): String {
                return "Text of the view"
            }
            override fun perform(uiController: UiController, view: View) {
                val tv = view as TextView
                text = tv.text.toString()
            }
        })
        return text
    }

}