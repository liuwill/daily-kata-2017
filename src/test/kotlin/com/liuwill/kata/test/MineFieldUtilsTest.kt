package com.liuwill.kata.test

import com.liuwill.kata.MineField.FieldDimension
import com.liuwill.kata.MineField.FieldReader
import com.liuwill.kata.MineField.MineField
import org.junit.Test
import kotlin.test.assertEquals

/**
 * Created by videopls on 2017/5/14.
 */
class MineFieldUtilsTest {
    private val DEFAULT_SAMPLE = "*...\n..*.\n....\n"

    @Test fun testReader() {
        val mineList = FieldReader.readMineFieldFromSource(DEFAULT_SAMPLE)

        val expectLength = DEFAULT_SAMPLE.filter { it == '*' }.length
        assertEquals(expectLength,mineList.size)

        for(item in mineList){
            println(item)
        }
        println("Test MineField Reader")
    }

    @Test fun testCreateMineField() {
        val mineLines = DEFAULT_SAMPLE.trim().split("\n")
        val y = mineLines.size
        val x = mineLines[0].length

        val fieldDimension = FieldDimension(x,y)
        val mineField = MineField(fieldDimension)
    }
}