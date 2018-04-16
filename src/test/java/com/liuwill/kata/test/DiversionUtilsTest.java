package com.liuwill.kata.test;

import com.liuwill.kata.diversion.DiversionHelper;
import com.liuwill.kata.diversion.DiversionMain;

import java.util.Random;

import org.junit.AfterClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by liuwill on 2017/3/9.
 */
public class DiversionUtilsTest {
    @Test
    public void checkCombinationMatch() {
        assertFalse(DiversionMain.match("111"));
        assertFalse(DiversionMain.match("0011"));
        assertTrue(DiversionMain.match("1010101"));
    }

    @Test
    public void generateCombinations() {
        int count = 5;
        Random random = new Random();
        for (; count > 0; count--) {
            int bit = random.nextInt(20);
            String[] combinations = DiversionMain.build(bit);
            int bitSqrt = DiversionMain.countCombinations(bit);

            assertEquals(bitSqrt, combinations.length);
        }
    }

    @Test
    public void testFibonacciCombination() {
        for (int i = 3; i < 10; i++) {
            String[] actualArr = DiversionMain.build(i);
            int actual = DiversionMain.countMatch(actualArr);

            String[] expectArr1 = DiversionMain.build(i - 1);
            String[] expectArr2 = DiversionMain.build(i - 2);
            int expect = DiversionMain.countMatch(expectArr1) + DiversionMain.countMatch(expectArr2);

            assertEquals(expect, actual);
        }
    }

    @Test
    public void testFibonacciValue() {
        int number = 5;

        int actual = DiversionHelper.count(number);
        int expect = DiversionHelper.count(number - 1) + DiversionHelper.count(number - 2);

        assertEquals(expect, actual);
    }

    @AfterClass
    public static void outputResult() {
        System.out.println("Diversion Utils Test");
    }
}
