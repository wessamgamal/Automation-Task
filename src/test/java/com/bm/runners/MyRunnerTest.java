package com.bm.runners;

import com.cc.utils.DriverManager;
import com.cc.utils.GlobalParams;
import com.cc.utils.ServerManager;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.apache.logging.log4j.ThreadContext;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import java.io.File;

import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty"
                , "html:target/cucumber/report.html"
                , "summary"
                , "me.jvt.cucumber.report.PrettyReports:target/Pixel3/cucumber-html-reports"
                ,"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
                "junit:target/cucumber/result.xml", "json:target/cucumber/results/results.json"}
        ,glue = {"com.bm.stepdef"}

        ,features = {"src/test/java/com/bm/features/TestCrew.feature"}

        ,snippets = CAMELCASE
        //check whether all feature file steps have corresponding step definitions
        ,dryRun=false
        //set console output from Cucumber in a readable format
        ,monochrome=true
//  ,tags = "@regression"


)

public class MyRunnerTest {

    @BeforeClass
    public static void initialize() throws Exception {
        GlobalParams params = new GlobalParams();
        params.initializeGlobalParams();


        ThreadContext.put("ROUTINGKEY", "target"+ File.separator+params.getPlatformName() + "_"
                + params.getDeviceName());

        if (!params.getPlatformName().equals("Chrome"))  //back

            new ServerManager().startServer();

;
        new DriverManager().initializeDriver();
    }

    @AfterClass
    public static void quit(){


        ServerManager serverManager = new ServerManager();  //back
        if(serverManager.getServer() != null){
            serverManager.getServer().stop();
        }

        DriverManager driverManager = new DriverManager();
        if(driverManager.getDriver() != null){
            driverManager.getDriver().quit();
            driverManager.setDriver(null);
        }

    }
}
