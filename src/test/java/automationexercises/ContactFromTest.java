package automationexercises;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ContactFromTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        // Set up the Chrome driver
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
        driver = new ChromeDriver();
    }

    @Test
    public void testContactForm() throws InterruptedException {
        // Navigate to the website
        driver.get("http://automationexercise.com");

        // Verify that the home page is visible
        WebElement homeLink = driver.findElement(By.id("home"));
        assert homeLink.isDisplayed();

        // Click on the Contact Us button
        WebElement contactUsButton = driver.findElement(By.id("contact"));
        contactUsButton.click();

        // Verify that the GET IN TOUCH heading is visible
        WebElement getInTouchHeading = driver.findElement(By.cssSelector("h3.text-center"));
        assert getInTouchHeading.isDisplayed();
        assert getInTouchHeading.getText().equals("GET IN TOUCH");

        // Enter the contact form details
        WebElement nameField = driver.findElement(By.name("name"));
        nameField.sendKeys("John Smith");
        WebElement emailField = driver.findElement(By.name("email"));
        emailField.sendKeys("john.smith@example.com");
        WebElement subjectField = driver.findElement(By.name("subject"));
        subjectField.sendKeys("Inquiry");
        WebElement messageField = driver.findElement(By.name("message"));
        messageField.sendKeys("I have a question about your product.");

        // Upload a file
        WebElement fileInput = driver.findElement(By.name("file"));
        fileInput.sendKeys("/path/to/file.txt");

        // Click the Submit button
        WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));
        submitButton.click();

        // Click the OK button on the alert
        driver.switchTo().alert().accept();

        // Verify that the success message is displayed
        WebElement successMessage = driver.findElement(By.cssSelector("div.alert.alert-success"));
        assert successMessage.isDisplayed();
        assert successMessage.getText().equals("Success! Your details have been submitted successfully.");

        // Click the Home button and verify that the home page is displayed
        WebElement homeButton = driver.findElement(By.id("home"));
        homeButton.click();
        assert homeLink.isDisplayed();
    }

    @After
    public void tearDown() {
        // Close the browser
        driver.quit();
    }




}
