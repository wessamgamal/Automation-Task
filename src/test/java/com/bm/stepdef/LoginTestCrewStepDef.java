package com.bm.stepdef;

import com.bm.pages.BasePage;
import com.bm.pages.LoginTestCrew;
import io.cucumber.java.en.Given;

import java.io.IOException;
import java.net.MalformedURLException;

import static io.netty.handler.codec.rtsp.RtspHeaders.Values.URL;

public class LoginTestCrewStepDef extends BasePage {
LoginTestCrew loginTestCrew = new LoginTestCrew();

    public LoginTestCrewStepDef() throws IOException {
    }


    @Given("User navigated to website {string}")
    public void user_navigated_to_website(String URL) {
        loginTestCrew.navigate_to_country_website(URL);
        takeScreenshotAllure();
    }


}
