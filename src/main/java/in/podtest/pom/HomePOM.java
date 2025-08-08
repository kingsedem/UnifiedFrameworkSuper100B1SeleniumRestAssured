package in.podtest.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePOM {

    private By shopKidsButton = By.xpath("//a/span[text()='Shop kids']");
    private  WebDriver wd;

    public HomePOM get(){
        String resourcePath = "/";
        String baseURL = "https://demo.evershop.io";
        String newURL = resourcePath.concat(baseURL);
        wd.get(newURL);
        return this;
    }

    public HomePOM(WebDriver wd){
          this.wd= wd;
    }

    public HomePOM waitFor(){
        //wait strategy
        WebDriverWait wait = new WebDriverWait(wd, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(shopKidsButton));
        return this;
    }


    public void clickProductName(){
        //
    }


}
