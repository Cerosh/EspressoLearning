package com.example.myapplication.espressolearning.utils

import android.os.IBinder
import android.view.WindowManager
import android.view.WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY
import android.view.WindowManager.LayoutParams.TYPE_TOAST
import androidx.test.espresso.Root
import org.hamcrest.Description
import org.hamcrest.TypeSafeMatcher

class ToastMatcher() : TypeSafeMatcher<Root?>() {
    override fun describeTo(description: Description?) {
        description?.appendText("nothing ")
    }

    override fun matchesSafely(item: Root?): Boolean {
        val type: Int? = item?.windowLayoutParams?.get()?.type

        if(TYPE_TOAST == type || TYPE_APPLICATION_OVERLAY == type) {
            val windowToken = item.decorView.windowToken
            val appToken = item.decorView.applicationWindowToken

            if(windowToken == appToken) {
                return true
            }
        }
        return false
    }

}