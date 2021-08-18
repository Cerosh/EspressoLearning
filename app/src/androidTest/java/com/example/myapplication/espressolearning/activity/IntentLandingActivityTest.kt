package com.example.myapplication.espressolearning.activity

import android.content.Intent
import androidx.test.InstrumentationRegistry.getTargetContext
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import com.example.myapplication.espressolearning.R
import com.example.myapplication.espressolearning.intent.IntentLandingActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class IntentLandingActivityTest{
    @Rule @JvmField
    val activityTest = ActivityTestRule(IntentLandingActivity::class.java,true, false)
    val intent = Intent()
    private val context = InstrumentationRegistry.getInstrumentation()
    @Test
    fun noThemeView(){
        activityTest.launchActivity(null)
        onView(withId(R.id.theme)).check(matches(withText(R.string.missing_theme)))
    }
    @Test
    fun validateViewMatchersView(){
        val theme = context.targetContext.getString(R.string.ViewMatcher)
        intent.putExtra(IntentLandingActivity.KEY_THEME, theme)
        activityTest.launchActivity(intent)
        onView(withId(R.id.theme)).check(matches(withText(R.string.ViewMatcher)))
    }
    @Test
    fun validateViewActionView(){
        val theme = context.targetContext.getString(R.string.ViewAction)
        intent.putExtra(IntentLandingActivity.KEY_THEME,theme)
        activityTest.launchActivity(intent)
        onView(withId(R.id.theme)).check(matches(withText(R.string.ViewAction)))
    }
    @Test
    fun validateViewAssertionView(){
        val theme = context.targetContext.getString(R.string.ViewAssertion)
        intent.putExtra(IntentLandingActivity.KEY_THEME,theme)
        activityTest.launchActivity(intent)
        onView(withId(R.id.theme)).check(matches(withText(R.string.ViewAssertion)))
    }
    @Test
    fun validateUnknownView(){
        val theme = "unknown"
        intent.putExtra(IntentLandingActivity.KEY_THEME, theme)
        activityTest.launchActivity(intent)
        val message = context.targetContext.getString(R.string.unknown_theme, theme)
        onView(withId(R.id.theme)).check(matches(withText(message)))
    }

}
