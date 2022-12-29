package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class GoogleTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        // Set up the Chrome driver
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // Navigate to Google's homepage
        driver.get("https://www.google.com");

        // Accept the cookies warning
        WebElement cookiesButton = driver.findElement(By.xpath("(//*[@class='QS5gu sy4vM'])[2]"));
        cookiesButton.click();
    }

    @Test
    public void testPageTitle() {
        // Test that the page title contains "Google"
        String expectedTitle = "Google";
        String actualTitle = driver.getTitle();
        Assert.assertTrue( actualTitle.contains(expectedTitle));
    }

    @Test
    public void testSearchResults() {
        // Search for "Nutella"
        WebElement searchField = driver.findElement(By.xpath("//*[@name='q']"));
        searchField.sendKeys("Nutella");
        searchField.submit();

        // Print the number of search results found
        WebElement resultsStats = driver.findElement(By.xpath("//*[@id='result-stats']"));
        String resultsText = resultsStats.getText();
        System.out.println(resultsText);

        // Test that the number of search results is more than 10 million
        int expectedResults = 10000000;
        int actualResults = extractNumberFromResultsText(resultsText);
        Assert.assertTrue(actualResults > expectedResults);
    }

    @After
    public void tearDown() {
        // Close the browser
       // driver.quit();
    }

    private int extractNumberFromResultsText(String resultsText) {
        // Extract the number of search results from the results text
        // Example results text: "About 12,100,000 results (0.47 seconds)"
        String[] parts = resultsText.split(" ");
        String numResults = parts[1].replace(",", "");
        return Integer.parseInt(numResults);
    }

}
