package stepDefinitions;


import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.RegisterSignPage;

public class RegSignStepDef extends BaseClass {

    @Before
    public void setUp() throws InterruptedException {
        openBrowser("chrome");

    }
    public  RegisterSignPage rs;
    @Given("I click on DIGIHUB on homepage")
    public void i_click_on_digihub_on_homepage()  {
        rs = new RegisterSignPage(driver);
        rs.clickdigiHub();
    }
    @Then("I can able to see SignIn button")
    public void i_can_able_to_see_sign_in_button() {

        rs.getSignInText();
    }
    @When("I click on SignIn button")
    public void i_click_on_sign_in_button() {

        rs.clickOnSignIn();
    }
    @Then("I landed onto SignIn page")
    public void i_landed_onto_sign_in_page() {

        rs.validateSignInPage();
    }

    @Then("I should see the Register button")
    public void i_should_able_to_see_the_regiter_button() {

        rs.getRegistrationText();
    }
    @When("I click on the Register button")
    public void i_click_on_register_button() {

        rs.clickOnRegisterButton();
    }
    @Then("I should be redirected to the registration form")
    public void i_should_be_redirected_to_the_registration_form() {

        rs.validateRegistrationPage();
    }


}
