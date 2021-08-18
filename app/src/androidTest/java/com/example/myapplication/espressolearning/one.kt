package com.example.myapplication.espressolearning


import android.view.View
import android.view.ViewGroup
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class one {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun one() {
        val materialButton = onView(
allOf(withId(R.id.progress_bar_button), withText("Progress Bar"),
childAtPosition(
allOf(withId(R.id.homeFragment),
childAtPosition(
withId(R.id.nav_host_fragment_content_main),
0)),
11),
isDisplayed()))
        materialButton.perform(click())
        
        val materialButton2 = onView(
allOf(withId(R.id.show_progress_bar_button), withText("Progress Bar"),
childAtPosition(
allOf(withId(R.id.progress_bar_view),
childAtPosition(
withId(R.id.nav_host_fragment_content_main),
0)),
2),
isDisplayed()))
        materialButton2.perform(click())
        
        val textView = onView(
allOf(withId(R.id.progress_bar_textview), withText("100/100"),
withParent(allOf(withId(R.id.progress_bar_view),
withParent(withId(R.id.nav_host_fragment_content_main)))),
isDisplayed()))
        textView.check(matches(withText("100/100")))
        }
    
    private fun childAtPosition(
            parentMatcher: Matcher<View>, position: Int): Matcher<View> {

        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description) {
                description.appendText("Child at position $position in parent ")
                parentMatcher.describeTo(description)
            }

            public override fun matchesSafely(view: View): Boolean {
                val parent = view.parent
                return parent is ViewGroup && parentMatcher.matches(parent)
                        && view == parent.getChildAt(position)
            }
        }
    }
    }
