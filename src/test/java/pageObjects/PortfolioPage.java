package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class PortfolioPage {

    WebDriver driver;
    @FindBy(xpath="//section[@id='portfolio']/div/h2")
    WebElement portfolioText;

    @FindBy(xpath="//div[@class='listingItem']/h3")
    List<WebElement> listItem;

    public PortfolioPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String verifyPortfolio()
    {
        return portfolioText.getText().trim();
    }

    public List<String> getPortfolioActualText()
    {
        List <String> text = new ArrayList<>();

        for(WebElement ele : listItem)
        {
            text.add(ele.getText().trim());
        }
        return text;
    }
}
