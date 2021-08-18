package com.example.myapplication.espressolearning.navigations

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.matcher.ComponentNameMatchers
import androidx.test.espresso.intent.matcher.IntentMatchers
import androidx.test.espresso.intent.matcher.IntentMatchers.hasExtra
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.orchestrator.listeners.result.TestIdentifier
import androidx.test.platform.app.InstrumentationRegistry
import com.example.myapplication.espressolearning.MainActivity
import com.example.myapplication.espressolearning.R
import com.example.myapplication.espressolearning.intent.IntentLandingActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class ForValidatingIntents {

    @get:Rule
    val intentScenario = IntentsTestRule(MainActivity::class.java)

    @Test
    fun testViewMatcherNavigation() {
        navigateFromHomePageToIntent()
        onView(withId(R.id.button_view_matchers)).perform(click())
        val theme = getThemeFromTheCurrentContext(R.string.ViewMatcher)
        Intents.intended(hasExtra(IntentLandingActivity.KEY_THEME, theme))
    }

    @Test
    fun testViewActionNavigation() {
        navigateFromHomePageToIntent()
        onView(withId(R.id.button_view_actions)).perform(click())
        val theme = getThemeFromTheCurrentContext(R.string.ViewAction)
        Intents.intended(hasExtra(IntentLandingActivity.KEY_THEME, theme))
    }
    @Test
    fun testViewAssertionNavigationUsingIntentMatchers(){
        navigateFromHomePageToIntent()
        onView(withId(R.id.button_view_assertions)).perform(click())
        Intents.intended(IntentMatchers.hasComponent(
            ComponentNameMatchers.hasClassName("com.example.myapplication.espressolearning.activity.IntentLandingActivity")))
    }

    private fun navigateFromHomePageToIntent() {
        onView(withId(R.id.home_title))
            .check(ViewAssertions.matches(ViewMatchers.withText(R.string.home_fragment_label)))
        onView(withId(R.id.intent_button)).perform(click())
    }

    private fun getThemeFromTheCurrentContext(identifier: Int): String {
        val context: Context = InstrumentationRegistry.getInstrumentation().targetContext
        return context.getString(identifier)
    }
}