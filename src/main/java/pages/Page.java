package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Page {

    private WebDriver driver;

    private By headerLinks = By.xpath("//div[@class='noo-topbar']");
    private By footerText = By.id("noo_infomation-1");
    private By accountlink = By.linkText("My Account");
    private By dismissTooltipMessage = By.xpath("//p[@class='woocommerce-store-notice demo_store']");
    private By searchicon = By.xpath("//a[contains(@class,'noo-search')]");
    private By searchField	= By.name("s");
    private By vieCartField = By.xpath("//span[@class='cart-name-and-total']");
    private By checkOut = By.linkText("Checkout");

    public Page(WebDriver driver){
        this.driver = driver;

    }

    public AccountPage clickMyAccount(){
        dismissMessage();
//      WebDriverWait wait = new WebDriverWait(driver, 5);
//      wait.until(ExpectedConditions.visibilityOf(driver.findElement(accountlink)));
        try {
            driver.findElement(accountlink).click();
        }catch (Exception e){
            e.printStackTrace();
        }
        return new AccountPage(driver);
    }

    public SearchPage clickOnSearch(String text){
        driver.findElement(searchicon).click();
        WebElement search = driver.findElement(searchField);
       search.sendKeys(text);
       search.sendKeys(Keys.ENTER);
       return new SearchPage(driver);
    }

    public CartPage clickOnViewCart(){
        driver.findElement(vieCartField).click();
        return new CartPage(driver);
    }

    public CheckOutPage clickOnCheckout(){
        dismissMessage();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(checkOut).click();
        return new CheckOutPage(driver);
    }
    public String getHeaderText(){
        return driver.findElement(headerLinks).getText();
    }

    public void dismissMessage(){
        driver.findElement(dismissTooltipMessage).click();
    }

    public void scrollToFooter(){
        WebElement footer = driver.findElement(footerText);
        String data = footer.getText();
        String script = "arguments[0].scrollIntoView();";
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor)driver;
        javascriptExecutor.executeScript(script, footer);
        System.out.println(data);

    }




}
