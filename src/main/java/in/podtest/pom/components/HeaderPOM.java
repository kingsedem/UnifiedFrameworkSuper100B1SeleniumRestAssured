package in.podtest.pom.components;

import in.podtest.pom.AboutUsPOM;
import in.podtest.pom.AccountPOM;
import in.podtest.pom.CartPOM;
import in.podtest.pom.HomePOM;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderPOM {

    private WebDriver wd;

    public  HeaderPOM(WebDriver wd){
        this.wd = wd;
    }

    private By shopDropdown = By.xpath("//li[@class ='relative group']/a[contains(text(), 'Shop')]");

    private By aboutUsLink  = By.xpath("//li[@class ='relative group']/a[contains(text(), 'About us')]");

    private By appIcon = By.xpath("//a[@class='logo-icon']");

    private By searchIcon = By.xpath("//a[@class='search-icon']");

    private By cartIcon = By.xpath("//a[@class='mini-cart-icon']");

    private By accountIcon = By.xpath("//a[contains(@href,'/account/login')]')]");




    //methods
    public AboutUsPOM clickAboutUsLink(){
        wd.findElement(aboutUsLink).click();
        return new AboutUsPOM(wd);
    }

    public HomePOM clickAppIcon(){
        wd.findElement(appIcon).click();
        return new HomePOM(wd);
    }

    public CartPOM clickCartIcon(){
        wd.findElement(cartIcon).click();
        return new CartPOM(wd);
    }

    public AccountPOM clickAccountPOM(){
        wd.findElement(accountIcon).click();
        return new AccountPOM(wd);
    }
}





