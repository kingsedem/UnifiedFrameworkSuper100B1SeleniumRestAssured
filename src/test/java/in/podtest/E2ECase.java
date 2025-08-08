package in.podtest;

import in.podtest.pom.HomePOM;
import in.podtest.pom.LoginPOM;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class E2ECase {

    WebDriver wd;

    //Test data preparation
    String emailId = "kingsley123@yahoo.com";
    String password = "Test123";

    @BeforeTest
    public void preStep(){
        wd = new ChromeDriver();
//        wd.get("https://demo.evershop.io/account/login");
    }

    @Test
    public void testLoginFlow(){
        LoginPOM login = new LoginPOM(wd);

        login.get()
                .fillUserName(emailId)
                .fillPassword(password)
                .clickSubmitButton()   //Page chaining
                .waitFor();


        String actualURL = wd.getCurrentUrl();
        String expectedURL = "https://demo.evershop.io/";

        Assert.assertEquals(actualURL, expectedURL);
    }

    @AfterTest
    public void postSteps(){
        wd.close();

    }

    //Test case manual

    //Test data : Hard coding
    //prepare Excel sheet
    //input - email and password
    //expected data - username

    //Pre-step: Hooks :before method
    //browser should be open
    //user is on login page


    //Test-step : @Test
    //user fill the username with kingsley123@yahoo.com
    // user fill password with Test123
    //click on submit

    //Assert class
    //Assertion Pass or fail
    //Application should move to login page
    // Validate username
    // Validate displayed username, compare
    //Actual data: expected username displayed on the screen

    //matches: pass
    //Not match: fail

    //post step
    //logout of application
    //close browser

    @Test
    public void tc2(){
        WebDriver wd = new ChromeDriver();
        wd.get("https://demo.evershop.io/");
    }
}
