package com.juaracoding.ujian5.moduletest;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/main/resources/features/"},
        glue = {"com.juaracoding.ujian5.moduletest"},
        plugin = {"pretty","html:target/cucumber-report.html","json:target/cucumber.json"}
)
public class RunnerClass extends AbstractTestNGCucumberTests {

}
