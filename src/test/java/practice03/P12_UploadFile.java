package practice03;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class P12_UploadFile extends TestBase {
    //https://demo.guru99.com/test/upload/ adresine gidiniz
    //Bilgisayarınızdan herhangi bir dosyayı upload ediniz
    // I accept terms of service bölümünü tikleyin
    // Submit File buttonuna basınız
    // "1 file has been successfully uploaded" görünür olduğunu test edin


    @Test
    public void test12() throws InterruptedException {
        //https://demo.guru99.com/test/upload/ adresine gidiniz
        driver.get("https://demo.guru99.com/test/upload/");
        /*
        WebElement ifrane = driver.findElement(By.xpath("//*[@class='faktor-iframe-wrapper']"));
driver.switchTo().frame(ifrane);
driver.findElement(By.xpath("//*[text()='Accept All']")).click();
driver.switchTo().defaultContent();
         */
        driver.switchTo().frame(driver.findElement(By.id("gdpr-consent-notice")));
        Thread.sleep(3000);
        driver.findElement(By.xpath("//span[text()='Accept All']")).click();

        driver.switchTo().defaultContent();

        //Bilgisayarınızdan herhangi bir dosyayı upload ediniz
        WebElement dosyaSec = driver.findElement(By.id("uploadfile_0"));
        String dosyaYolu = "C:\\Users\\mamap\\Desktop\\logo.jpeg";//Dosyanin gercek yolunu Copy As path ile alip gorebilmek icin String'e atadik
//        String farkliKisim = System.getProperty("user.home");
//        String ortakYol = "\\Desktop\\logo.jpeg";
//        String dosyaYolu = farkliKisim+ortakYol;
        dosyaSec.sendKeys(dosyaYolu);

        // I accept terms of service bölümünü tikleyin
        // Submit File buttonuna basınız
        WebElement checkBox =  driver.findElement(By.xpath("//*[@id='terms']"));
        checkBox.click();
        checkBox.sendKeys(Keys.TAB,Keys.TAB,Keys.ENTER);
        // "1 file has been successfully uploaded" görünür olduğunu test edin
        Thread.sleep(2000);
        assert driver.findElement(By.xpath("//*[@id='res']")).isDisplayed();


        // I accept terms of service bölümünü tiklayin

        // Submit File buttonuna basınız

        // "1 file has been successfully uploaded" görünür olduğunu test edin
    }
}
