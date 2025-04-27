package stepDefinitions;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.Utility;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class BaseClass  {
    protected static WebDriver driver;


    public void openBrowser(String br) throws InterruptedException, IOException {

        String baseURL = Utility.readPropertyFiles("URL");
        switch(br)
        {
            case "chrome":
                WebDriverManager.chromedriver().clearDriverCache().setup();
                ChromeOptions optionc = new ChromeOptions();
                optionc.addArguments("disable-popup-blocking");
                driver = new ChromeDriver();
                break;

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions optionf = new FirefoxOptions();
                optionf.addArguments("disable-popup-blocking");
                driver = new FirefoxDriver(optionf);
                break;

            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;

            case "headless":
                WebDriverManager.chromiumdriver().setup();
                ChromeOptions option = new ChromeOptions();
                option.addArguments("headless");
                driver = new ChromeDriver(option);
                break;
        }

        driver.get(baseURL);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        try {

            WebDriverWait wait = new WebDriverWait(driver, 20);
            WebElement cookieBanner = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("onetrust-banner-sdk")));
            WebElement closeButton = cookieBanner.findElement(By.xpath("//button[@class='onetrust-close-btn-handler onetrust-close-btn-ui banner-close-button ot-close-icon']"));
            closeButton.click();

        } catch (Exception e) {
            System.out.println("An error occurred while handling the cookie banner: " + e.getMessage());
        }

    }

}
