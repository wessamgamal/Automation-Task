package com.bm.stepdef;

import com.cc.utils.DriverManager;
import com.cc.utils.GlobalParams;
import com.cc.utils.VideoManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

/**
 * Hooks class for the before and after methods
 */
public class Hooks {

    @Before
    public void initialize() throws Exception {

        if(!new GlobalParams().getPlatformName().equals("Chrome"))    //back
//            if(!new GlobalParams().getPlatformName().equals("Android"))
            new VideoManager().startRecording();
        new DriverManager().initializeDriver();
    }

    @After
    public void quit(Scenario scenario) throws IOException {

        //Take a screenshot on failure
        if (scenario.isFailed()) {
            WebDriver driver = new DriverManager().getDriver();
            byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }

        if(!new GlobalParams().getPlatformName().equals("Chrome"))   //back
            new VideoManager().stopRecording(scenario.getName());  //back


        DriverManager driverManager = new DriverManager();
//        if(driverManager.getDriver() != null){
            driverManager.getDriver().quit();  //added
//            driverManager.setDriver(null);
//        }

    }
}
