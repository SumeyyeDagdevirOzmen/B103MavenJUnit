package practice04;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WindowType;
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

        //Tüm sayfanın resmini alalım
      //DateTimeFormatter gunTarih = DateTimeFormatter.ofPattern("MM/dd/yyyy");

        tarih = new SimpleDateFormat("hh_mm_ss_ddMMyyyy").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) driver;//Cast yaptik
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File("target/tumSayfaResim/tumSayfa"+tarih+".jpeg"));
        /*
        FileUtils Class'i, file nesneleri ile birlikte kullanabilecegimiz methodlar icerir.
        Bu methodlari kullanarak dosyalarda okuma, yazma ve kopyalama islemlerini cok daha kolay yapabiliriz.
         */

        Thread.sleep(6000);
        //Yeni bir sekmede techproeducation sayfasına gidip sayfanın resmini alalım
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://techproeducation.com");
        tarih = new SimpleDateFormat("hh_mm_ss_ddMMyyyy").format(new Date());
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File("target/tumSayfaResim/tumSayfa"+tarih+".jpeg"));

        //Tekrar amazon sayfasına dönüp iphone aratalım
        //Driver.back

        //Arama sonucunun resmini alalım
        //sonuc elementini locate edip webelemente assign edin
        // FileUtils.copyFile(WE.getScreenshotAs(OutputType.FILE),new File("target/tumSayfaResim/tumSayfa"+tarih+".jpeg"));

    }
}
