package team23;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02 extends TestBase {
    @Test
    public void test() throws InterruptedException {
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        WebElement homeLogo = driver.findElement(By.xpath("//a[@style='color: orange;']"));
        Assert.assertTrue(homeLogo.isDisplayed());
        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//a[@href='/login']")).click();

        //5. Verify 'Login to your account' is visible
       WebElement accountVisible = driver.findElement(By.xpath("//h2[.='Login to your account']"));
       Assert.assertTrue(accountVisible.isDisplayed());

        //6. Enter correct email address and password
        driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys("g@yahoo.com",
                Keys.TAB,"12345678",Keys.TAB,Keys.ENTER);

        //7. Click 'login' button
        //8. Verify that 'Logged in as username' is visible
        WebElement usernameVisible=driver.findElement(By.xpath("//a[text()=' Logged in as ']"));
        System.out.println(usernameVisible.getText());
        Assert.assertTrue(usernameVisible.isDisplayed());

        //9. Click 'Delete Account' button
        driver.findElement(By.xpath("//a[@href='/delete_account']")).click();
//        WebElement iframe = driver.findElement(By.xpath("//iframe[@id='aswift_1']"));
//        driver.switchTo().frame(iframe);


        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='aswift_5']")));
        Thread.sleep(4000);
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='ad_iframe']")));
        WebElement reklam1 = driver.findElement(By.xpath("//*[@id='dismiss-button']"));
        reklam1.click();

         driver.findElement(By.xpath("//*[@class='ns-o4642-e-18']")).click();


        //10. Verify that 'ACCOUNT DELETED!' is visible
        WebElement delete = driver.findElement(By.xpath("//b[.='Account Deleted!']"));
        Assert.assertTrue(delete.isDisplayed());


    }

}
