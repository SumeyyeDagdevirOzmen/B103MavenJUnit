package practice04;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class P02_ScreenShot extends TestBase {
    //Amazon sayfasına gidelim
    //Tüm sayfanın resmini alalım
    //Yeni bir sekmede techproeducation sayfasına gidip sayfanın resmini alalım
    //Tekrar amazon sayfasına dönüp iphone aratalım
    //Arama sonucunun resmini alalım

    String tarih;
    @Test
    public void test02() throws IOException, InterruptedException {
        //Amazon sayfasına gidelim
        driver.get("https://www.amazon.com");
        String amazonSayfasi = driver.getWindowHandle();

        //Tüm sayfanın resmini alalım
      //DateTimeFormatter gunTarih = DateTimeFormatter.ofPattern("MM/dd/yyyy");

        tarih = new SimpleDateFormat("hh_mm_ss_ddMMyyyy").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) driver;//Cast yaptik
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File("target/tumSayfaResmi/tumSayfa"+tarih+".jpeg"));
        //target/tumSayfaResmi
        /*
        FileUtils Class'i, file nesneleri ile birlikte kullanabilecegimiz methodlar icerir.
        Bu methodlari kullanarak dosyalarda okuma, yazma ve kopyalama islemlerini cok daha kolay yapabiliriz.
         */


        //Yeni bir sekmede techproeducation sayfasına gidip sayfanın resmini alalım
        Thread.sleep(6000);
        driver.switchTo().newWindow(WindowType.TAB);//Yeni bir sekme actik
        driver.get("https://techproeducation.com");
        tarih = new SimpleDateFormat("hh_mm_ss_ddMMyyyy").format(new Date());
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File("target/tumSayfaResmi/tumSayfa"+tarih+".jpeg"));

        //Tekrar amazon sayfasına dönüp iphone aratalım
        driver.switchTo().window(amazonSayfasi);
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);


        //Arama sonucunun resmini alalım
        //sonuc elementini locate edip webelemente assign edin
        WebElement sonuc = driver.findElement(By.xpath("(//*[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        FileUtils.copyFile(sonuc.getScreenshotAs(OutputType.FILE),new File("target/WebElementScreenShot/WEScreenShot"+tarih+".jpeg"));






    }
}
