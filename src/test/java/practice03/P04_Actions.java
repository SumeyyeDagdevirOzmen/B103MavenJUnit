package practice03;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class P04_Actions extends TestBase {
    /*
        -http://spicejet.com/ sayfasına gidelim
         -Sayfanın altındaki about us bölümü altındaki fleet linkine tıklayalım
        -Sayfa başlığının Fleet içerdiğini test edelim
     */

    @Test
    public void name() {
        // -http://spicejet.com/ sayfasına gidelim
        driver.get("http://spicejet.com/");
        //-Sayfanın altındaki about us bölümü altındaki fleet linkine tıklayalım
        WebElement aboutUs = driver.findElement(By.xpath("//*[.='About Us']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(aboutUs).perform();
        driver.findElement(By.xpath("//*[.='Fleet']")).click();

        //-Sayfa başlığının Fleet içerdiğini test edelim
        String baslik = driver.findElement(By.xpath("(//*[.='Fleet'])[3]")).getText();
        Assert.assertTrue(baslik.contains("Fleet"));
    }
}

/*
 @Test
    public void test(){
        //-http://spicejet.com/ sayfasına gidelim
        driver.get("http://spicejet.com/");
        WebElement aboutUs = driver.findElement(By.xpath("//*[text()='About Us']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(aboutUs).perform();
        //-Sayfanın altındaki about us bölümü altındaki fleet linkine tıklayalım
        actions.click(driver.findElement(By.xpath("//div[text()='Fleet']"))).perform();
        //-Sayfa başlığının Fleet içerdiğini test edeli
        switchToWindow(1);
        Assert.assertTrue(driver.getTitle().contains("Fleet"));
    }
 */