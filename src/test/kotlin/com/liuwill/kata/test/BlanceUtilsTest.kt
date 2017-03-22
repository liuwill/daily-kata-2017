package com.liuwill.kata.test

import com.liuwill.kata.balanced.BalancedStack
import com.liuwill.kata.balanced.BalancedUtils
import junit.framework.Assert.assertFalse
import org.junit.After
import org.junit.AfterClass
import org.junit.Assert.assertNotEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals

/**
 * Created by videopls on 2017/3/18.
 */

class BlanceUtilsTest {
    var balancedUtils:BalancedUtils = BalancedUtils()

    @Test
    fun test() {
        val leftParentheses = BalancedUtils.LEFT_PARENTHESES
        val rightParentheses = BalancedUtils.RIGHT_PARENTHESES
        val rightBrackets = BalancedUtils.RIGHT_BRACKET
        val leftBrackets = BalancedUtils.LEFT_BRACKET
        val rightBrace = BalancedUtils.RIGHT_BRACE
        val leftBrace = BalancedUtils.LEFT_BRACE

        assertTrue(balancedUtils.compareElementBalance(leftParentheses,rightParentheses))
        assertTrue(balancedUtils.compareElementBalance(leftBrace,rightBrace))
        assertTrue(balancedUtils.compareElementBalance(leftBrackets,rightBrackets))

        assertFalse(balancedUtils.compareElementBalance(rightBrackets,leftParentheses))
        assertFalse(balancedUtils.compareElementBalance(rightParentheses,leftParentheses))
    }

    @Test
    fun testComput(){
        val str = "{}({)}"
        val str3 = "{}{()}"
        val strCount = balancedUtils.compute(str)
        assertEquals(0,strCount)
        assertNotEquals(balancedUtils.countLeft(str3),strCount)

        assertEquals(balancedUtils.countLeft(str3),balancedUtils.compute(str3))
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
        println("balanced stack & utils Test")
    }
}