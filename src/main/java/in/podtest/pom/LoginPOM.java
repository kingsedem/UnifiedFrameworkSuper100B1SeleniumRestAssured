package in.podtest.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPOM {
    private WebDriver wd;

    private By emailTB = By.xpath("//input[@name='email']");
    private By passwordTB = By.xpath("//input[@name='password']");
    private By submitButton = By.xpath("//button[@type='submit']");

    public LoginPOM get(){
        String resourcePath = "/account/login";
        String baseURL = "https://demo.evershop.io";
        String newURL = resourcePath.concat(baseURL);
        wd.get(newURL);
        return this;
    }

    public LoginPOM(WebDriver wd){
        this.wd = wd;
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
