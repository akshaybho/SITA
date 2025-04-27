package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoPage {

    WebDriver driver;
    public LogoPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".logoHolder ")
    WebElement logo;

    public void verifyLogo()
    {
        if(logo.isDisplayed())
        {
            System.out.println("Logo is present on the page");
        }
        else
        {
            System.out.println("Logo is not present on the page");
        }
    }
}
