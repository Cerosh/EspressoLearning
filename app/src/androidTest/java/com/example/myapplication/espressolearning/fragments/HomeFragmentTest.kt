package com.example.myapplication.espressolearning.fragments

import android.view.View
import android.widget.TextView
import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.lifecycle.Lifecycle
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.myapplication.espressolearning.HomeFragment
import com.example.myapplication.espressolearning.R
import org.junit.Assert.assertEquals
import org.hamcrest.Matcher
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class HomeFragmentTest{
private  lateinit var scenario: FragmentScenario<HomeFragment>
@Before
fun setup(){
    scenario = launchFragmentInContainer()
    scenario.moveToState(Lifecycle.State.STARTED)
}
    @Test
    fun test_isHomeFragmentVisible(){
        onView(withId(R.id.home_title)).check(matches(withText(R.string.home_fragment_label)))
        onView(withId(R.id.activity_button)).check(matches(withText(R.string.activity_button)))
        onView(withId(R.id.dialog_button)).check(matches(withText(R.string.dialog_button)))
        onView(withId(R.id.control_button)).check(matches(withText(R.string.control_button)))
        onView(withId(R.id.toast_matcher_button)).check(matches(withText(R.string.toast_matcher_button)))
        onView(withId(R.id.list_button)).check(matches(withText(R.string.list_button)))
        onView(withId(R.id.recycler_view_button)).check(matches(withText(R.string.recycler_view_button)))
        onView(withId(R.id.mock_button)).check(matches(withText(R.string.mock_button)))
        onView(withId(R.id.intent_button)).check(matches(withText(R.string.intent_button)))
        onView(withId(R.id.resource_idling_button)).check(matches(withText(R.string.resource_idling_button)))
        onView(withId(R.id.spinner_button)).check(matches(withText(R.string.spinner_button)))
        onView(withId(R.id.progress_bar_button)).check(matches(withText(R.string.action_bar_button)))
        onView(withId(R.id.date_time_picker_button)).check(matches(withText(R.string.date_time_picker_button)))

    }
    @Test
    fun gettingTestFromTheScreen(){
        val homeTitleVI: ViewInteraction = onView(withId(R.id.home_title))
        assertEquals("Welcome to Espresso Learning", getText(homeTitleVI))
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
