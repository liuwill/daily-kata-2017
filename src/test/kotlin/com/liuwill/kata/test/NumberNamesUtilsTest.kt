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

    @Test
    fun testSplit(){
        val expect1 = 12132423
        val expect2 = 121324
        val expect3 = 12132
        val expects = arrayOf(expect1,expect2,expect3)

        for(expect in expects){
            val actual = NumberNamesUtils().splitNumber(expect)
            actual.forEach(::print)
            println()

            println("Length:"+actual.size)
            actual.forEach {
                assertTrue {
                    it!!.length <= 3
                }
            }

            val expectLen = Math.ceil(expect.toString().length.toDouble()/3).toInt()
            assertEquals(expectLen,actual.size)
            assertEquals(expect.toString(),actual.joinToString(""))
        }

        /*val actual1 = NumberNamesUtils().splitNumber(expect1)
        val actual2 = NumberNamesUtils().splitNumber(expect2)
        val actual3 = NumberNamesUtils().splitNumber(expect3)

        actual1.forEach(::println)
        actual2.forEach(::println)
        actual3.forEach(::println)

        actual1.forEach {
            assertTrue {
                it!!.length <= 3
            }
        }

        assertEquals(expect1.toString().length/3+1,actual1.size)
        assertEquals(expect2.toString().length/3+1,actual2.size)
        assertEquals(expect3.toString().length/3+1,actual3.size)

        assertEquals(expect1.toString(),actual1.joinToString(""))
        assertEquals(expect2.toString(),actual2.joinToString(""))
        assertEquals(expect3.toString(),actual3.joinToString(""))*/
    }
}
