package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class InvalidCred {

    WebDriver driver;
    public InvalidCred(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='email']")
    WebElement emailAddress;

    @FindBy(xpath = "//input[@id='password']")
    WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement singinButton;

    @FindBy(xpath = "//div[@class='error pageLevel']")
    WebElement errorText;

    public void enterCred(String email, String pass)
    {
        emailAddress.sendKeys(email);
        password.sendKeys(pass);
    }

    public void clickonSignIn()
    {
        singinButton.click();
    }
    public void getErrorMessage()
    {
        String actual = errorText.getText();

        System.out.println(actual);
    }
}
