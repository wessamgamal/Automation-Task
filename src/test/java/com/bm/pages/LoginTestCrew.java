package com.bm.pages;

import com.cc.utils.PropertyManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

public class LoginTestCrew extends BasePage{

    Properties props = new PropertyManager().getProps();

    public LoginTestCrew() throws IOException {
    }




    public void navigate_to_country_website(String URL){
        driver.navigate().to(URL);
    }




}
