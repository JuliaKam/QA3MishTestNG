package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebHomePageTests extends TestBase{

    @Test
    public void webHomePageTest()  {

        WebElement eventList = driver.findElement(By.id("idtitletypesearchevents"));
        System.out.println("List events element exists: " + eventList.getText().equals("List events"));
        WebElement loginIcon = driver.findElement(By.id("idsignin"));
        Assert.assertEquals(loginIcon.getText(), "Login");
    }

    @Test
    public void webSingleFilterHoliday() throws InterruptedException {
        WebElement holidayFilter = driver.findElement(By.name("selectholidays"));
        Select selector = new Select(holidayFilter);
        selector.selectByValue("Purim");
        //selector.selectByVisibleText("Shabbat (4)");
        Thread.sleep(10000);
    }
}