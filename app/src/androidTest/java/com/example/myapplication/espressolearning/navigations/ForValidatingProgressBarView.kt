package com.example.myapplication.espressolearning.navigations

import android.view.View
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.IdlingResource
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.doesNotExist
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.platform.app.InstrumentationRegistry.getInstrumentation
import androidx.test.uiautomator.By
import androidx.test.uiautomator.UiDevice
import androidx.test.uiautomator.Until
import com.example.myapplication.espressolearning.MainActivity
import com.example.myapplication.espressolearning.R
import com.example.myapplication.espressolearning.utils.ViewIdlingResource
import org.hamcrest.Matcher
import org.hamcrest.core.IsNot.not
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.util.concurrent.TimeUnit


@RunWith(AndroidJUnit4ClassRunner::class)
class ForValidatingProgressBarView {
    @get:Rule
    val activityScenario = ActivityScenarioRule(MainActivity::class.java)
    private val timeOut = 5000L
    private val expectedText = "100/100"

    @Test
    fun testProgressBarFragmentNavigation() {
        navigateFromHomePageToProgressBarFragment()
    }

    private fun navigateFromHomePageToProgressBarFragment() {
        onView(withId(R.id.home_title))
            .check(matches(withText(R.string.home_fragment_label)))
        onView(withId(R.id.progress_bar_button))
            .perform(click())

    }

    @Test
    fun testProgressBarHiddenStateUsingIdlingRegistry() {
        testProgressBarFragmentNavigation()
        onView(withId(R.id.progress_Bar)).check(matches((isDisplayed())))
        onView(withId(R.id.show_progress_bar_button)).perform(click())
        waitElementUsingIdlingRegistry(withText(expectedText))
        onView(withId(R.id.progress_Bar)).check(matches(not(isDisplayed())))

    }

    @Test
    fun testProgressBarHiddenStateUsingUiAutomator() {
        testProgressBarFragmentNavigation()
        onView(withId(R.id.progress_Bar)).check(matches((isDisplayed())))
        onView(withId(R.id.show_progress_bar_button)).perform(click())
        waitElementUsingUiAutomator(expectedText)
        onView(withId(R.id.progress_Bar)).check(matches(not(isDisplayed())))
    }

    private fun waitElementUsingUiAutomator(expectedText: String) {
        val instrumentation = getInstrumentation()
        val uiDevice = UiDevice.getInstance(instrumentation)
        uiDevice.wait(Until.hasObject(By.text(expectedText)), timeOut)
            ?: throw Exception(
                "After waiting for ${TimeUnit.MILLISECONDS.toSeconds(timeOut)} seconds, " +
                        "the text $expectedText was not found"
            )

    }

    private fun waitElementUsingIdlingRegistry(matcher: Matcher<View>) {
        val idlingResource: IdlingResource = ViewIdlingResource(matcher, isDisplayed())
        IdlingRegistry.getInstance().register(idlingResource)
        onView(withId(0)).check(doesNotExist())
        IdlingRegistry.getInstance().unregister(idlingResource)
    }


}
