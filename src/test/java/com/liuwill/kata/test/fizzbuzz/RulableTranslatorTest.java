package com.liuwill.kata.test.fizzbuzz;

import com.liuwill.kata.fizzbuzz.FizzBuzzTranslator;
import com.liuwill.kata.fizzbuzz.RulableTranslator;
import com.liuwill.kata.fizzbuzz.TranslateRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Liu Will on 2017/7/19.
 */
@RunWith(Parameterized.class)
public class RulableTranslatorTest {
    private Integer inputNumber;
    private String expectedResult;

    public RulableTranslatorTest(Integer inputNumber,
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

        List<TranslateRule> ruleList = new ArrayList<>();
        ruleList.add((builder, in) -> {
            if (FizzBuzzTranslator.isFizz(in)) {
                builder.append(FizzBuzzTranslator.FIZZ_WORD);
            }
        });

        ruleList.add((builder, in) -> {
            if (FizzBuzzTranslator.isBuzz(in)) {
                builder.append(FizzBuzzTranslator.BUZZ_WORD);
            }
        });

        ruleList.add((builder, in) -> {
            if (builder.length() == 0) {
                builder.append(in.toString());
            }
        });
        String target = RulableTranslator.translate(ruleList, expect);

        assertEquals(this.expectedResult, target);
    }
}
