package com.liuwill.kata.test

import com.liuwill.kata.BasicStack
import com.liuwill.kata.NumberNames.NumberNamesUtils
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

/**
 * Created by videopls on 2017/3/30.
 */
class NumberNamesUtilsTest {
    @Test
    fun test() {
        val expect:Int = 9234

        assertTrue { NumberNamesUtils().getString(expect) is String }
        assertEquals(expect.toString(), NumberNamesUtils().getString(expect))
        assertEquals(expect.toString(), "9234")
    }
}
