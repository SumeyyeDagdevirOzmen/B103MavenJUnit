package team23;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C04 extends TestBase {
    @Test
    public void test01() {
        //Test Case 4: Logout User
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        WebElement homePage = driver.findElement(By.xpath("//*[text()=' Home']"));
        Assert.assertTrue(homePage.isDisplayed());

        //4. Click on 'Signup / Login' button
        WebElement signUpLoginButton = driver.findElement(By.xpath("//a[@href='/login']"));
        signUpLoginButton.click();

        //5. Verify 'Login to your account' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//h2[text()='Login to your account']")).isDisplayed());

        //6. Enter correct email address and password
            //      Faker faker = new Faker();
    //        String name = faker.name().firstName();
    //        String email = faker.internet().emailAddress();
    //        String password = faker.internet().password();
    //        driver.findElement(By.xpath("//input[@signup-name='data-qa']")).sendKeys(name,Keys.TAB,email,Keys.TAB,Keys.ENTER);
        waitFor(3);
        driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys("a@yahoo.com", Keys.TAB, "12345678",
                Keys.TAB, Keys.ENTER);

        //7. Click 'login' button

        //8. Verify that 'Logged in as username' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//a[text()=' Logged in as '] ")).isDisplayed());

        //9. Click 'Logout' button

        WebElement logOutButton = driver.findElement(By.xpath("//a[text()=' Logout']"));
        logOutButton.click();

        //10. Verify that user is navigated to login page
        Assert.assertTrue(driver.findElement(By.xpath("//h2[text()='Login to your account']")).isDisplayed());
    }
}
