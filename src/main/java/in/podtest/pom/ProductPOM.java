package in.podtest.pom;

import in.podtest.util.waitManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPOM extends BasePOM{

    private By addToCartButton = By.xpath("//button/span[text()= 'ADD TO CART']");
    private String itemSizeCB = "//ul[contains(@class,'variant-option-list')]/li/a[text() = '%%%%']";
    private String itemColorCB = "//ul[contains(@class,'variant-option-list')]/li/a[text() = '$$$$']";
    private By qtyTB = By.xpath("//input[@name='qty']");
    private By viewCartButton = By.xpath("//div/a[@class='add-cart-popup-button' and contains(text(), 'VIEW CART')]");



    public By getItemSizeCBLocator(String sizeName){
     String updatedItemSizeCB =  itemSizeCB.replace("%%%%", sizeName);
        return By.xpath(updatedItemSizeCB);
    }

    public By getItemColorCBLocator(String colorName){
        String updatedItemColorCB = itemColorCB.replace("$$$$", colorName);
        return By.xpath(updatedItemColorCB);
    }
    public ProductPOM(WebDriver wd){
        super(wd);
    }

    //wait strategy
    public ProductPOM waitFor(){
        waitManager.waitForElementToBeLocated(wd, addToCartButton);
        return this;
    }

    public ProductPOM selectItemSize(String itemSize){

        By ele = getItemSizeCBLocator(itemSize);
        wd.findElement(ele).click();
        waitManager.waitForElementToHaveSpecificValue(wd, wd.findElement(ele).findElement(By.xpath("//parent::li")), "class", "selected");
        //wait for the selected value to be shown on the class attribute of the tag
        return this;
    }

    public ProductPOM selectItemColor(String itemColor){

        By ele = getItemColorCBLocator(itemColor);
        wd.findElement(ele).click();
        waitManager.waitForElementToHaveSpecificValue(wd, wd.findElement(ele).findElement(By.xpath("//parent::li")), "class", "selected");
        //wait for the selected value to be shown on the class attribute of the tag
        return this;
    }

    public ProductPOM fillItemQty(String qty){
        wd.findElement(qtyTB).clear();
        wd.findElement(qtyTB).sendKeys(qty);

        return this;
    }

    public ProductPOM clickAddToCartBtn(){
        wd.findElement(addToCartButton).click();

        waitManager.waitForElementToBeLocated(wd, viewCartButton);
        return this;

    }

    public  CartPOM clickViewCartButton(){
        wd.findElement(viewCartButton).click();
        return new CartPOM(wd);
    }

}
