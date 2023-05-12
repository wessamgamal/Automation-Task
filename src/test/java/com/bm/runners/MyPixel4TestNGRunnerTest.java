package com.bm.runners;

import io.cucumber.testng.CucumberOptions;

/**
 * An example of using TestNG when the test class does not inherit from
 * AbstractTestNGCucumberTests but still executes each scenario as a separate
 * TestNG test.
 */
@CucumberOptions(
        plugin = {"pretty"
                , "html:target/Pixel4/cucumber/report.html"
                , "summary"
                , "me.jvt.cucumber.report.PrettyReports:target/MerchantReports/cucumber-html-reports",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"}
        ,features = {"src/test/java/com/bm/features/Sprint1"}
        ,glue = {"com.bm.stepdef"}
        ,dryRun=false
        ,monochrome=true
        ,tags = "@Regression"
)
public class MyPixel4TestNGRunnerTest extends RunnerBase {
}