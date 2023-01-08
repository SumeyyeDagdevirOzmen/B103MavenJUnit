package day12;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_FileUpload extends TestBase {

    @Test
    public void fileUploadTest(){

        //Tests packagenin altina bir class oluşturun : C05_UploadFile
        //https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");

        //chooseFile butonuna basalim
        WebElement chooeseFileButton = driver.findElement(By.id("file-upload"));

        //Yuklemek istediginiz dosyayi secelim.
        String dosyaYolu = System.getProperty("user.home")+"\\Desktop\\logo.jpeg";
        /*
        chooeseFileButton una yuklemek istedigim dosyanin path'ini gondererek dosyayi sectim.
         */
        chooeseFileButton.sendKeys(dosyaYolu);
        waitFor(5);

        //Upload butonuna basalim.
        WebElement upLoadButton = driver.findElement(By.id("file-submit"));
        upLoadButton.click();

        //“File Uploaded!” textinin goruntulendigini test edelim.
        String uploadedText = driver.findElement(By.xpath("//h3")).getText();
        Assert.assertEquals("File Uploaded!",uploadedText);
        waitFor(5);


    }

}
