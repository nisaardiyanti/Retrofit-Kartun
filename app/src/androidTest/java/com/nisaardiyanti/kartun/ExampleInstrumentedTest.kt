package com.nisaardiyanti.kartun

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

/**
 * Tes berinstrumen, yang akan dijalankan pada perangkat Android.
 *
 * Lihat [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
      // Konteks aplikasi yang sedang diuji
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.nisaardiyanti.kartun", appContext.packageName)
    }
}
