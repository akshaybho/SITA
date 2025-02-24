package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.RegistrationPage;
import utility.Utility;

public class RegStepDef extends BaseClass {

    public RegistrationPage rp;

    String email = Utility.generateEmail();
    String firstName = Utility.generateName();
    String lastName = Utility.lastName();
    @Given("the user is on register page")
    public void the_user_is_on_register_page() {

        rp = new RegistrationPage(driver);
    }
    @When("the user fills the details")
    public void the_user_fills_the_details() {

        rp.enterDetails(firstName, lastName, email);
    }
    @And("user clicks on the proceed button")
    public void user_clicks_on_the_proceed_button() {

        rp.clicOnProceed();
    }
    @Then("user should able to see message of registration")
    public void user_should_able_to_see_message_of_registration() {

        rp.getMessage();

    }

}
