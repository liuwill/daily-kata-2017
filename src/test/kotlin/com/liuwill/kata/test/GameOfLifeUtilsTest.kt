package com.liuwill.kata.test

import com.liuwill.kata.GameOfLife.GameWorld
import com.liuwill.kata.GameOfLife.GodOfWorld
import com.liuwill.kata.GameOfLife.LifeCreator
import com.liuwill.kata.GameOfLife.WorldMapPrinter
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

/**
 * Created by LiuWill on 2017/4/23.
 */
class GameOfLifeUtilsTest {
    @Test
    fun test() {
        println(" ---**--- Game Of Life ---**--- ")

        val god = GodOfWorld.bigbang(4,8)
        val theWorld = god.gameWorld

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

        val originMap = WorldMapPrinter().stringify(theWorld)
        println(originMap+"\n")

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

            assertFalse(newWorld.equals(oldWorld))

            //val newMap = WorldMapPrinter().stringify(newWorld)
            WorldMapPrinter().println(newWorld)
        }
    }

    @Test
    fun testParse(){
        val input = ".*......\n*...*...\n.*.**...\n........"
        val rawStrList = input.trim().split("\n")

        val bitsData = LifeCreator().parseBitsFromMap(input)
        val gameWorld = GameWorld.makeWorld(rawStrList.size,rawStrList[0].length)

        val lives = LifeCreator().generateLivedFromData(bitsData,gameWorld)
        gameWorld.createLife(lives)

        println(" --**--  Test Parse  --**-- ")

        val finalMap = WorldMapPrinter().stringify(gameWorld)

        WorldMapPrinter().println(gameWorld)
        assertEquals(finalMap, input)
    }
}