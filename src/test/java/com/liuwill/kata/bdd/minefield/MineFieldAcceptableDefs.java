package com.liuwill.kata.bdd.minefield;

import com.liuwill.kata.MineField.FieldDimension;
import com.liuwill.kata.MineField.FieldReader;
import com.liuwill.kata.MineField.MineField;
import com.liuwill.kata.MineField.MineFieldPrinter;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.After;

import static org.junit.Assert.assertEquals;

/**
 * Created by Liu Will on 2017/5/16.
 */
public class MineFieldAcceptableDefs {
    private int width = 0;
    private int height = 0;
    private String rawFieldInput = "";

    @Given("^a field which height is (\\d+) and width is (\\d+)$")
    public void samplesHasList(int height,int width) throws Throwable {
        System.out.println(" ---**--- Mine Field ---**--- ");
        System.out.println(" Width: "+width+" Height: "+height);

        this.width = width;
        this.height = height;
    }

    @When("^hidden field input is \\[([\\s\\S]+)\\]$")
    public void theListsAre(String rawFieldInput) throws Throwable {
        this.rawFieldInput = rawFieldInput.replaceAll("\\\\n","\n");

        FieldDimension expectDimension = new FieldDimension(width,height);
        FieldDimension targetDimension = FieldReader.readDimensionFromSource(this.rawFieldInput);
        assertEquals(expectDimension,targetDimension);
    }

    @Then("^preview field output is \\[([\\s\\S]+)\\]$")
    public void groupCountNumbersAre(String targetOut) throws Throwable {
        String realTargetOut = targetOut.replaceAll("\\\\n","\n");
        MineField mineField = FieldReader.readMineFieldFromSource(rawFieldInput);

        MineFieldPrinter mineFieldPrinter = new MineFieldPrinter();
        assertEquals(rawFieldInput, mineFieldPrinter.printRawField(mineField));
        System.out.println();
        System.out.println(rawFieldInput);

        assertEquals(realTargetOut, mineFieldPrinter.printField(mineField));
        System.out.println();
        System.out.println(realTargetOut);
    }

    @After
    public void hook(){
        System.out.println("mine field acceptable passed");
    }
}