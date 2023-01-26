package day07;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.nio.file.Paths;

public class C08_FilesUpload extends TestBase {
    @Test
    public void name() {
        //masaustunde bir deneme dosyasi olusturun
       // deneme.txt dosyasini masaustunde olusturdum
        //https://the-internet.herokuapp.com/download adresine gidiniz
        driver.get("https://the-internet.herokuapp.com/upload");

        //"Dosya Sec" kismina deneme dosyasini yukleyiniz
        WebElement dosyaSecButonu = driver.findElement(By.xpath("//input[@id='file-upload']"));

        //"C:\Users\mamap\Desktop\deneme.txt"
        String farkliKisim= System.getProperty("user.home");
        String ortakKisim="\\Desktop\\deneme.txt";
        String yuklenecekDosya=farkliKisim+ortakKisim;
      // String dosyaYolu =System.getProperty("user.home"+"\\Desktop\\deneme.txt");

        dosyaSecButonu.sendKeys(yuklenecekDosya);

        //Upload butonuna basin
        driver.findElement(By.id("file-submit")).click();

        //"File Uploaded!" yazisinin goruntulendigini test edin
        WebElement fileUploadText=driver.findElement(By.xpath("//h3[text()='File Uploaded!']"));
        Assert.assertTrue(fileUploadText.isDisplayed());




    }
}
