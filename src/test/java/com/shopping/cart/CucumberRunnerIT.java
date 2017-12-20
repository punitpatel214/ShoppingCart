package com.shopping.cart;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        format = {"html:target/cucumber-report-html", "json:target/cucumber-report.json"},
        features = {"src/test/resources/features/"})
public class CucumberRunnerIT {
}
