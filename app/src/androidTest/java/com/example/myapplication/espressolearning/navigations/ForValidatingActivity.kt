package com.example.myapplication.espressolearning.navigations

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.doesNotExist
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.example.myapplication.espressolearning.MainActivity
import com.example.myapplication.espressolearning.R
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class ForValidatingActivity {
    @Before
    fun setup() {
        ActivityScenario.launch(MainActivity::class.java)

    }

    @Test
    fun testActivityFragmentNavigation() {
        onView(withId(R.id.home_title)).check(matches(withText(R.string.home_fragment_label)))
        onView(withId(R.id.activity_button)).perform(click())
        onView(withId(R.id.activity_view)).check(matches(isDisplayed()))
        Espresso.pressBack()
        onView(withId(R.id.activity_view)).check(doesNotExist())
        onView(withId(R.id.home_title)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
    }
}