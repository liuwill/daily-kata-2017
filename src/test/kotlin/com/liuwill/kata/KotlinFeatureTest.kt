package com.liuwill.kata

import com.liuwill.kata.Diversion.BinaryDiversion
import org.junit.Assert.assertNotEquals
import org.junit.Test
import kotlin.test.assertEquals

/**
 * Created by liuwill on 2017/3/14.
 */
class KotlinFeatureTest {
    @Test fun testBinaryDiversion(){
        println("Test Binary Diversion")
        val BASE = 2.0
        val num = 4
        val notExpect = Math.pow(BASE, num.toDouble()).toInt()

        assertNotEquals(notExpect, BinaryDiversion().count(num))

        val expect = BinaryDiversion().count(num)
        val actual = BinaryDiversion().count(num-1) + BinaryDiversion().count(num-2)
        assertEquals(expect,actual)
    }

    @Test fun buildJavaFuncFromPhpArr(){
        val theList = arrayListOf(1,2,3,4,5,6)
        val doubleList = theList.map{
            it * 2
        }
        val oddList = theList.filter {
            it % 2 == 1
        }
        print("theList:")
        theList.forEach {
            print(it)
            print("-")
        }
        print("\n")
        print("doubleList:")
        doubleList.forEach {
            print(it)
            print("-")
        }
        print("\n")
        print("oddList:")
        oddList.forEach {
            print(it)
            print("-")
        }
        print("\n")
    }
}