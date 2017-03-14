package com.liuwill.kata

import com.liuwill.kata.Diversion.BinaryDiversion
import org.junit.Test
import kotlin.test.assertEquals

/**
 * Created by liuwill on 2017/3/14.
 */
class KotlinFeatureTest {
    @Test fun testBinaryDiversion(){
        println("Test Binary Diversion")

        val num = 4
        assertEquals(num, BinaryDiversion().count(num))
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