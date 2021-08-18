package com.example.myapplication.espressolearning.navigations

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.example.myapplication.espressolearning.MainActivity
import com.example.myapplication.espressolearning.recyclerView.NumberedAdapter
import com.example.myapplication.espressolearning.R
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class ForValidatingRecyclerView {
    @get:Rule
    val activityScenario = ActivityScenarioRule(MainActivity::class.java)
    val itemName = "Item 14"

    @Test
    fun testRecyclerViewFragmentNavigation() {
        navigateFromHomePageToRecyclerView()
    }

    private fun navigateFromHomePageToRecyclerView() {
        onView(withId(R.id.home_title)).check(matches(withText(R.string.home_fragment_label)))
        onView(withId(R.id.recycler_view_button)).perform(click())

    }

    @Test
    fun testRecyclerViewItemSelection() {
        testRecyclerViewFragmentNavigation()
        onView(withId(R.id.recyclerview)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                15,
                click()
            )
        )
        onView(withId(R.id.recycler_textview)).check(matches(isDisplayed()))

    }

    @Test
    fun testRecyclersViewScrollToPosition() {
        var adapter: NumberedAdapter? = null
        var itemCount = adapter?.itemCount
        if (itemCount != null){
            testRecyclerViewFragmentNavigation()
            onView(withId(R.id.recyclerview)).perform(
                RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(15)
            )
        }

    }

    @Test
    fun testRecyclerViewTextAtAPosition() {
        testRecyclerViewFragmentNavigation()
        onView(withId(R.id.recyclerview)).perform(
            RecyclerViewActions.actionOnItem<RecyclerView.ViewHolder>(
                withText("27"),
                click()
            )
        )
        onView(withText("15")).check(matches(isDisplayed()))
    }

    @Test
    fun testRecyclerViewValueDisplayedAfterClick() {
        testRecyclerViewFragmentNavigation()
        onView(withId(R.id.recyclerview))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                    15,
                    click()
                )
            )

        onView(withId(R.id.recycler_textview))
            .check(matches(withText("15")))
            .check(matches(isDisplayed()))
    }


}