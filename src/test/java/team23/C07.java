package team23;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C07 extends TestBase {
    //1. Launch browser
    //2. Navigate to url 'http://automationexercise.com'
    //3. Verify that home page is visible successfully
    //4. Click on 'Test Cases' button
    //5. Verify user is navigated to test cases page successfully
    @Test
    public void test01() {
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        WebElement homePage = driver.findElement(By.xpath("//*[text()=' Home']"));
        Assert.assertTrue(homePage.isDisplayed());


        //4. Click on 'Test Cases' button
        driver.navigate().refresh();
        waitFor(3);
        driver.findElement(By.xpath("//a[text()=' Test Cases']")).click();

      //

        waitFor(3);
        //5. Verify user is navigated to test cases page successfully

        Assert.assertTrue(driver.findElement(By.xpath("//u[text()='Test Case 1: Register User']")).isDisplayed());

    }
}
