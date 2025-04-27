package org.example;

import com.sun.mail.imap.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class Rough {

    public static void main(String[] args) throws InterruptedException, IOException {

        WebDriverManager.chromedriver().setup();

        ChromeOptions optionc = new ChromeOptions();
        optionc.addArguments("disable-popup-blocking");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.sita.aero/");
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, 20);
        try {


            WebElement cookieBanner = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("onetrust-banner-sdk")));
            WebElement closeButton = cookieBanner.findElement(By.xpath("//button[@class='onetrust-close-btn-handler onetrust-close-btn-ui banner-close-button ot-close-icon']"));
            closeButton.click();

        } catch (Exception e) {
            System.out.println("An error occurred while handling the cookie banner: " + e.getMessage());
        }


    WebElement header = driver.findElement(By.xpath("//section[@id='portfolio']//h2"));
    verifyText(header);

    }
    public static void verifyText(WebElement element) throws IOException {
        String actualText = element.getText().trim();
        String expectedText = "Portfolio spotlight";
        if(actualText.equals(expectedText))
        {
            System.out.println("=======PASS=======");
        }
    }

}
