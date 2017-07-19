package com.liuwill.kata.test.fizzbuzz;

import com.liuwill.kata.fizzbuzz.FizzBuzzTranslator;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Liu Will on 2017/7/19.
 */
public class FizzTranslatorTest {
    @Test
    public void testTranslateOne(){
        String expect = "1";
        String result = FizzBuzzTranslator.translate(1);

        assertEquals(expect, result);
    }

    @Test
    public void testTranslateTwo(){
        String expect = "2";
        String result = FizzBuzzTranslator.translate(2);

        assertEquals(expect, result);
    }

    @Test
    public void testTranslateFizz(){
        String expect = "fizz";
        String result = FizzBuzzTranslator.translate(3);

        assertEquals(expect, result);
    }

    @Test
    public void testTranslateBuzz(){
        String expect = "buzz";
        String result = FizzBuzzTranslator.translate(5);

        assertEquals(expect, result);
    }
}
