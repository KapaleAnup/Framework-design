package basetest;

import Utils.EventReporter;
import Utils.Links;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.Page;

public class BaseTest {

    private static EventFiringWebDriver driver;
    protected static Page homepage;
    @BeforeClass
    public void launchApplication(){
        initializeBrowsers();
        driver.register(new EventReporter());
        driver.manage().window().maximize();
        goHome();
    }

    @BeforeMethod
    public void goHome(){
        driver.get(Links.HOME);
        homepage = new Page(driver);

    }
    public void initializeBrowsers(){
        WebDriverManager.chromedriver().setup();
        driver = new EventFiringWebDriver(new ChromeDriver());

    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
