package in.podtest.pom;

import in.podtest.pom.components.HeaderPOM;
import org.openqa.selenium.WebDriver;

public class BasePOM {

    protected WebDriver wd;
    protected HeaderPOM headerPOM;


    public BasePOM(WebDriver wd){
       this.wd = wd;
       //wd.manage().window().maximize();
       headerPOM = new HeaderPOM(wd);
    }

    public void get(String url){
        wd.get(url);
        headerPOM = new HeaderPOM(wd);
    }

    public HeaderPOM getHeader(){
        return headerPOM;
    }
}
