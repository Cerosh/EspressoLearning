package com.example.myapplication.espressolearning.fragments

import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.lifecycle.Lifecycle
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.example.myapplication.espressolearning.ActivityFragment
import com.example.myapplication.espressolearning.R
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class ActivityFragmentTest{
    private lateinit var scenario: FragmentScenario<ActivityFragment>
    @Before
    fun setup(){
        scenario = launchFragmentInContainer()
        scenario.moveToState(Lifecycle.State.STARTED)


    }
    @Test
    fun validateActivityView(){
        onView(withId(R.id.activity_view)).check(matches(isDisplayed()))
    }
}