package com.liuwill.kata.bdd.combinednumber;

import com.liuwill.kata.combinednumber.CombinedNumber;
import com.liuwill.kata.combinednumber.CombinedNumberMain;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by liuwill on 2017/3/3.
 */
public class CombinedNumberFinalDef {
    public static List<String> dataList;
    public static Integer itemCount;
    private CombinedNumber combinedNumber;

    @Given("^a list has (\\d+) items$")
    public void theFunctionReceiveListOne(Integer itemCount) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
        CombinedNumberFinalDef.itemCount = itemCount;
    }

    @When("^the list is$")
    public void theListIs(DataTable listTabel) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
        List<String> dataList = listTabel.asList(String.class);
        CombinedNumberFinalDef.dataList = new ArrayList<>(dataList);

        assertEquals(CombinedNumberFinalDef.itemCount.intValue(), dataList.size());
        assertEquals(true, dataList.size() > 0);

        combinedNumber = new CombinedNumber(dataList);
    }

    @Then("^max number is \"([^\"]*)\"$")
    public void maxNumberIs(String expectStr) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
        String maxStr = CombinedNumberMain.calc(CombinedNumberFinalDef.dataList);
        assertEquals(expectStr, maxStr);
        assertEquals(expectStr, combinedNumber.concat());
    }
}
