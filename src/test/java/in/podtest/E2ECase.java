package in.podtest;

import in.podtest.pom.BasePOM;
import in.podtest.pom.LoginPOM;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class E2ECase {

    WebDriver wd;

    //Test data preparation
    String emailId = "kingsley123@yahoo.com";
    String password = "Test123";
    String productName = "Nike court vision low";

    @BeforeTest
    public void preStep(){
        wd = new ChromeDriver();
    }

    @Test
    public void testLoginFlow(){
        LoginPOM login = new LoginPOM(wd);

        login.get()
                .fillUserName(emailId).fillPassword(password).clickSubmitButton()   //Page chaining
                .waitFor().clickProductName(productName)
                .waitFor().selectItemSize("X").selectItemColor("Black").fillItemQty("1").clickAddToCartBtn()
                .clickViewCartButton();
    }


    @Test
    public void testLoginFlow2(){
        LoginPOM login = new LoginPOM(wd);

        login.get()
                .fillUserName(emailId).fillPassword(password).clickSubmitButton()   //Page chaining
                .waitFor().getHeader().clickCartIcon();

        String actualURL = wd.getCurrentUrl();
        String expectedURL = "https://demo.evershop.io/";

        //Assert.assertEquals(actualURL, expectedURL);
    }

    @AfterTest
    public void postSteps(){
       // wd.close();
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
