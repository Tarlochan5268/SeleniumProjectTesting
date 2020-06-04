import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
public class TestWebsite3
{
    final String URL = "http://the-internet.herokuapp.com/hovers";
    final String DRIVER_PATH = "/Users/admin/Downloads/chromedriver";

    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        // Setup Selenium + Chrome
        System.setProperty("webdriver.chrome.driver",DRIVER_PATH);
        driver = new ChromeDriver();
        // Tell Selenium what page to test
        driver.get(URL);
    }

    @After
    public void tearDown() throws Exception {
        // At end of test case, wait for a few seconds, then close the browser
        Thread.sleep(1000);				// OPTION 1
        TimeUnit.SECONDS.sleep(1);		// OPTION 2
        driver.close(); // this closes window after few seconds of testing
    }


    @Test
    public void testHover() throws Exception {
        //find image
        List<WebElement> images = driver.findElements(By.cssSelector("div.figure img"));
        assertEquals(3, images.size());

        //get the first photo on the page
        WebElement image = images.get(0);
        Thread.sleep(3000);
        //hover on the image
        Actions builder = new Actions(driver);
        builder.moveToElement(image).build().perform();

        //click on the View Profile link
        List<WebElement> profileLinks = driver.findElements(By.cssSelector("div.figcaption a"));
        assertEquals(3, profileLinks.size());
        WebElement firstImageLink = profileLinks.get(0);
        Thread.sleep(1000);

        firstImageLink.click();

        // Wait for system to go to next page
        // Get the url of the new page
        String urlPage2 = driver.getCurrentUrl();
        System.out.println(urlPage2);

        // Check that url of new page
        // 	= "http://the-internet.herokuapp.com/users/1"
        assertEquals("http://the-internet.herokuapp.com/users/1", urlPage2);
    }
}
