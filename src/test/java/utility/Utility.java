package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import java.util.Iterator;
import java.util.Set;

public class Utility {
    public static void handlingWindows(WebDriver driver)
    {
        String parentWin = driver.getWindowHandle();

        Set<String> windows = driver.getWindowHandles();

        Iterator <String> itr = windows.iterator();
        while(itr.hasNext())
        {
            String childWin = itr.next();
            if(!parentWin.equals(childWin))
            {
                driver.switchTo().window(childWin);
            }
        }
    }
    public static void verifyIfPresent(WebElement element)
    {
        boolean isPresent = false;
        try
        {
            if(element.isDisplayed())
            {
                isPresent = true;
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            Assert.assertTrue(isPresent, "Element is not present");
        }
    }
}
