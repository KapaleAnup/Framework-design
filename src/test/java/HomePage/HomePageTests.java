package HomePage;

import basetest.BaseTest;
import org.testng.annotations.Test;
import pages.Page;

public class HomePageTests extends BaseTest {

    @Test
    public void testHeaderText(){

        homepage.dismissMessage();
        String headertext = homepage.getHeaderText();
        System.out.println(headertext);

    }


    @Test
    public void testScrollPage(){
        homepage.scrollToFooter();
    }

}
