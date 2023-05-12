package com.bm.stepdef;

import com.bm.pages.BasePage;
import com.bm.pages.TestCrew;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;



public class TestCrewStepDef extends BasePage {
TestCrew testCrew = new TestCrew();

    @Given("validate subscription Details is as expected for specific {string}")
    public void validate_subscription_details_is_as_expected_for_specific(String country) {
        if (country.equals("sa")){

            System.out.println("SA Subscription Types and details");
            testCrew.Validate_SA_classic_Plan_Details();
        testCrew.Validate_Lite_SA_Lite_Plan_Details();
        testCrew.Validate_SA_Premium_Plan_Details();}


        else if (country.equals("kw")) {
            System.out.println("Kwait Subscription Types and details");
            testCrew.Validate_kw_classic_Plan_Details();
            testCrew.Validate_kw_Lite_Plan_Details();
            testCrew.Validate_kw_Premium_Plan_Details();
        }
        else if (country.equals("bh")) {
            System.out.println("Bahrain Subscription Types and details");
            testCrew.Validate_BH_classic_Plan_Details();
            testCrew.Validate_BH_Lite_Plan_Details();
            testCrew.Validate_BH_Premium_Plan_Details();

        }

    }

    @Then("Close the website")
    public void close_the_website() {
        testCrew.close_website();
    }

}
