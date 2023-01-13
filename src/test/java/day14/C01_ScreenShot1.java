package day14;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C01_ScreenShot1 extends TestBase {
    //Class : screenShot1
    //Techpro education a git ve Sayfanin goruntusunu al
    //-“QA” aramasi yap
    //Acilen sayfanin metnini test et ve ekran goruntusu al: “Search Results for: qa”
    @Test
    public void fullPageScreenShotTest() throws IOException {
        /*
    Selenium tum ekran goruntusu nasil alinir?
    -tum ekran goruntusu selenium'dan gelen getScreenshotAs method'u ile alinir
    -getScreenshotAs method'u Selenium'daki TakeScreenshot API' indan gelir.
 */
        //Class : screenShot1
        //Techpro education a git ve Sayfanin goruntusunu al
        driver.get("https://www.techproeducation.com");
        // 1. Ekran goruntusunu getScreenShotAs metotu ile alip File olarak olusturalim.
        File goruntu = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        // 2. Almis oldugum ekran goruntusunu belirledigim bir path'e kaydet. dir=directory=dosya
        //NOTE: Kayit ismini dinamik yapmak icin date objesini kullandim
        String currentDate = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());//Halihazirdaki yil-ay-gun-saat-dakika-saniye
        String path = System.getProperty("user.dir") + "\\test-output\\EkranGoruntuleri\\"+currentDate+"image.png";
        File hedef = new File(path);

        //3. Goruntum ile dosyami birlestirip kaydetme islemini yapalim
        FileUtils.copyFile(goruntu, hedef);

        //        ALTERNATIF OLARAK TUM BU ADIMLARI TEK SEFERDE DEGISKEN KULLANMADAN YAPABILIRIM
//        FileUtils.copyFile(((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE),//goruntu
//        new File(System.getProperty("user.dir")+"\\test-output\\EkranGoruntuleri\\image.png"));//path


        //-“QA” aramasi yap
        driver.findElement(By.xpath("//input[@type='search']")).sendKeys("QA"+ Keys.ENTER);
        waitFor(3);

//        Acilan sayfanin metnini test et ve ekran goruntusu al: “Search Results for: QA”
        String expected = "Search Results for: QA";
        String text = driver.findElement(By.xpath("//*[contains(text(),'Search Results for')]")).getText();
        Assert.assertTrue(expected.contains(text));
//        'REUSABLE METHOD'  yardimiyla ekran goruntusunu alalim
        takeScreenShotOfPage();

    }
}
