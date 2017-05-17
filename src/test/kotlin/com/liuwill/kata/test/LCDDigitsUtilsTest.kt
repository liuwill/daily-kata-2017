package com.liuwill.kata.test

import com.liuwill.kata.lcdDigits.LcdUtils
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

/**
 * Created by LiuWill on 2017/3/26.
 */
class LCDDigitsUtilsTest {
    val lcdUtils = LcdUtils()

    @Test
    fun test() {
        val source:Char = '8'
        val expect = arrayOf(charArrayOf('.','_','.'),charArrayOf('|','_','|'),charArrayOf('|','_','|'))
        val deepExpect = "._.\n|_|\n|_|"

        val actual:Array<CharArray> = lcdUtils.encode(source)
        val deepActual = lcdUtils.printDigit(expect)

        assertTrue { lcdUtils.compare(expect,actual) }
        assertEquals(deepExpect,deepActual)

        println(lcdUtils.printDigit(expect))
    }

    @Test
    fun print() {
        val source:String = "910"
        val rawString = "0123456789"
        val sourceExpect = "._. ... ._.\n|_| ..| |.|\n..| ..| |_|"
        val expect:String = "._.   ...   ._.   ._.   ...   ._.   ._.   ._.   ._.   ._.\n|.|   ..|   ._|   ._|   |_|   |_.   |_.   ..|   |_|   |_|\n|_|   ..|   |_.   ._|   ..|   ._|   |_|   ..|   |_|   ..|"

        val actual = lcdUtils.print(lcdUtils.parse(rawString),3)
        val sourceActual = lcdUtils.print(lcdUtils.parse(source))

        assertEquals(sourceExpect,sourceActual)
        assertEquals(expect,actual)

        println(sourceActual)
        println(actual)
    }
}
