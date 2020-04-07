package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage {

    private WebDriver driver ;

    private By accountTitle = By.xpath("//h1[@class='page-title']");

    public AccountPage(WebDriver driver){
        this.driver = driver;
    }

    public String getAccountTitle(){

       return driver.findElement(accountTitle).getText();
    }
}
