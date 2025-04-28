package utility;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class Utility {
    public static void handlingWindows(WebDriver driver) {
        String parentWin = driver.getWindowHandle();

        Set<String> windows = driver.getWindowHandles();

        Iterator<String> itr = windows.iterator();
        while (itr.hasNext()) {
            String childWin = itr.next();
            if (!parentWin.equals(childWin)) {
                driver.switchTo().window(childWin);
            }
        }
    }

    public static void verifyIfPresent(WebElement element) {
        boolean isPresent = false;
        try {
            if (element.isDisplayed()) {
                isPresent = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Assert.assertTrue(isPresent, "Element is not present");
        }
    }

    public static void sendReport() {
        // Sender Email Credentials (Use App Password if Gmail)
        final String senderEmail = "bhogale.aksh11021995@outlook.com";  // Change this
        final String senderPassword = ""; // Use App Password if required

        // Receiver Email
        String recipientEmail = "bhogale.akshay112@gmail.com"; // Change this

        // SMTP Server Configuration (for Gmail, Outlook, etc.)
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.office365.com"); // Change for Outlook/Yahoo
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        // Create session with authentication
        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderEmail, senderPassword);
            }
        });

        try {
            // Create Email Message
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(senderEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));
            message.setSubject("Automated Test Report");

            // Email body
            MimeBodyPart textPart = new MimeBodyPart();
            textPart.setText("Hello,\n\nPlease find the attached test report.\n\nBest Regards,\nTest Automation Team");

            // Attach Report
            MimeBodyPart attachmentPart = new MimeBodyPart();
            String reportPath = "D:\\Cucumber-SITA\\SITA\\test-output\\SparkReport\\Report\\Spark.html"; // Change to your report file
            attachmentPart.attachFile(new File(reportPath));

            // Combine email body and attachment
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(textPart);
            multipart.addBodyPart(attachmentPart);
            message.setContent(multipart);

            // Send Email
            Transport.send(message);
            System.out.println("Email sent successfully with the report!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String generateEmail() {
        String uuid = UUID.randomUUID().toString();

        String email = "user_" + uuid.substring(0, 8) + "@sita.com";

        return email;
    }

    public static String generateName() {
        return RandomStringUtils.randomAlphabetic(10);
    }

    public static String lastName() {
        return RandomStringUtils.randomAlphabetic(6);
    }

    public static void captureScreenshot(WebDriver driver, String scenarioName) throws IOException {

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        Date now = new Date();
        String date = sdf.format(now);
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File target = new File("D:\\Cucumber-SITA\\SITA\\screenshot\\" + scenarioName + " " + date + ".png");
        FileUtils.copyFile(src, target);

    }

    public static String readPropertyFiles(String key) throws IOException {
        String path = "D:\\Cucumber-SITA\\SITA\\src\\test\\resources\\Config.properties";
        String path_1 = "D:\\Cucumber-SITA\\SITA\\src\\test\\resources\\constants.properties";

        String[] files = {path, path_1};
        Properties p = new Properties();
        // File file = new File(path);

        for (String file : files) {
            FileInputStream input = new FileInputStream(file);
            p.load(input);
            input.close();

        }
        String values = p.getProperty(key);
        return values;
    }

    public static boolean mouseHover(WebDriver driver, WebElement element) {
        boolean flag = false;
        try {
            Actions a = new Actions(driver);
            a.moveToElement(element).click().build().perform();
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    public static void verifyText(WebElement element) throws IOException {
        String actualText = element.getText().trim();
        String expectedText = readPropertyFiles("expectedportText");
        Assert.assertEquals(expectedText, actualText);

    }

    public static List<String> getListFromJsonArray(String filePath) {
        List<String> dataList = new ArrayList<>();

        try (FileReader reader = new FileReader(filePath)) {
            JsonElement fileElement = JsonParser.parseReader(reader);

            if (fileElement.isJsonArray()) {
                JsonArray ja = fileElement.getAsJsonArray();

                for (JsonElement ele : ja) {
                    dataList.add(ele.getAsString());
                }
            } else {
                throw new IllegalArgumentException("Provided JSON is not an array");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to read JSON array from file: " + filePath, e);
        }

        return dataList;

    }

}

