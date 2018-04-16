package com.liuwill.kata.bdd.combinednumber;

import com.liuwill.kata.combinednumber.CombinedNumberMain;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertEquals;

/**
 * Created by liuwill on 2017/3/1.
 */
public class CombinedNumberStepDef {
    private int answer;

    @Given("^the hitch-hiker selects some tiles$")
    public void theHitchHikerSelectsSomeTiles() throws Throwable {
    }

    @When("^they spell (\\d+) times (\\d+)$")
    public void theySpellTimes(int arg1, int arg2) throws Throwable {
        answer = CombinedNumberMain.answer(arg1, arg2);
    }

    @Then("^the score is (\\d+)$")
    public void theScoreIs(int expected) throws Throwable {
        assertEquals(expected, answer);
    }
}
