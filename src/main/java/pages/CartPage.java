package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    private WebDriver driver;
    private By cartQty = By.xpath("//span[contains(@class,'cart-count')]");
    private By cartAmount = By.xpath("//span[contains(@class,'cart-name-and-total')]//span[contains(@class,'woocommerce-Price-amount amount')]");
    private By productName = By.xpath("//td[contains(@class,'product-name')]");
    private By price = By.xpath("//td[contains(@class,'product-price')]//span[contains(@class,'woocommerce-Price-amount amount')]");
    private By productQty = By.xpath("//input[@id='noo-quantity-8885']");
    private By totalAmount= By.xpath("//td[contains(@class,'product-subtotal')]//span[contains(@class,'woocommerce-Price-amount amount')]");
    private By checkout = By.xpath("//a[@class='checkout-button button alt wc-forward']");

    public CartPage(WebDriver driver){
        this.driver = driver;
    }

    public String getQty(){
        return driver.findElement(cartQty).getText();
    }

    public String getCartAmount(){
        return driver.findElement(cartAmount).getText();
    }

    public String getProductName(){
        return driver.findElement(productName).getText();
    }
    public String getPrice(){
        return driver.findElement(price).getText();
    }
    public String getProductQty(){
        return driver.findElement(productQty).getText();
    }
    public String getTotalAmount(){
        return driver.findElement(totalAmount).getText();
    }

    public CheckOutPage clickOnCheckout(){
        driver.findElement(checkout).click();
        return new CheckOutPage(driver);
    }
}
