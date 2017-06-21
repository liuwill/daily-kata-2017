package com.liuwill.kata.bdd.minefield;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by Liu Will on 2017/5/16.
 */

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/features/minefield"}, strict = true, monochrome = true, format = "junit:output", snippets = SnippetType.CAMELCASE)
public class MineFieldCukesTest {
    // this is the adapter/bridge code
    // between cucumber jvm and junit
    // you do not need to edit this
}
