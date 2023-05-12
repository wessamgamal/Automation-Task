package com.cc.utils;

import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;


public class CapabilitiesManager {
    LoggerManager utils = new LoggerManager();

    /**
     * set and get the capabilities form the global params and properties files
     * @return desired capabilities
     * @throws IOException
     */
    public DesiredCapabilities getCaps() throws IOException {
        GlobalParams params = new GlobalParams();
        Properties props = new PropertyManager().getProps();

        try{
            utils.log().info("getting capabilities");
            DesiredCapabilities caps = new DesiredCapabilities();


            switch(params.getPlatformName()){
                case "Chrome":
                   // caps.setCapability(CapabilityType.BROWSER_NAME, "Chrome");


                    break;
                case "Android":
                    caps.setCapability(MobileCapabilityType.PLATFORM, params.getPlatformName());
                    caps.setCapability(MobileCapabilityType.UDID, params.getUDID());
                    caps.setCapability(MobileCapabilityType.DEVICE_NAME, params.getDeviceName());
//                    caps.setCapability(MobileCapabilityType.BROWSER_NAME,params.getBrowsername());  // added by wessam
                    caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, props.getProperty("androidAutomationName"));
                    caps.setCapability("appPackage", props.getProperty("androidAppPackage"));
                    caps.setCapability("appActivity", props.getProperty("androidAppActivity"));
                    caps.setCapability("systemPort", params.getSystemPort());
//                    caps.setCapability("browserName" , params.getBrowsername());  // added by wessam
//                    caps.setCapability("chrome.switches", Arrays.asList("--ignore-certificate-errors")); //added by wessam
//                    caps.setCapability("chromedriverExecutable" , "C:/Users/Admin/Documents/appium docs/chromedriver.exe");
//                    caps.setCapability("acceptSslCerts" , "true");
//                    caps.setCapability("browserstack.acceptInsecureCerts","true");

                    String androidAppUrl = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
                            + File.separator + "resources" + File.separator + "apps" + File.separator + "app-google-cashCollection-debug.apk";
                    utils.log().info("appUrl is" + androidAppUrl);
                    caps.setCapability("app", androidAppUrl);
                    break;
                case "iOS":
                    caps.setCapability(MobileCapabilityType.PLATFORM, params.getPlatformName());
                    caps.setCapability(MobileCapabilityType.UDID, params.getUDID());
                    caps.setCapability(MobileCapabilityType.DEVICE_NAME, params.getDeviceName());
                    caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, props.getProperty("iOSAutomationName"));
                    String iOSAppUrl = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
                            + File.separator + "resources" + File.separator + "apps" + File.separator + "SwagLabsMobileApp.app";
                    utils.log().info("appUrl is" + iOSAppUrl);
                    caps.setCapability("bundleId", props.getProperty("iOSBundleId"));
                    caps.setCapability("wdaLocalPort", params.getWdaLocalPort());
                    caps.setCapability("webkitDebugProxyPort", params.getWebkitDebugProxyPort());
                    caps.setCapability("app", iOSAppUrl);
                    break;
            }
            return caps;
        } catch(Exception e){
            e.printStackTrace();
            utils.log().fatal("Failed to load capabilities. ABORT!!" + e.toString());

            throw e;
        }
    }
}
