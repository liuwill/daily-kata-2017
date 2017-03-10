package com.liuwill.kata.bdd;

import com.liuwill.kata.CombinedNumber.CombinedNumber;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertEquals;

/**
 * Created by videopls on 2017/3/8.
 */
public class CombinedNumberCompareStepdefs {
    private static String first;
    private static String second;
    private static String bigOne;

    @Given("^we has two number string$")
    public void weHasTwoNumberString() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    }

    @When("^which are (\\d+) and (\\d+)$")
    public void whichIsAnd(String arg0, String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        first = arg0;
        second = arg1;

        if(CombinedNumber.compareStringValue(arg0,arg1) == 1){
            bigOne = arg1;
        }else{
            bigOne = arg0;
        }
    }

    @Then("^the larger one is \"([^\"]*)\"$")
    public void theLargerOneIs(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        assertEquals(bigOne,arg0);
    }
}
