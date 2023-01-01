package automationexercises;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C06_ContactUsForm {
    /*
        1. Launch browser
        2. Navigate to url 'http://automationexercise.com'
        3. Verify that home page is visible successfully
        4. Click on 'Contact Us' button
        5. Verify 'GET IN TOUCH' is visible
        6. Enter name, email, subject and message
        7. Upload file
        8. Click 'Submit' button
        9. Click OK button
        10. Verify success message 'Success! Your details have been submitted successfully.' is visible
        11. Click 'Home' button and verify that landed to home page successfully
     */
    static WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @Test
    public void test01() throws InterruptedException {
        // 2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //3. Verify that home page is visible successfully
        WebElement homePage = driver.findElement(By.xpath("//*[@alt='Website for automation practice']"));
        Assert.assertTrue(homePage.isDisplayed());

        //4. Click on 'Contact Us' button
        driver.findElement(By.xpath(" //*[text()=' Contact us']")).click();

        WebElement iletisim = driver.findElement(By.xpath("//*[text()='Get In Touch']"));
        Assert.assertTrue(iletisim.isDisplayed());

        //6. Enter name, email, subject and message
        driver.findElement(By.xpath("(//*[@class='form-control'])[1]")).sendKeys("Sumeyye", Keys.TAB
        ,"sumeyyedagdevir@gmail.com",Keys.TAB,"sikayet",Keys.TAB,"Team23Dosya");

        //7. Upload file
//        WebElement upload_file = driver.findElement(By.xpath("//*[@name='upload_file']"));
//        upload_file.sendKeys("C:\\Users\\mamap\\OneDrive\\Desktop\\Team23");

       WebElement bb = driver.findElement(By.xpath("//*[@type='submit']"));
       bb.sendKeys(Keys.ENTER);
       //9. Click OK button
        driver.switchTo().alert().accept();

        //10. Verify success message 'Success! Your details have been submitted successfully.' is visible
        String actualResult = driver.findElement(By.xpath("//*[@class='status alert alert-success']")).getText();
        String expectedResult ="Success! Your details have been submitted successfully.";
        Assert.assertEquals(expectedResult,actualResult);

        //11. Click 'Home' button and verify that landed to home page successfully
        driver.findElement(By.xpath("//*[@class ='fa fa-home']")).click();


    }
}
