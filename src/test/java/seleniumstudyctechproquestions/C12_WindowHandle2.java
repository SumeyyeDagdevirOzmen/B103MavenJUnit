package seleniumstudyctechproquestions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class C12_WindowHandle2 extends TestBase {
    @Test
    public void test01(){
        //https://demoqa.com/ url'ine gidin.
        driver.get("https://demoqa.com/");

        //Alerts, Frame & Windows Butonuna click yap
        waitFor(3);
        driver.findElement(By.xpath("(//div[@class='card-up'])[3]")).click();

        //""Please select an item from left to start practice."" yazısının görünür olduğunu doğrula
        Assert.assertTrue(driver.findElement(By.xpath("//*[.='Please select an item from left to start practice.']")).isDisplayed());

        //Sol'da açılan Menu den ""Browser Windows"" butonuna click yap
        driver.findElement(By.xpath("//span[.='Browser Windows']")).click();

        //New Tab butonunun görünür olduğunu doğrula
        Assert.assertTrue(driver.findElement(By.xpath("//button[.='New Tab']")).isDisplayed());
        String window1 = driver.getWindowHandle();//Ilk pencere

        //New Tab butonuna click yap
        driver.findElement(By.xpath("//button[.='New Tab']")).click();

        //Açılan yeni Tab da ""This is a sample page"" yazısının görünür olduğunu doğrula
        waitFor(3);
        switchToWindow(1);
        String actualText = driver.findElement(By.xpath("//h1[@id='sampleHeading']")).getText();
        String expectedText = "This is a sample page";
        Assert.assertEquals(expectedText, actualText);
        waitFor(3);

        //İlk Tab'a geri dön
        driver.switchTo().window(window1);

        //New Tab butonunun görünür olduğunu doğrula

        Assert.assertTrue(driver.findElement(By.xpath("//button[.='New Tab']")).isDisplayed());

    }
}
