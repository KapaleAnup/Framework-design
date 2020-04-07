package CartPage;

import SearchPage.SearchPageTests;
import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;

public class CartPageTests extends BaseTest {

    public SearchPageTests pageTests;
    @Test
    public void testCartDetails(){
        pageTests = new SearchPageTests();
        pageTests.testSearchData();
       CartPage cartPage = homepage.clickOnViewCart();
       Assert.assertEquals(cartPage.getQty(), cartPage.getQty(), "Qty doesn't match.");
       Assert.assertEquals(cartPage.getCartAmount(),cartPage.getCartAmount(), "Amount doesn't match.");
       Assert.assertEquals(cartPage.getProductName(), cartPage.getProductName(), "Product name doesn't match.");
       Assert.assertEquals(cartPage.getPrice(), cartPage.getPrice(), "Product price doesn't match.");
       Assert.assertEquals(cartPage.getQty(), cartPage.getQty(), "Qty doesn't match.");
       Assert.assertEquals(cartPage.getTotalAmount(), cartPage.getTotalAmount(), "Total amount doesn't match.");
    }
}
