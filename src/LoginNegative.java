import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginNegative {
    private static final String LOGIN = "marinaA";
    private static final String PASSWORD = "marina1!";

    public static void main(String[] args) throws InterruptedException {

        //--- Enter to the system ----
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://mishpahug.co.il/");
        Thread.sleep(3000);
        driver.findElement(By.id("closedIntro")).click();
        Thread.sleep(5000);

        //--- Login to the system ----
        WebElement loginIcon = driver.findElement(By.id("idsignin"));
        loginIcon.click();
        Thread.sleep(2000);
        System.out.println("We are on the Login window: " + driver
                .findElement(By.id("clickreg")).getText().contains("registration"));

        //---- Enter incorrect login/psw ---
        driver.findElement(By.id("logininput")).sendKeys(LOGIN);
        driver.findElement(By.id("passwordinput")).sendKeys("123");
        WebElement signInButton = driver.findElement(By.id("signinrequest"));
        signInButton.click();
        Thread.sleep(3000);

        //--- Error message 'wrong authorization is displayed' ----
        System.out.println("The system displays an error message: " + driver
                .findElement(By.id("wrongloginorpassword")).getText().contains("Wrong Authorization"));

        //--- Close login window ---
        driver.findElement(By.id("closedsignin")).click();
        Thread.sleep(3000);
        // ---- Usr is on the HomePage for the unauthorized user
        System.out.println("User is on the HomePage unauthorized: " + driver
                .findElement(By.id("idsignin")).getText().equals("Login"));

        driver.quit();
    }
}
