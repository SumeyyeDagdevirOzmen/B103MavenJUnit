package team23;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C08 extends TestBase {
    //1. Launch browser
    //2. Navigate to url 'http://automationexercise.com'
    //3. Verify that home page is visible successfully
    //4. Click on 'Products' button
    //5. Verify user is navigated to ALL PRODUCTS page successfully
    //6. The products list is visible
    //7. Click on 'View Product' of first product
    //8. User is landed to product detail page
    //9. Verify that detail detail is visible: product name, category, price, availability, condition, brand
    @Test
    public void test01() {
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        WebElement homePage = driver.findElement(By.xpath("//*[text()=' Home']"));
        Assert.assertTrue(homePage.isDisplayed());

        //4. Click on 'Products' button
        driver.findElement(By.xpath("//a[text()=' Products']")).click();

        //5. Verify user is navigated to ALL PRODUCTS page successfully
        Assert.assertTrue(driver.findElement(By.xpath("//h2[text()='All Products']")).isDisplayed());

        //6. The products list is visible
        Assert.assertTrue(driver.findElement(By.xpath("//a[text()='Polo']")).isDisplayed());

        //7. Click on 'View Product' of first product
        driver.findElement(By.xpath("(//a[text()='View Product'])[1]")).click();

        //8. User is landed to product detail page
        System.out.println(driver.findElement(By.xpath("//div[@class='product-information']")).getText());

        //9. Verify that detail detail is visible: product name, category, price, availability, condition, brand
    }
}
