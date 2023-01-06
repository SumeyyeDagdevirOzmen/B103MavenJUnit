package day10;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C01_Actions1  extends TestBase {

        //    1.Adım: Actions class’ta bir object oluşturulur.
        //    Actions actions= new Actions(driver);
        //2. Adım: Üzerinde çalışmak istediğiniz WebElement
        //    öğesini bulunur.
        //    WebElement element = driver.findElement(locator);
        //3.Adim : perform() kullanarak bu webelement üzerinde action gerçekleştirilir.
    @Test
    public void rightClick(){
        //Class: Actions1
        //Method: rightClick
        //https://the-internet.herokuapp.com/context_menu  sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu");

        //1.ACTION OBJESI OLUSTUR
        Actions actions = new Actions(driver);
        //2. ELEMENTI LOCATE EDELIM
        WebElement kutu = driver.findElement(By.id("hot-spot"));

        //Kutuya sag tıklayın
        //TUM ACTIONSLAR actions OBJESIYLE BASLAR perform() ILE BITER
        actions.contextClick(kutu).perform();

        //Alert’te cikan yazinin “You selected a context menu” oldugunu test edin.
        //Object olusturmak wait gerektiren durumlarda makul.
        Assert.assertEquals("You selected a context menu",driver.switchTo().alert().getText());

        //Tamam diyerek alert’i kapatın
        driver.switchTo().alert().accept();

    }
}
