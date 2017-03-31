package com.liuwill.kata.test

import com.liuwill.kata.BasicStack
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

/**
 * Created by videopls on 2017/3/30.
 */
class BasicStackTest {
    @Test
    fun test() {
        val expect = "123234312"
        val charStack = BasicStack<String>(5)
        charStack.push("noise")
        charStack.push(expect)

        val actual = charStack.pop()
        assertEquals(expect, actual)

        val booleanStack = BasicStack<Boolean>(5)
        booleanStack.push(true)
        assertTrue { booleanStack.pop() }
    }
}