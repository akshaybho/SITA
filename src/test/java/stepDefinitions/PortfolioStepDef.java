package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageObjects.PortfolioPage;
import utility.Utility;

import java.util.Arrays;
import java.util.List;

public class PortfolioStepDef extends BaseClass {

    PortfolioPage p;

    @And("User can able to see {string} on home page")
    public void user_can_able_to_see_on_home_page(String expected) {

        p = new PortfolioPage(driver);
        String actual = p.verifyPortfolio();
        if(actual.equals(expected))
        {
            System.out.println("Pass");
        }
        else
        {
            System.out.println("Fail");
        }
    }

    @Then("User verifies the Portfolio spotlight list matches the expected list")
    public void user_verifies_the_portfolio_spotlight_list_matches_the_expected_list() {

        List <String> actual = p.getPortfolioActualText();
        List <String> expected = Utility.getListFromJsonArray("D:\\Cucumber-SITA\\SITA\\src\\test\\resources\\data.json");

        if(actual.equals(expected))
        {
            System.out.println("List matches");
        }
        else
        {
            System.out.println("Mismatch");
        }
    }
}
