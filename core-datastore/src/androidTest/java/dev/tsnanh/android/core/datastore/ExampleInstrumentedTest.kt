/*
 * Created by tsnanh on 6/4/22, 10:38 PM
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 6/4/22, 10:38 PM
 */

package dev.tsnanh.android.core.datastore

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("dev.tsnanh.android.core.datastore.test", appContext.packageName)
    }
}