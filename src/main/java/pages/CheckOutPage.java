package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutPage  {

    private WebDriver driver;
    private By yourOrder = By.xpath("//h3[@id='order_review_heading']");
    private By checkoutProductName = By.xpath("//td[contains(@class,'product-name')]");
    private By cartSubTotal = By.xpath("//tr[contains(@class,'cart-subtotal')]");
    private By cartOrderTotal = By.xpath("//tr[contains(@class,'order-total')]");


    public CheckOutPage(WebDriver driver){
        this.driver = driver;
    }

    public String getSummaryTitle(){
        return driver.findElement(yourOrder).getText();
    }

    public String getSummaryProductName(){
        return driver.findElement(checkoutProductName).getText();
    }
    public String getSummarySubTotal(){
        return driver.findElement(cartSubTotal).getText();
    }
    public String getSummaryOrderTotal(){
        return driver.findElement(cartOrderTotal).getText();
    }


}
