package seleniumstudyctechproquestions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.Set;

public class C13_WindowHandle3 extends TestBase {

    @Test
    public void test01() {
        //https://demoqa.com/ url'ine gidin.
        driver.get("https://demoqa.com/");

        //Alerts, Frame & Windows Butonuna click yap
        driver.findElement(By.xpath("(//div[@class='avatar mx-auto white'])[3]")).click();

        //""Please select an item from left to start practice."" yazısının görünür olduğunu doğrula
        WebElement text = driver.findElement(By.xpath("//*[text()='Please select an item from left to start practice.']"));
        Assert.assertTrue(text.isDisplayed());

        //Sol'da açılan Menu den ""Browser Windows"" butonuna click yap
        driver.findElement(By.xpath("//span[text()='Browser Windows']")).click();

        //New Tab butonunun görünür olduğunu doğrula
        String newButon = driver.findElement(By.xpath("//button[@id='tabButton']")).getText();
        Assert.assertEquals("New Tab",newButon);

        //New Tab butonuna click yap
        driver.findElement(By.xpath("//button[@id='tabButton']")).click();

        //Açılan yeni Tab da ""This is a sample page"" yazısının görünür olduğunu doğrula
        String windowHandle = driver.getWindowHandle();
        Set<String> alleHandles = driver.getWindowHandles();
        alleHandles.stream().filter(t->!t.contains(windowHandle)).limit(1).forEach(t->driver.switchTo().window(t));
        String actualText =driver.findElement(By.xpath("//h1[text()='This is a sample page']")).getText();
        Assert.assertEquals("This is a sample page",actualText);

        //İlk Tab'a geri dön
        driver.switchTo().window(windowHandle);

        ////New Tab butonunun görünür olduğunu doğrula
        String newButon2 = driver.findElement(By.xpath("//button[@id='tabButton']")).getText();
        Assert.assertEquals("New Tab",newButon2);
    }


}
