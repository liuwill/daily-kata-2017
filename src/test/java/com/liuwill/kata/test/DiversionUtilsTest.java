package com.liuwill.kata.test;

import com.liuwill.kata.Diversion.DiversionMain;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by videopls on 2017/3/9.
 */
public class DiversionUtilsTest {
    @Test
    public void checkCombinationMatch(){
        assertFalse(DiversionMain.match("111"));
        assertFalse(DiversionMain.match("0011"));
        assertTrue(DiversionMain.match("1010101"));
    }

    @Test public void generateCombinations(){
        int bit = 5;
        String[] combinations = DiversionMain.build(bit);
        int bitSqrt = DiversionMain.countCombinations(bit);

        assertEquals(bitSqrt,combinations.length);
    }
}
