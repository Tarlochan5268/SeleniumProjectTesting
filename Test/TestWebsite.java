import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
public class TestWebsite
{
    final String URL = "https://www.seleniumeasy.com/test/basic-first-form-demo.html";
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
    public void testSingleInputField() throws InterruptedException  {
        WebElement textBox = driver.findElement(By.id("user-message"));
        textBox.sendKeys("Das");
        WebElement button = driver.findElement(By.cssSelector("form#get-input button"));
        button.click();
        WebElement outputSpan = driver.findElement(By.id("display"));
        String outputMessage = outputSpan.getText();		//actual output
        assertEquals("Das", outputMessage);
    }

    @Test
    public void testTwoFieldsInputs() throws InterruptedException
    {
        WebElement textBoxa = driver.findElement(By.id("sum1"));
        textBoxa.sendKeys("10"); //VALUE A FIELD
        WebElement textBoxb = driver.findElement(By.id("sum2"));
        textBoxb.sendKeys("20"); //VALUE B FIELD

        WebElement button = driver.findElement(By.cssSelector("form#gettotal button"));
        button.click();
        WebElement outputSpan = driver.findElement(By.id("displayvalue"));
        String outputMessage = outputSpan.getText();		//actual output
        assertEquals("30", outputMessage);
    }
}
