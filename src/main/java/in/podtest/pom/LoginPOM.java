package in.podtest.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPOM  extends BasePOM{

    private By emailTB = By.xpath("//input[@name='email']");
    private By passwordTB = By.xpath("//input[@name='password']");
    private By submitButton = By.xpath("//button[@type='submit']");


    public LoginPOM get(){
        String resourcePath = "/account/login";
        String baseURL = "https://demo.evershop.io";
        String newURL = baseURL.concat(resourcePath);
        wd.get(newURL);
        return this;
    }

    public LoginPOM(WebDriver wd){
        super(wd);
    }


    public LoginPOM fillUserName(String emailId){
        wd.findElement(emailTB).sendKeys(emailId);
        return this;
    }

    public LoginPOM fillPassword(String password){
        wd.findElement(passwordTB).sendKeys(password);
        return this;
    }

    public HomePOM clickSubmitButton(){
        wd.findElement(submitButton).click();
        return new HomePOM(wd);
    }


    public void fillCredentials(String emailId, String password){
        wd.findElement(emailTB).sendKeys(emailId);
        wd.findElement(passwordTB).sendKeys(password);
    }

}
