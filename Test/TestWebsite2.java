import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class TestWebsite2 {
    final String URL = "https://www.seleniumeasy.com/test/basic-checkbox-demo.html";
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
    public void testSingleCheckBoxFieldChecked() throws InterruptedException {
        WebElement checkBox = driver.findElement(By.id("isAgeSelected"));
        checkBox.click();

        // test that checkbox actually got checked
        boolean isChecked = checkBox.isSelected();
        assertTrue(isChecked);

        //Success - Check box is checked
        WebElement outputSpan = driver.findElement(By.id("txtAge"));
        String outputMessage = outputSpan.getText();		//actual output
        assertEquals("Success - Check box is checked", outputMessage);
    }

    @Test
    public void testAllCheckBoxFieldChecked() throws InterruptedException  {

    }
}
