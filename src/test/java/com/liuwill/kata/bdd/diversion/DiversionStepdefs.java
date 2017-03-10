package com.liuwill.kata.bdd;

import com.liuwill.kata.Diversion.DiversionHelper;
import com.liuwill.kata.Diversion.DiversionMain;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by videopls on 2017/3/9.
 */
public class DiversionStepdefs {
    List<Integer> bitList;

    @Given("^samples has (\\d+) list$")
    public void samplesHasList(int arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
    }

    @When("^the lists are$")
    public void theListsAre(DataTable listTable) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
        bitList = listTable.asList(Integer.class);
    }

    @Then("^combinations result numbers are$")
    public void groupCountNumbersAre(DataTable listTable) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
        List<Integer> resultList = listTable.asList(Integer.class);

        assertEquals(bitList.size(),resultList.size());
        for(int i = 0; i < resultList.size();i++){
            int bit = bitList.get(i);
            int result = resultList.get(i);
            String[] verifyArr = DiversionMain.build(bit);

            assertEquals(result, DiversionMain.countMatch(verifyArr));
            assertEquals(result, DiversionHelper.count(bit));
        }
    }
}
