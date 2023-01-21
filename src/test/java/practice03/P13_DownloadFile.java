package practice03;

import org.apache.poi.ss.formula.functions.T;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class P13_DownloadFile extends TestBase {
    //https://www.selenium.dev/downloads/ adresine gidelim
    //Platforms Supported by Selenium altındaki Browsers bölümü görünene kadar sayfayı indirelim
    //Browser bölümünden Chrome driver bölümündeki documentation linkine tıklıyalım
    //All versions available in Downloads altında Latest stable release olan linki tıklayalım
    //Açılan pencerede chromedriver'i indirelim
    //Driver'in indiğini doğrulayalım


    @Test
    public void test13() throws InterruptedException {
        //https://www.selenium.dev/downloads/ adresine gidelim
        driver.get("https://www.selenium.dev/downloads/");

        //Platforms Supported by Selenium altındaki Browsers bölümü görünene kadar sayfayı indirelim
        Actions actions = new Actions(driver);
        WebElement browser = driver.findElement(By.xpath("(//*[@type='button'])[83]"));
        actions.moveToElement(browser).perform();

        //Browser bölümünden Chrome driver bölümündeki documentation linkine tıklıyalım
        browser.click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//*[text()='documentation'])[5]")).click();
        Thread.sleep(1000);


        //All versions available in Downloads altında Latest stable release olan linki tıklayalım

        /*
        List<String> handles = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(handles.get(1));
         */
        driver.findElement(By.xpath("(//*[@class='XqQF9c'])[2]")).click();
        List<String> pencereler = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(pencereler.get(1));

        //Açılan pencerede chromedriver'i indirelim
        driver.findElement(By.xpath("//a[text()='chromedriver_win32.zip']")).click();
        Thread.sleep(10000);

        //Driver'in indiğini doğrulayalım
        //"C:\Users\mamap\Downloads\chromedriver_win32 (1).zip"
        String dosyaYolu = System.getProperty("user.home")+"\\Downloads\\chromedriver_win32 (1).zip";
        assert Files.exists(Paths.get(dosyaYolu));//Dosyanin inip inmedigini kontrol et
//        boolean isDownloaded= Files.exists(Paths.get(dosyaYolu));
//        Assert.assertTrue(isDownloaded);




    }
}
