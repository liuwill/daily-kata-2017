package com.liuwill.kata.test

import com.liuwill.kata.GameOfLife.GodOfWorld
import com.liuwill.kata.GameOfLife.LifeCreator
import com.liuwill.kata.GameOfLife.WorldMapPrinter
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

/**
 * Created by videopls on 2017/4/23.
 */
class GameOfLifeUtilsTest {
    @Test
    fun test() {
        println(" ---**--- Game Of Life ---**--- ")

        val god = GodOfWorld()
        val theWorld = god.createWorld(4,8)

        val source = arrayOf(
            arrayOf(0,0,0,0,0,0,0,0),
            arrayOf(0,0,0,0,1,0,0,0),
            arrayOf(0,0,0,1,1,0,0,0),
            arrayOf(0,0,0,0,0,0,0,0)
        )
        val lives = LifeCreator().generateLivedFromData(source,theWorld)
        theWorld.createLife(lives)
        val newWorld = theWorld.grow()

        val originMap = WorldMapPrinter().print(theWorld)
        val finalMap = WorldMapPrinter().print(newWorld)

        println(originMap)

        println(finalMap)
//        val expect:Int = 9234
//        assertEquals(expect.toString(), "9234")
    }
}