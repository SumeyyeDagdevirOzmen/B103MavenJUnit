package team23;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C06 extends TestBase {
    @Test
    public void test01() {
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        WebElement homePage = driver.findElement(By.xpath("//*[text()=' Home']"));
        Assert.assertTrue(homePage.isDisplayed());

        //4. Click on 'Contact Us' button
        driver.findElement(By.xpath("//a[text()=' Contact us']")).click();

        //5. Verify 'GET IN TOUCH' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//h2[text()='Get In Touch']")).isDisplayed());

        //6. Enter name, email, subject and message
        Faker faker = new Faker();
        String name = faker.name().firstName();
        String email = faker.internet().emailAddress();
        String subject = faker.name().title();
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys(name, Keys.TAB,email,Keys.TAB,
                subject,Keys.TAB,"Hello World!");
        //7. Upload file

        WebElement chooeseFileButton = driver.findElement(By.xpath("//input[@name='upload_file']"));
        String dosyaYolu = System.getProperty("user.home")+"\\Desktop\\logo.jpeg";
        chooeseFileButton.sendKeys(dosyaYolu);
        waitFor(5);

        //8. Click 'Submit' button
        driver.findElement(By.xpath("//input[@name='submit']")).click();

        //9. Click OK button
        driver.switchTo().alert().accept();

        //10. Verify success message 'Success! Your details have been submitted successfully.' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='status alert alert-success']")).isDisplayed());
        //11. Click 'Home' button and verify that landed to home page successfully
        driver.findElement(By.xpath("//i[@class='fa fa-angle-double-left']")).click();

       // Assert.assertTrue(homePage.isDisplayed());
    }

}
