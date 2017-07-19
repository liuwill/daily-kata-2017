package com.liuwill.kata.test.fizzbuzz;

import com.liuwill.kata.fizzbuzz.TemplateTranslator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Created by Liu Will on 2017/7/19.
 */
@RunWith(Parameterized.class)
public class TemplateTranslatorTest {
    private Integer inputNumber;
    private String expectedResult;

    public TemplateTranslatorTest(Integer inputNumber,
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
        String target = TemplateTranslator.translate(expect);

        assertEquals(this.expectedResult, target);
    }
}
