package team23;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C05 extends TestBase {
    @Test
    public void test01() {
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        WebElement homePage = driver.findElement(By.xpath("//*[text()=' Home']"));
        Assert.assertTrue(homePage.isDisplayed());

        //4. Click on 'Signup / Login' button
        WebElement signUpLoginButton = driver.findElement(By.xpath("//a[@href='/login']"));
        signUpLoginButton.click();

        //5. Verify 'New User Signup!' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//h2[text()='New User Signup!']")).isDisplayed());

        //6. Enter name and already registered email address
        //7. Click 'Signup' button
        waitFor(3);
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys("sumeyye", Keys.TAB,"a@yahoo.com",Keys.TAB,Keys.ENTER);

        //8. Verify error 'Email Address already exist!' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//p[text()='Email Address already exist!']")).isDisplayed());
    }
}
