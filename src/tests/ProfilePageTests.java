package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ProfilePageTests {
    @Test
    public void lastNameOfFamilyChanging() throws InterruptedException {
        // --- Enter to the system ---
        WebDriver driver = new ChromeDriver();
        driver.manage().window().fullscreen();
        driver.get("https://mishpahug.co.il/");
        driver.findElement(By.id("closedIntro")).click();
        Thread.sleep(6000);
        //--- Login to the system ---
        WebElement loginIcon = driver.findElement(By.id("idsignin"));
        loginIcon.click();
        Thread.sleep(3000);

        WebElement loginField = driver.findElement(By.id("logininput"));
        WebElement passwordField = driver.findElement(By.id("passwordinput"));
        loginField.click();
        loginField.sendKeys("my140013");
        passwordField.click();
        passwordField.sendKeys("kapl0103");

        driver.findElement(By.id("signinrequest")).click();

        Thread.sleep(5000);

        //--- Go to the Profile Page
        driver.findElement(By.id("profile")).click();
        Thread.sleep(3000);

        // --- Open in edit mode ----
        driver.findElement(By.id("idbtneditprofile")).click();
        Thread.sleep(7000);

        //--- Enter new last name ---
        WebElement lastNameField = driver
                .findElement(By.xpath("//span[@id='fieldobjfamilyName']//input"));
        lastNameField.click();
        lastNameField.clear();
        lastNameField.sendKeys("Petrov");

        Thread.sleep(5000);

        //--- Save profile ---
        driver.findElement(By.id("idbtnsaveprofile")).click();
        Thread.sleep(5000);

        // --- Go to the family page-----
        driver.findElement(By.id("family")).click();
        Thread.sleep(5000);

        System.out.println("Last name of the family verification: " + driver
                .findElement(By.id("titleprofile")).getText().contains("Petrov"));

        // ---- Return to the profile
        driver.findElement(By.id("profile")).click();
        Thread.sleep(3000);

        // --- Open in edit mode ----
        driver.findElement(By.id("idbtneditprofile")).click();
        Thread.sleep(7000);

        //--- Enter new last name ---
        lastNameField = driver
                .findElement(By.xpath("//span[@id='fieldobjfamilyName']//input"));
        lastNameField.click();
        lastNameField.clear();
        lastNameField.sendKeys("Shuster");

        Thread.sleep(5000);

        //--- Save profile ---
        driver.findElement(By.id("idbtnsaveprofile")).click();
        Thread.sleep(5000);

        System.out.println("Last name was changed: " + driver.findElement(By.linkText("Shuster")).isDisplayed());



        driver.quit();

    }
    @Test
    public void profileAndFamilyPageComparing() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://mishpahug.co.il/");
        driver.findElement(By.id("closedIntro")).click();
        WebElement loginIcon = driver.findElement(By.id("idsignin"));
        loginIcon.click();
        driver.findElement(By.id("logininput")).sendKeys("my140013");
        driver.findElement(By.id("passwordinput")).sendKeys("kapl0103");
        driver.findElement(By.id("signinrequest")).click();

        Thread.sleep(3000);
        driver.findElement(By.xpath("//i[@id='profile']")).click();
        Thread.sleep(3000);
        String profileConfession = driver.findElement(By.xpath("//span[@id='fieldobjconfession']")).getText();
        System.out.println("Profile confession: " + profileConfession);

        String profileLanguage = driver.findElement(By.cssSelector("#fieldobjlanguages")).getText();
        System.out.println("Profile Language: " + profileLanguage);

        String profileFoodPreference = driver.findElement(By.xpath("//*[@id='fieldobjfoodPreferences']")).getText();
        System.out.println("Profile Food Preference: " + profileFoodPreference);

        String profileEmail = driver.findElement(By.cssSelector("#fieldobjelMail")).getText();
        System.out.println("Email in the profile: " + profileEmail);

        String profileFamilyName =driver.findElement(By.xpath("//span[@id='fieldobjfamilyName']")).getText();
        System.out.println("Family Name in the profile: " + profileFamilyName);

        String profileFamilyDescription = driver.findElement(By.xpath
                ("//div[@class= 'itemprofilearea']/span[@id='fieldobjfamilyDescription']")).getText();
        System.out.println("Profile family description: " + profileFamilyDescription);

        driver.findElement(By.xpath("//i[@id='family']")).click();

        //----------------------Comparing--------------------------
        Thread.sleep(3000);
        String familyConfession = driver.findElement(
                By.cssSelector(".itemprofilefit #fieldobjconfession")).getText();
        System.out.println("Family confession: " + familyConfession);
        System.out.println("Confession of the profile is equivalent to confession of the family: "
                + profileConfession.equals(familyConfession));

        String familyLanguage = driver.findElement(
                By.xpath("//div[@class='row myrow']//span[@id='fieldobjlanguages']")).getText();
        System.out.println("Family language: " + familyLanguage);
        System.out.println("Language of the profile is equivalent to language of the family: "
                + profileLanguage.equals(familyLanguage));

        String familyFoodPreference = driver.findElement(
                By.cssSelector(".itemprofilefit #fieldobjfoodPreferences")).getText();
        System.out.println("Family food preference: " + familyFoodPreference);
        System.out.println("Food preference of the profile is equivalent to food preference of the family: "
                + profileFoodPreference.equals(familyFoodPreference));

        String familyEmail = driver.findElement(
                By.xpath("//div[@class='itemprofilefit']//span[@id='fieldobjelMail']")).getText();
        System.out.println("Family Email: " + familyEmail);
        System.out.println("Email of the profile is equivalent to email of the family: "
                + profileEmail.equals(familyEmail));

        String familyLastName = driver.findElement(By.cssSelector(".formscroll #titleprofile")).getText();
        System.out.println("Family Last Name: " + familyLastName);
        System.out.println("The family name of the profile is equivalent to the last name of the family:"
                + familyLastName.contains(profileFamilyName));

        String familyFamilyDescription = driver.findElement(
                By.xpath("//span[@id='fieldobjfamilyDescription']")).getText();
        System.out.println("Family Family Description: " + familyFamilyDescription);
        System.out.println("Family description of the profile is equivalent to family description of the family: "
                + profileFamilyDescription.equals(familyFamilyDescription));
        driver.quit();


    }
}
