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
        String a = driver.findElement(By.xpath("//span[@id='size_name_2']")).getText();
        System.out.println(a);
        String[] productTitle = driver.findElement(By.xpath("//*[@id='title']")).getText().split(" ");
        WebElement productStok = driver.findElement(By.xpath("//*[.='    Stokta var.   ']"));
        WebElement productPrice = driver.findElement(By.xpath("//span[@class='a-price-whole']"));

        //Isim - Renk - Stok - Boyut - Fiyat
        System.out.println("URUN ISMI : " + productTitle[1] + " " + productTitle[2] + "\n"+
                "RENK : " + productTitle[6] + " " + productTitle[7] +"\n"+
                "STOK DURUMU : " + productStok.getText() +"\n"+
                "BOYUT : "  + productTitle[3] + " " + productTitle[4] +"\n"+
                "URUN FIYAT : " + productPrice.getText());



//        String name = driver.findElement(By.xpath("//li[@class='a-spacing-mini']")).getText();
//        System.out.println(name);
//
//        List<WebElement> items = driver.findElements(By.xpath("//li[@class='sc-product-variation']//span[@class='a-size-small']"));
//        System.out.println("Color: "+items.get(1).getText());
//        String price = driver.findElement(By.xpath("//div[@class='sc-item-price-block']")).getText();
//        System.out.println("Fiyat: "+price);
//        System.out.println("Stock: "+items.get(0).getText());

    }
}
