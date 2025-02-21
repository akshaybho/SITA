package pageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utility.Utility;


public class RegisterSignPage {
    WebDriver driver;
    public RegisterSignPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//div[@class='intro']/h2")
    WebElement signInPageText;
    @FindBy(xpath = "//p[@class='my-6 text-lg text-gray-500']")
    WebElement registerPageText;

    public void clickdigiHub()
    {
        WebElement header = driver.findElement(By.xpath("//header"));
        WebElement digiHubButton = header.findElement(By.xpath("//a[text()='DIGIHUB']"));
        digiHubButton.click();

    }
    public void getSignInText()
    {
        WebElement loginHeader = driver.findElement(By.xpath("//div[@class='loginRegisterBlock col-lg-6 col-12']//div[@class='loginForm']"));
        WebElement signInText = loginHeader.findElement(By.xpath("//div[@class='loginForm']//h4"));
        String actual = signInText.getText();
        String expected = "Sign in";
        Assert.assertEquals(actual, expected);
        System.out.println("----SIGNINTEXT-PASS----");
    }
    public void clickOnSignIn()
    {
        WebElement loginHeader = driver.findElement(By.xpath("//div[@class='loginRegisterBlock col-lg-6 col-12']//div[@class='loginForm']"));
        WebElement signInButton = loginHeader.findElement(By.xpath("//a[@title='Sign in']"));
        signInButton.click();
    }
    public void validateSignInPage()
    {
        Utility.handlingWindows(driver);
        String actual = signInPageText.getText();
        String expected = "Sign in with your email address";
        Assert.assertEquals(actual, expected);
        System.out.println("User able to LOGIN");
    }

    public void getRegistrationText()
    {
        WebElement registerHeader = driver.findElement(By.xpath("//div[@class='loginRegisterBlock col-lg-6 col-12']//div[@class='registerForm']"));
        WebElement signInText = registerHeader.findElement(By.xpath("//div[@class='registerForm']//h4"));
        String actual = signInText.getText();
        String expected = "Register for the Customer Portal now and enjoy the benefits";
        Assert.assertEquals(actual, expected);
        System.out.println("----REGISTER-PASS----");
    }

    public void clickOnRegisterButton()
    {
        WebElement registerHeader = driver.findElement(By.xpath("//div[@class='loginRegisterBlock col-lg-6 col-12']//div[@class='registerForm']"));
        WebElement registerButton = registerHeader.findElement(By.xpath("//a[@title='Create your account']"));
        registerButton.click();
    }

    public void validateRegistrationPage()
    {
        Utility.handlingWindows(driver);
        String actual = registerPageText.getText();
        String expected = "Welcome to SITA DigiHub. Please enter the below details to proceed with your registration.";
        Assert.assertEquals(actual, expected);
        System.out.println("User able to REGISTER");
    }


}
