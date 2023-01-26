package day07;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C07_FilesDownload extends TestBase {
//Selenium websayfalarini automate edebilir
    @Test
    public void name() {
        //1.https://the-internet.herokuapp.com/download adresine gidiniz
        driver.get("https://the-internet.herokuapp.com/download");

        //2. LambdaTest.txt dosyasini indirelim
        driver.findElement(By.xpath("//a[text()='LambdaTest.txt']")).click();

        //3.dosyanin bilgisayarinizda downdloads'a basariyla indirilip indirilmedigini test ediniz
        //Bunu Java ile test edebilirim Selenium ile degil. Cunku selenium windowsa yani bilgisayarima mudahale edemez
        //"C:\Users\mamap      \Downloads\LambdaTest.txt"

        //Assert.assertTrue(Files.exists(Paths.get("C:\\Users\\mamap\\Downloads\\LambdaTest.txt")));//Bu islemi dinamik hale getirelim
        String difPath=System.getProperty("user.home");
        String samePath="\\Downloads\\LambdaTest.txt";
        String dynamicFilePath=difPath+samePath;
        Assert.assertTrue(Files.exists(Paths.get(dynamicFilePath)));



    }
}
