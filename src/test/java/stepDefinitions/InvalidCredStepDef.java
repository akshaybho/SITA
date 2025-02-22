package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.InvalidCred;

public class InvalidCredStepDef extends BaseClass {

    public InvalidCred ic;
    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {

        ic = new InvalidCred(driver);

    }
    @When("the user enters {string} and {string}")
    public void the_user_enters_and(String a, String b) {

        ic.enterCred(a,b);

    }
    @And("clicks on the login button")
    public void clicks_on_the_login_button() {

        ic.clickonSignIn();
    }
    @Then("user should see an error message")
    public void user_should_see_an_error_message() {

        ic.getErrorMessage();
    }

}
