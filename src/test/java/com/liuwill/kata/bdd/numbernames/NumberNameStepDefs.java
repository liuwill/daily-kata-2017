package com.liuwill.kata.bdd.numbernames;

import com.liuwill.kata.numbernames.NumberNamesUtils;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.After;

import static org.junit.Assert.assertEquals;

/**
 * Created by LiuWill on 2017/3/31.
 */
public class NumberNameStepDefs {
    private int number = 0;
    private int bits = 0;

    private static NumberNamesUtils numberNamesUtils = new NumberNamesUtils();

    @Given("^we will offer a int number with (\\d+) bit$")
    public void samplesHasList(int bits) throws Throwable {
        this.bits = bits;
    }

    @When("^it is (\\d+)$")
    public void theListsAre(int number) throws Throwable {
        this.number = number;

        assertEquals(this.bits, numberNamesUtils.getArray(number).length);
    }

    @Then("^result is \\[([a-z,\\s]+)\\]$")
    public void groupCountNumbersAre(String expect) throws Throwable {
        String finalActual = numberNamesUtils.spellNumberName(number);

        System.out.println("a " + bits + " bit number " + number + " will produce " + finalActual);
        if (number < 1000) {
            String actual = numberNamesUtils.transformDigits(numberNamesUtils.getArray(number));
            assertEquals(expect, actual);
        }
        assertEquals(expect, finalActual);
    }

    @After
    public void hook() {
        System.out.println("number names transform passed");
    }
}
