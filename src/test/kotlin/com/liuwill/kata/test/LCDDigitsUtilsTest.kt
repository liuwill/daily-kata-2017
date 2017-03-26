package com.liuwill.kata.test

import com.liuwill.kata.lcdDigits.LcdUtils
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

/**
 * Created by videopls on 2017/3/26.
 */
class LCDDigitsUtilsTest {
    val lcdUtils = LcdUtils()

    @Test
    fun test() {
        val source:Char = '8'
        val expect = arrayOf(charArrayOf('.','_','.'),charArrayOf('|','_','|'),charArrayOf('|','_','|'))
        val deepExpect = "._.\n|_|\n|_|\n"

        val actual:Array<CharArray> = lcdUtils.encode(source)
        val deepActual = lcdUtils.printDigit(expect)

        assertTrue { lcdUtils.compare(expect,actual) }
        assertEquals(deepExpect,deepActual)

        println(lcdUtils.printDigit(expect))
    }

    @Test
    fun print() {
        val source:String = "991"

        println(lcdUtils.print(lcdUtils.parse(source)))
        println(lcdUtils.print(lcdUtils.parse("910")))
    }
}
