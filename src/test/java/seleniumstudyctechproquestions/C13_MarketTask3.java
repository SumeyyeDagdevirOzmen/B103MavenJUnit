package seleniumstudyctechproquestions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class C13_MarketTask3 extends TestBase {

    //Go to https://www.amazon.com.tr/
    //    //Search iPhone13 512
    //    //Check that the results are listed
    //    //Click iPhone13 at the top of the list
    //    //Log the following values for each size .Size information .Price .Color .Stock status
    //    //Isim - Renk - Stok - Boyut - Fiyat
    @Test
    public void test1() {
        //Go to https://www.amazon.com.tr/
        driver.get("https://www.amazon.com.tr/");
        driver.findElement(By.id("sp-cc-accept")).click();//sayfada cerez cikiyor ,bu kod cerezi kabul etmek icin
        waitFor(2);

        //Search iPhone13 512
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iPhone13512", Keys.ENTER);
        //Check that the results are listed
        WebElement actuelResult=driver.findElement(By.xpath("//*[text()='\"iPhone13512\"']"));
        Assert.assertTrue(actuelResult.getText().contains("iPhone13512"));
        waitFor(3);

        //Click iPhone13 at the top of the list
        driver.findElement(By.xpath("//*[@alt='Apple iPhone 13 (512 GB) - (PRODUCT)RED']")).click();

        //Log the following values for each size .Size information .Price .Color .Stock status
        waitFor(3);
        sepeteEkle("3","2");
        driver.findElement(By.id("attach-close_sideSheet-link")).click();
        sepeteEkle("2","1");
        driver.findElement(By.id("attach-close_sideSheet-link")).click();
        sepeteEkle("2","0");
        waitFor(1);
        driver.findElement(By.id("attach-view-cart-button-form")).click();//alisveris sepetine tikla
        List<WebElement> w=driver.findElements(By.xpath("//span[@class='a-list-item']"));//konsolda gormek istedigimiz tum bilgileri bir list icine attik
        waitFor(1);
        w.add(driver.findElement(By.xpath("//span[text()='Fiyat']")));
        w.add(driver.findElement(By.xpath("//*[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap sc-product-price a-text-bold']")));
        waitFor(1);
        w.stream().skip(4).filter(t->!t.getText().startsWith("B")).forEach(t-> System.out.println(t.getText()));
        //Isim - Renk - Stok - Boyut - Fiyat =============ekran ciktisi
        /*
        Apple iPhone 13 (512 GB) - Pembe
         Stokta var
         Ölçü: 512 GB
         Renk: Pembe
         Fiyat
         32.799,10 TL
        Apple iPhone 13 (256 GB) - Mavi
         Stokta sadece 6 adet kaldı.
         Ölçü: 256 GB
         Renk: Mavi
         Fiyat
         29.569,40 TL
        Apple iPhone 13 (128 GB) - Mavi
         Stokta var
         Ölçü: 128 GB
         Renk: Mavi
         Fiyat
         27.571,40 TL
         */
    }
    public void sepeteEkle(String a,String b){
        driver.findElement(By.xpath("//input[@aria-labelledby='color_name_"+a+"-announce']")).click();//beyaz:5, yesil:4,pembe:3, mavi:2,kirmizi:1 siyah:0,
        waitFor(2);
        WebElement w1=driver.findElement(By.xpath("//*[@aria-labelledby='size_name_"+b+"-announce']"));//buradaki sayi kismina 256:1,128:0 veya 512 icin 2 secenekleri yazilabilir
        w1.click();
        waitFor(3);
        driver.findElement(By.id("add-to-cart-button")).click();//sepete ekleyin
    }
}

