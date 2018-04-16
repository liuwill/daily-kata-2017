package com.liuwill.kata.bdd.combinednumber;

import com.liuwill.kata.combinednumber.CombinedNumber;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertEquals;

/**
 * Created by liuwill on 2017/3/8.
 */
public class CombinedNumberMiddleStepdefs {
    private static int compareResult;

    @Given("^we has two number string equal$")
    public void weHasTwoNumberStringEqual() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    }

    @When("^which has values (\\d+) and (\\d+)$")
    public void whichHasValuesAnd(String arg0, String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        compareResult = CombinedNumber.compareStringValue(arg0, arg1);
    }

    @Then("^compare value ([-]?\\d+)$")
    public void compareValue(int arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        assertEquals(arg0, compareResult);
    }
}
