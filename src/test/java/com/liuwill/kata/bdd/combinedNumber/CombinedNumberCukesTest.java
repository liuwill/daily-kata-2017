package com.liuwill.kata.bdd.combinedNumber;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by videopls on 2017/3/1.
 */
@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/features/combinedNumber"}, strict=true, monochrome=true, format="junit:output", snippets= SnippetType.CAMELCASE)
public class CombinedNumberCukesTest {
    // this is the adapter/bridge code
    // between cucumber jvm and junit
    // you do not need to edit this
}
