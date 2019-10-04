package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {
    public static final String LOGIN = "marinaA";
    public static final String PASSWORD = "marina1!";
    WebDriver driver;

    @BeforeMethod
    public void initWebDriver() throws InterruptedException {
        driver = new ChromeDriver();
        //Thread.sleep(2000);


        driver.get("https://mishpahug.co.il/");

        waitUntilElementIsClickable(By.id("closedIntro"), 30);
        driver.findElement(By.id("closedIntro")).click();
        //Thread.sleep(5000);
       waitUntilElementIsClickable(By.id("idsingin"), 30);

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


    public void waitUntillElementIsVisible(By locator, int time) {
        try {
            new WebDriverWait(driver, time).until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public void waitUntilElementIsClickable(By locator, int time) {
        try {
            new WebDriverWait(driver, time)
                    .until(ExpectedConditions.elementToBeClickable(locator)); // waiting for CLICABLE ELEMENT---
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
