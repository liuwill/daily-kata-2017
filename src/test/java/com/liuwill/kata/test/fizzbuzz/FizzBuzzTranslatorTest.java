package com.liuwill.kata.test.fizzbuzz;

import com.liuwill.kata.fizzbuzz.FizzBuzzTranslator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Liu Will on 2017/7/19.
 */
@RunWith(Parameterized.class)
public class FizzBuzzTranslatorTest {
    private Integer inputNumber;
    private String expectedResult;

    public FizzBuzzTranslatorTest(Integer inputNumber,
                                  String expectedResult) {
        this.inputNumber = inputNumber;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Collection expectPairs() {
        return Arrays.asList(new Object[][]{
                {1, "1"},
                {2, "2"},
                {3, "Fizz"},
                {5, "Buzz"},
                {6, "Fizz"},
                {10, "Buzz"},
                {15, "FizzBuzz"}
        });
    }

    @Test
    public void testTranslateFizzBuzz() {
        int expect = this.inputNumber;
        String target = FizzBuzzTranslator.translate(expect);

        assertEquals(this.expectedResult, target);
    }
}
