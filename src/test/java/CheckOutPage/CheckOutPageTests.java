package CheckOutPage;

import CartPage.CartPageTests;
import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CheckOutPage;

public class CheckOutPageTests extends BaseTest {

    CartPageTests cartPageTests ;
    @Test
    public void testCheckoutSummaryDetails(){

        cartPageTests = new CartPageTests();
        cartPageTests.testCartDetails();
       CheckOutPage checkOutPage = homepage.clickOnCheckout();
       Assert.assertEquals(checkOutPage.getSummaryTitle(), checkOutPage.getSummaryTitle(), "Summary title doesn't match.");
       Assert.assertEquals(checkOutPage.getSummaryProductName(), checkOutPage.getSummaryProductName(), "Summary product name doesn't match.");
       Assert.assertEquals(checkOutPage.getSummarySubTotal(), checkOutPage.getSummarySubTotal(), "Summary subtotal doesn't match.");
       Assert.assertEquals(checkOutPage.getSummaryOrderTotal(), checkOutPage.getSummaryOrderTotal(), "Summary Total doesn't match.");
    }
}
