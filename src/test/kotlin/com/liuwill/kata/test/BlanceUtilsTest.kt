package com.liuwill.kata.test

import com.liuwill.kata.balanced.BalancedStack
import com.liuwill.kata.balanced.BalancedUtils
import junit.framework.Assert.assertFalse
import org.junit.After
import org.junit.AfterClass
import org.junit.Assert.assertTrue
import org.junit.Test
import kotlin.test.assertEquals

/**
 * Created by videopls on 2017/3/18.
 */

class BlanceUtilsTest {
    @Test
    fun test() {
        val leftParentheses = BalancedUtils.LEFT_PARENTHESES
        val rightParentheses = BalancedUtils.RIGHT_PARENTHESES
        val rightBrackets = BalancedUtils.RIGHT_BRACKET
        val leftBrackets = BalancedUtils.LEFT_BRACKET
        val rightBrace = BalancedUtils.RIGHT_BRACE
        val leftBrace = BalancedUtils.LEFT_BRACE

        assertTrue(BalancedUtils().compareElementBalance(leftParentheses,rightParentheses))
        assertTrue(BalancedUtils().compareElementBalance(leftBrace,rightBrace))
        assertTrue(BalancedUtils().compareElementBalance(leftBrackets,rightBrackets))

        assertFalse(BalancedUtils().compareElementBalance(rightBrackets,leftParentheses))
        assertFalse(BalancedUtils().compareElementBalance(rightParentheses,leftParentheses))
    }

    @Test
    fun testComput(){
        val str = "{}({)}"
        val str3 = "{}{()}"
        val strCount = BalancedUtils().compute(str)
        assertEquals(0,strCount)
        assertEquals(3,BalancedUtils().compute(str3))
    }

    @Test
    fun testStack(){
        val str = "12345677"
        val charArr = str.toCharArray()
        val balanceStack = BalancedStack(str.length)
        for (chr in charArr){
            balanceStack.push(chr)
        }

        assertEquals(str.length,balanceStack.length())
        assertEquals(str.length,balanceStack.size())
        while (balanceStack.size() > 0){
            val cursor = balanceStack.size()
            assertEquals(charArr[cursor-1],balanceStack.pop())
        }
    }

    @After
    fun outputResult() {
        println("balanced utils Test")
    }
}