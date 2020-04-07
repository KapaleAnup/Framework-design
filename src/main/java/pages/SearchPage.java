package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class SearchPage {

    private WebDriver driver;
    private By pageTitle = By.xpath("//h1[contains(@class,'page-title')]");
    private By summaryText = By.xpath("//div[@class='summary entry-summary']");
    private By productTitle = By.xpath("//h1[contains(@class,'product_title entry-title')]");
    private By priceText = By.className("price");
    String dropdown = ".//select[@id='pa_'] and  text() = '%s'";
    private By colorDropDown = By.xpath("//select[@id='pa_color']");
    private By sizeDropDown = By.xpath("//select[@id='pa_size']");
    private By qtyIncrease = By.xpath("//i[@class='icon_plus']");
    private By qtyCheck = By.xpath("//input[@type='text']");
    private By addToCart = By.xpath("//button[@class='single_add_to_cart_button button alt']");
    private By addedCartText = By.xpath("//div[@class='woocommerce-message']");
    private By viewCart = By.xpath("//a[@class='button wc-forward']");

    public SearchPage(WebDriver driver){
        this.driver = driver;
    }

   public String getSearchedTitle(){
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
       return driver.findElement(pageTitle).getText();
    }

    public void scrollToSummary(){
        WebElement summary = driver.findElement(summaryText);
        String script = "arguments[0].scrollIntoView();";
        ((JavascriptExecutor)driver).executeScript(script,summary);
    }
    private void scrollToAddCart(){
        WebElement addCart = driver.findElement(addToCart);
        String script = "arguments[0].scrollIntoView();";
        ((JavascriptExecutor)driver).executeScript(script,addCart);
    }

    public String getProductTitle(){
        return  driver.findElement(productTitle).getText();
    }

    public String getPriceText(){
        return driver.findElement(priceText).getText();
    }
 /*   public void selectFromDropDown(String option){

        findDropDownElement(dropdown).selectByVisibleText(option);
    }

    public List<String> getSelectedOptions(){
        List<WebElement>  selectedElements = findDropDownElement(dropdown).getAllSelectedOptions();
        return selectedElements.stream().map(e->e.getText()).collect(Collectors.toList());

    }*/
   /* private WebElement findMenuItem(String menuItem){
        String xpath = String.format(menuItem_Format, menuItem);
        return webDriver.findElement(By.xpath(xpath));
    }*/

    private void findDropDownElement(WebElement element, int index){

        Select dropDownValues = new Select(element);
        dropDownValues.selectByIndex(index);
    }

    public void selectDropDown(){
        WebElement color = driver.findElement(colorDropDown);
        findDropDownElement(color, 1);
        WebElement size = driver.findElement(sizeDropDown);
        findDropDownElement(size, 1);
    }
    public void selectSizeDropDown(){
        WebElement size = driver.findElement(sizeDropDown);
        Select sizedropdown = new Select(size);
        sizedropdown.selectByIndex(1);
    }

    public void setQtyIncrease(){
        driver.findElement(qtyIncrease).click();
    }

    public String getQtyText(){
        return driver.findElement(qtyCheck).getText();
    }

    public void clickOnAddToCart(){

            driver.findElement(addToCart).click();

    }

    public String getAddedCartText(){
        return driver.findElement(addedCartText).getText();
    }

    public CartPage clickOnViewCart(){
        try {
            driver.findElement(viewCart).click();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return new CartPage(driver);
    }




}
