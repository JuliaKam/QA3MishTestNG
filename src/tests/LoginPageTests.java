package tests;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTests extends TestBase {




   /* public void initTests() throws InterruptedException {


        //--- Login to the system ----
        WebElement loginIcon = driver.findElement(By.id("idsignin"));
        loginIcon.click();
        //Thread.sleep(2000);
        waitUntilElementIsVisible(By.id("signinrequest"),20);
        try{
            new WebDriverWait(driver, time).until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch(Exception e) {
            e.printStackTrace();
        }
    }*/

    @BeforeMethod
    public void initTests() throws InterruptedException {


        //--- Login to the system ----
        WebElement loginIcon = driver.findElement(By.id("idsignin"));
        loginIcon.click();

        // Thread.sleep(2000);
        // loginScreenVerification();
        waitUntilElementIsClickable(By.id("signinrequest"), 20);
    }

   // catch(Exception e){
     //   e.printStackTrace();

     //   System.out.println("We are on the Login window: " + driver
       //         .findElement(By.id("clickreg")).getText().contains("registration"));




    @Test
    public void loginNegativeTest() throws InterruptedException {

        //---- Enter incorrect login/psw ---
        driver.findElement(By.id("logininput")).sendKeys(LOGIN);
        driver.findElement(By.id("passwordinput")).sendKeys("123");
        WebElement signInButton = driver.findElement(By.id("signinrequest"));
        signInButton.click();
        //Thread.sleep(3000);
         waitUntillElementIsVisible(By.id("wrongloginorpassword"),10); //AVOIDING THREAD METHOD!! using element
        //"wrongloginorpassword"-------------------

        //--- Error message 'wrong authorization is displayed' ----
        System.out.println("The system displays an error message: " + driver
                .findElement(By.id("wrongloginorpassword")).getText().contains("Wrong Authorization"));

        //--- Close login window ---
        driver.findElement(By.id("closedsignin")).click();
        //Thread.sleep(3000);  //AVOIDING THREAD METHOD!! USING 2 ELEMENTS - login button and list events text
        waitUntilElementIsClickable(By.id("idsingin"), 20);
        waitUntillElementIsVisible(By.xpath("//span[@id='idtitletypesearchevents']"),20);



        // ---- Usr is on the HomePage for the unauthorized user
        System.out.println("User is on the HomePage unauthorized: " + driver
                .findElement(By.id("idsignin")).getText().equals("Login"));


    }

    @Test
    public void loginExitByCancelTest() throws InterruptedException {
        //--- Close login window ---
        driver.findElement(By.id("closedsignin")).click();
       // Thread.sleep(3000);
        waitUntilElementIsClickable(By.id("idsingin"), 20);
        waitUntillElementIsVisible(By.xpath("//span[@id='idtitletypesearchevents']"),20);

        // ---- Usr is on the HomePage for the unauthorized user
        System.out.println("User is on the HomePage unauthorized: " + driver
                .findElement(By.id("idsignin")).getText().equals("Login"));


    }
    @Test
    public void loginPositiveTest() throws InterruptedException {
        //----- Find login and password fields and fill them
        WebElement loginField = driver.findElement(By.id("logininput"));
        WebElement passwordField = driver.findElement(By.id("passwordinput"));
        loginField.click();
        loginField.sendKeys("my140013");
        passwordField.click();
        passwordField.sendKeys("kapl0103");

        //---- Find sign in button and press on it ----
        driver.findElement(By.id("signinrequest")).click();

        //---- Go to the HomePage Auth -------
        //Thread.sleep(7000);

        waitUntilElementIsClickable(By.id("profile"), 30);
        WebElement profileIcon = driver.findElement(By.id("profile"));

        // ------ Check that we on the HomePage for authorized user---
        System.out.println("We logged in: "
                + profileIcon.getAttribute("title").contains("my140013"));


    }

}
