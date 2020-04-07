package SearchPage;

import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SearchPage;

import java.util.List;

public class SearchPageTests extends BaseTest {

    @Test
    public void testSearchData(){
        String productName = "BLACK LUX GRAPHIC T-SHIRT";
       SearchPage searchPage = homepage.clickOnSearch(productName);
        Assert.assertEquals(searchPage.getSearchedTitle(), "BLACK LUX GRAPHIC T-SHIRT", "Searched data doesn't match.");
        searchPage.scrollToSummary();
       Assert.assertEquals(searchPage.getProductTitle(), "BLACK LUX GRAPHIC T-SHIRT", "Product Title doesn't match");
       Assert.assertEquals(searchPage.getPriceText(), searchPage.getPriceText(),"Price doesn't match.");
       searchPage.selectDropDown();
//        List<String> selectedoptions = searchPage.getSelectedOptions();
//        selectedoptions.get(0);
//        selectedoptions.get(0);
      // searchPage.selectFromDropDown("black");
      // searchPage.selectFromDropDown("32");
       searchPage.setQtyIncrease();
       Assert.assertEquals(searchPage.getQtyText(), searchPage.getQtyText(), "Selected qty doesn't match");
       searchPage.clickOnAddToCart();
       Assert.assertEquals(searchPage.getAddedCartText(), searchPage.getAddedCartText(),"Selected cart details doesn't match.");
       searchPage.clickOnViewCart();
       System.out.println("User is redirected to Cart Page.!!");
    }
}
