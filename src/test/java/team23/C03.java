package team23;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C03 extends TestBase {
    @Test
    public void test(){
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
         driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        String homePage = driver.getCurrentUrl();
        String expectedUrl="https://automationexercise.com/";
        Assert.assertEquals(expectedUrl,homePage);

        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//a[text()=' Signup / Login']")).click();

        //5. Verify 'Login to your account' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//h2")).isDisplayed());

        //6. Enter incorrect email address and password
        driver.findElement(By.xpath("//*[@type='email']")).sendKeys("jsdk@gmail.com", Keys.TAB,"79898564");
        //7. Click 'login' button
        driver.findElement(By.xpath("(//button[@type='submit'])[1]")).click();
        //8. Verify error 'Your email or password is incorrect!' is visible
        WebElement actualMessage = driver.findElement(By.xpath("//p[.='Your email or password is incorrect!']"));
        Assert.assertTrue(actualMessage.isDisplayed());
    }
}
