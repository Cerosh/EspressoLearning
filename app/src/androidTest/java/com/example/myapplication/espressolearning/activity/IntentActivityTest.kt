package com.example.myapplication.espressolearning.activity

import android.app.Activity
import android.app.Instrumentation
import android.content.Intent
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.matcher.IntentMatchers.hasExtra
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.platform.app.InstrumentationRegistry
import com.example.myapplication.espressolearning.R
import com.example.myapplication.espressolearning.intent.IntentActivity
import com.example.myapplication.espressolearning.intent.IntentLandingActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class IntentActivityTest {
    @Rule
    @JvmField
    val activityRule = IntentsTestRule(IntentActivity::class.java)

    @Test
    fun viewMatchersIntending() {
        val name = "hasLinks()"
        val intent = Intent()
        intent.putExtra(IntentLandingActivity.KEY_NAME, name)
        val result = Instrumentation.ActivityResult(Activity.RESULT_OK, intent)
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        val theme = context.getString(R.string.ViewMatcher)
        Intents.intending(hasExtra(IntentLandingActivity.KEY_THEME, theme)).respondWith(result)
        onView(withId(R.id.button_view_matchers)).perform(click())
        onView(withId(R.id.select_component_text_box)).check(matches(withText(name)))
    }

    @Test
    fun viewActionsIntending() {
        val name = "click()"
        val intent = Intent()
        intent.putExtra(IntentLandingActivity.KEY_NAME, name)
        val result = Instrumentation.ActivityResult(Activity.RESULT_OK, intent)
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        val theme = context.getString(R.string.ViewAction)
        Intents.intending(hasExtra(IntentLandingActivity.KEY_THEME, theme)).respondWith(result)
        onView(withId(R.id.button_view_actions)).perform(click())
        onView(withId(R.id.select_component_text_box)).check(matches(withText(name)))

    }

    @Test
    fun viewAssertionsIntending() {
        val name = "isRightAlignedWith(Matcher)"
        val intent = Intent()
        intent.putExtra(IntentLandingActivity.KEY_NAME, name)
        val result = Instrumentation.ActivityResult(Activity.RESULT_OK, intent)
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        val theme = context.getString(R.string.ViewAssertion)
        Intents.intending(hasExtra(IntentLandingActivity.KEY_THEME, theme)).respondWith(result)
        onView(withId(R.id.button_view_assertions)).perform(click())
        onView(withId(R.id.select_component_text_box)).check(matches(withText(name)))
    }

}