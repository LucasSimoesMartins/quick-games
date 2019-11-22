package com.lucassimoesmartins.quickgames

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

/**
 * Instrumented background, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under background.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.lucassimoesmartins.quickgames", appContext.packageName)
    }
}
