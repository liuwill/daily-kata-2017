package com.liuwill.kata.bdd.diversion;

import com.liuwill.kata.diversion.DiversionMain;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by LiuWill on 2017/3/10.
 */
public class DiversionBasicStepDef {
    List<String> binaryArr;

    @Given("^a list of binary number$")
    public void aListOfBinaryNumber() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    }

    @When("^give binary below$")
    public void giveBinaryBelow(DataTable listTable) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        binaryArr = listTable.asList(String.class);
    }

    @Then("^it has (\\d+) binary match$")
    public void itHasBinaryMatch(int expect) throws Throwable {
        // Write code here that turns the phrase above into concrete actions

        String[] actualArr = new String[binaryArr.size()];
        int actual = DiversionMain.countMatch(binaryArr.toArray(actualArr));
        assertEquals(expect, actual);
    }
}
