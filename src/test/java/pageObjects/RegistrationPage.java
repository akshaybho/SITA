package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {

    WebDriver driver;
    public RegistrationPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);// Initializes all @FindBy elements
    }

    @FindBy(css = "input#firstName")
    WebElement firstName;

    @FindBy(css = "input#lastName")
    WebElement lastName;

    @FindBy(css = "input#email")
    WebElement email;

    @FindBy(xpath = "//p-button[@label='Proceed']")
    WebElement proceedButton;

    @FindBy(xpath = "//p[text()='Thanks for registering with us.']")
    WebElement registerText;


    public void enterDetails(String name, String last, String mail)
    {
        firstName.sendKeys(name);
        lastName.sendKeys(last);
        email.sendKeys(mail);
    }

    public void clicOnProceed()
    {
        proceedButton.click();
    }

    public void getMessage()
    {
        String message = registerText.getText();
        System.out.println(message);
    }
}
