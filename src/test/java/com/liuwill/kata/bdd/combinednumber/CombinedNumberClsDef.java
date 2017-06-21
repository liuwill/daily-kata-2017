package com.liuwill.kata.bdd.combinednumber;

import com.liuwill.kata.combinednumber.CombinedNumber;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by videopls on 2017/3/7.
 */
public class CombinedNumberClsDef {
    private static int itemCount;
    private static CombinedNumber combinedNumber;

    @Given("^still a list has (\\d+) items$")
    public void theFunctionReceiveListOne(Integer itemCount) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
        this.itemCount = itemCount;
    }

    @When("^we have$")
    public void theListIs(DataTable listTabel) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
        List<String> dataList = listTabel.asList(String.class);

        combinedNumber = new CombinedNumber(dataList);
        assertEquals(this.itemCount, combinedNumber.size());
    }

    @Then("^max item is \"([^\"]*)\"$")
    public void maxNumberIs(String expectStr) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
        String maxStr = combinedNumber.popMax();
        assertEquals(expectStr, maxStr);
        assertEquals(this.itemCount - 1, combinedNumber.size());
    }
}
