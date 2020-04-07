package AccountPageTest;

import basetest.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.AccountPage;

public class AccountPageTests extends BaseTest {

    @Test
    public void testAccountTitle(){
       AccountPage accountPage = homepage.clickMyAccount();
       accountPage.getAccountTitle();
    }

}
