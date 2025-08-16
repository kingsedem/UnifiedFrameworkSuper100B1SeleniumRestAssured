package in.podtest.pom;

import in.podtest.util.waitManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePOM extends BasePOM {

    private By shopKidsButton = By.xpath("//a/span[text()='Shop kids']");
    private String productLink = "//div[@class='listing-tem']/div[contains(@class, 'product-name')]/a/span[text()='####']";
    //Nike react infinity run flyknit

    public By getProductLinkLocator(String productName){
       String updatedProductName =  productLink.replace("####", productName);   //#### is the static product name
        return By.xpath(updatedProductName);
    }

    public HomePOM get(){
        String resourcePath = "/";
        String baseURL = "https://demo.evershop.io";
        String newURL = baseURL.concat(resourcePath);
        get(newURL);
        return this;
    }

    public HomePOM (WebDriver wd){
          super(wd);
          this.wd = wd;
    }

    //wait strategy
    public HomePOM waitFor(){
        waitManager.waitForElementToBeLocated(wd, shopKidsButton);
        return this;
    }


    public ProductPOM clickProductName(String productName){
       // wd.switchTo().alert().accept();
        wd.findElement(getProductLinkLocator(productName)).click();
        return new ProductPOM(wd);
    }


}
