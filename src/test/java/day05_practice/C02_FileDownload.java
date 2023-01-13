package day05_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C02_FileDownload extends TestBase {
    //1. 'https://the-internet.herokuapp.com/download' adresine gidiniz
    //2. some-file.txt dosyasini indirelim
    //3. dosyanin basariyla indirilip indirilmedigini test edelim (dosya downloads'a indirilecektir)
    @Test
    public void test02() {
        //1. 'https://the-internet.herokuapp.com/download' adresine gidiniz
        driver.get("https://the-internet.herokuapp.com/download");

        //2. some-file.txt dosyasini indirelim
        WebElement dosya = driver.findElement(By.xpath("//a[text()='some-file.txt']"));
        dosya.click();


        //3. dosyanin basariyla indirilip indirilmedigini test edelim (dosya downloads'a indirilecektir)
        //          "C:\Users\mamap                \Downloads\some-file.txt"  //Bu kismi dinamik yapalim
        String farkliKisim =  System.getProperty("user.home");
        String ortakKisim ="\\Downloads\\some-file.txt";
        String dosyaYolu2 =farkliKisim+ortakKisim;


        //String dosyaYolu = "C:\\Users\\mamap\\Downloads\\some-file.txt";

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu2)));


    }
}

/*
Daha dinamik bir sekilde boyle yazilabilir:
String filePath= System.getProperty("user.home")+"\\Downloads\\some-file.txt";

boolean isDownload= Files.exists(Paths.get(filePath));
waitFor(4);
Assert.assertTrue(isDownload);
 */