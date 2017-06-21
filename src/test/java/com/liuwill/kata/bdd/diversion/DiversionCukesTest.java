package com.liuwill.kata.bdd.diversion;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by LiuWill on 2017/3/1.
 */
@RunWith(Cucumber.class)
@CucumberOptions(
    features = {"src/test/resources/features/diversion"},
    strict = true,
    monochrome = true,
    format = "junit:output",
    snippets = SnippetType.CAMELCASE)
public class DiversionCukesTest {
    // this is the adapter/bridge code
    // between cucumber jvm and junit
    // you do not need to edit this
}
