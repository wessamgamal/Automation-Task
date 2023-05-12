package com.bm.runners;

import io.cucumber.testng.CucumberOptions;

/**
 * An example of using TestNG when the test class does not inherit from
 * AbstractTestNGCucumberTests but still executes each scenario as a separate
 * TestNG test.
 */
@CucumberOptions(
        plugin = {"pretty"
                , "html:target/Pixel3/cucumber/report.html"
                , "summary"
                , "me.jvt.cucumber.report.PrettyReports:target/Pixel3/cucumber-html-reports",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"}
        ,features = {"src/test/java/com/bm/features"}
        ,glue = {"com.bm.stepdef"}
        ,dryRun=false
        ,monochrome=true
        ,tags = "@Sanity"
)
public class MyPixel3TestNGRunnerTest extends RunnerBase {
}