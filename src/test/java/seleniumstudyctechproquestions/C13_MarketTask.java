package seleniumstudyctechproquestions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Keys;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class C13_MarketTask extends TestBase {
    @Test
    public void test01() {
        //Go to https://www.amazon.com.tr/
        driver.get("https://www.amazon.com.tr/");
        driver.findElement(By.id("sp-cc-accept")).click();

        //Search iPhone13 512
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iPhone13 512", Keys.ENTER);

        //Check that the results are listed
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']")).isDisplayed());

        //Click iPhone13 at the top of the list
        driver.findElement(By.xpath("(//span[@class='a-size-base-plus a-color-base a-text-normal'])[1]")).click();

        //Log the following values for each size .Size information .Price .Color .Stock status

        String renk =  driver.findElement(By.xpath("//span[@id='inline-twister-expanded-dimension-text-color_name']")).getText();
        String isim=driver.findElement(By.xpath("//*[@id='productTitle']")).getText();
        String stok = driver.findElement(By.xpath("//span[@class='a-size-medium a-color-success']")).getText();
        String size=driver.findElement(By.xpath("//div[@id='inline-twister-expander-header-size_name']")).getText();

        System.out.println(renk + " " + isim + " "+stok+" "+ size);

        //Isim - Renk - Stok - Boyut - Fiyat
    }
}
