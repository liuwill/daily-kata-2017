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

        val god = GodOfWorld.bigbang()
        val theWorld = god.createWorld(4,8)

        /*val source = arrayOf(
            arrayOf(0,0,0,0,0,0,0,0),
            arrayOf(0,0,0,0,1,0,0,0),
            arrayOf(0,0,0,1,1,0,0,0),
            arrayOf(0,0,0,0,0,0,0,0)
        )*/
        val source = arrayOf(
            arrayOf(0,1,0,0,0,0,0,0),
            arrayOf(1,0,0,0,1,0,0,0),
            arrayOf(0,1,0,1,1,0,0,0),
            arrayOf(0,0,0,0,0,0,0,0)
        )
        val lives = LifeCreator().generateLivedFromData(source,theWorld)
        theWorld.createLife(lives)
        assertEquals(theWorld, god.gameWorld)

        val originMap = WorldMapPrinter().print(theWorld)
        println(originMap)

        var itr = 0
        var worldMark = true
        while (itr++ < 10 && worldMark){
            val oldWorld = god.gameWorld
            val newWorld = oldWorld.grow()

            assertEquals(newWorld, god.gameWorld)

            if(newWorld.equals(oldWorld) || !newWorld.isAlive){
                worldMark = false
                continue
            }

            val newMap = WorldMapPrinter().print(newWorld)
            println(newMap)
        }
    }
}