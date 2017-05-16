package com.liuwill.kata.test

import com.liuwill.kata.MineField.*
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

/**
 * Created by videopls on 2017/5/14.
 */
class MineFieldUtilsTest {
    private val DEFAULT_SAMPLE = "*...\n..*.\n....\n"

    @Test fun testReader() {
        val mineList = FieldReader.readMineFieldPositionsFromSource(DEFAULT_SAMPLE)

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

        val mineList = FieldReader.readMineFieldPositionsFromSource(DEFAULT_SAMPLE)
        for(fieldPos in mineList){
            mineField.setMine(fieldPos)
        }
        val firstPos = FieldPosition(0,0)
        val secondPos = FieldPosition(0,1)
        val thirdPos = FieldPosition(1,0)

        //val mineFieldMap = mineField.mineField
        val theItem = mineField.getItemFromPos(firstPos)
        val secItem = mineField.getItemFromPos(secondPos)
        val thirdItem = mineField.getItemFromPos(thirdPos)

        println(theItem.fieldPosition)
        println(secItem.fieldPosition)
        println(theItem.fieldPosition.toString()+theItem.count+theItem.icon)
        println(secItem.fieldPosition.toString()+secItem.count+secItem.icon)
        println(thirdItem.fieldPosition.toString()+thirdItem.count+thirdItem.icon)

        println(MineFieldPrinter().printRawField(mineField))
        println()
        println(MineFieldPrinter().printField(mineField))
        println()
    }

    @Test fun testReadDimension(){
        val expectDimension = FieldReader.readDimensionFromSource(DEFAULT_SAMPLE)

        val mineLines = DEFAULT_SAMPLE.trim().split("\n")
        val y = mineLines.size
        val x = mineLines[0].length

        val targetDimension = FieldDimension(x,y)

        mineLines.forEach { assertEquals(x,it.length) }
        assertEquals(x,expectDimension.width)
        assertEquals(y,expectDimension.height)
        assertEquals(expectDimension,targetDimension)
    }

    @Test fun testReadMineList(){
        val mineList = FieldReader.readMineFieldPositionsFromSource(DEFAULT_SAMPLE)

        val mineLines = DEFAULT_SAMPLE.trim().split("\n")

        mineList.forEach { assertEquals(MineField.MINE_ICON, mineLines[it.y][it.x].toString()) }
    }

    @Test fun testReadMineField(){
        val mineList = FieldReader.readMineFieldPositionsFromSource(DEFAULT_SAMPLE)
        val mineField = FieldReader.readMineFieldFromSource(DEFAULT_SAMPLE)

        mineList
            .map { mineField.getItemFromPos(it) }
            .forEach {
                assertTrue(it.isMine)
                assertEquals(it.icon,MineField.MINE_ICON)
                assertEquals(it.rawIcon,MineField.MINE_ICON)
            }

        assertEquals("*",MineField.MINE_ICON)
    }
}