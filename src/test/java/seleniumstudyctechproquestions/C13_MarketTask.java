package seleniumstudyctechproquestions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
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
        String[] productTitle = driver.findElement(By.xpath("//*[@id='title']")).getText().split(" ");
        WebElement productStok = driver.findElement(By.xpath("//*[.='    Stokta var.   ']"));
        WebElement productPrice = driver.findElement(By.xpath("//span[@class='a-price-whole']"));

        //Isim - Renk - Stok - Boyut - Fiyat
        System.out.println("URUN ISMI : " + productTitle[1] + " " + productTitle[2] + "\n"+
                "RENK : " + productTitle[6] + " " + productTitle[7] +"\n"+
                "STOK DURUMU : " + productStok.getText() +"\n"+
                "BOYUT : "  + productTitle[3] + " " + productTitle[4] +"\n"+
                "URUN FIYAT : " + productPrice.getText());


    }
}
