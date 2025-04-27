package stepDefinitions;

import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pageObjects.LogoPage;
import utility.Utility;

import java.io.IOException;

public class LogoStepDef extends BaseClass {

    LogoPage lp;

    @Given("User landed on home page")
    public void user_landed_on_home_page() {

        lp = new LogoPage(driver);
    }

    @And("User verify logo")
    public void user_verify_logo() {

        lp.verifyLogo();
    }


}
