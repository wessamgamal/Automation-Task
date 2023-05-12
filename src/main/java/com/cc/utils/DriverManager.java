package com.cc.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.internal.Config;
import io.appium.java_client.ios.IOSDriver;
//import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v105.security.Security;
import org.openqa.selenium.devtools.v107.log.Log;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;


import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class DriverManager {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    LoggerManager utils = new LoggerManager();

    public WebDriver getDriver(){
        return driver.get();
    }

    public void setDriver(WebDriver driverValue){
        driver.set(driverValue);
    }

    public void initializeDriver() throws Exception {
       WebDriver driver = null;
        GlobalParams params = new GlobalParams();



        if(driver == null){
            try{
                utils.log().info("initializing Appium driver");
                switch(params.getPlatformName()){
                    case "Chrome":
                        ChromeOptions option = new ChromeOptions();
                        option.addArguments("--remote-allow-origins=*");
                        DevTools devTools;
                        Map<String, Object> prefs = new HashMap<String, Object>();
                        prefs.put("download.prompt_for_download", false);
                        prefs.put("download.default_directory", System.getProperty("user.dir"));
                        option.setExperimentalOption("prefs", prefs);
                       driver=new ChromeDriver(option);
                        driver.manage().window().maximize();
//                        driver.manage().window().setSize(new Dimension(400,756));
//                        driver.manage().window().setSize(new Dimension(412,914));  //samsung
//                        driver.manage().window().setSize(new Dimension(360,740));  //samsung S8+

                         devTools = ((ChromeDriver)driver).getDevTools();
                        devTools.send(Security.enable());
                        devTools.send(Security.setIgnoreCertificateErrors(true));
                        // get console log
                        devTools.createSession();
                        devTools.send(Log.enable());
                        devTools.addListener(Log.entryAdded(),logEntry -> {
                            System.out.println("Log text : " + logEntry.getText());
                            System.out.println("Log level : " + logEntry.getLevel());

                        });



                        break;
                    case "Android":
                        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), new CapabilitiesManager().getCaps());
                        break;
//                    case "iOS":
//                      driver = new IOSDriver(new ServerManager().getServer().getUrl(), new CapabilitiesManager().getCaps());
//                        break;
                }
                if(driver == null){
                    throw new Exception("driver is null. ABORT!!!");
                }
                utils.log().info("Driver is initialized");
                this.driver.set(driver);
            } catch (IOException e) {
                e.printStackTrace();
                utils.log().fatal("Driver initialization failure. ABORT !!!!" + e.toString());
                throw e;
            }
        }

    }

}
