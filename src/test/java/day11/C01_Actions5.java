package day11;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C01_Actions5 extends TestBase {

    @Test
    public void keyboardActionsTest(){
        //Create a class: Action5
        //Create a method keyboardActions
        //Google a gidin https://www.google.com
        driver.get("https://www.google.com");
        driver.findElement(By.xpath("//div[text()='Accept all']")).click();

        //‘iPhone X fiyatlari’ yazdir (SHIFT TUSUNA BASILARAK)
        WebElement aramaKutusu = driver.findElement(By.name("q"));
        //aramaKutusu.sendKeys("IPHONE X FIYATLARI" + Keys.ENTER);
        Actions action = new Actions(driver);
        action
                .keyDown(aramaKutusu,Keys.SHIFT)//arama kutusunun ustunde Shift tusuna bas
                .sendKeys("iPhone X fiyatlari")//shift'e basiliyken yazi yaz
                .keyUp(aramaKutusu,Keys.SHIFT)//shift de artik basma
                .sendKeys("  cok pahali! "+Keys.ENTER)//normal halde yaz ve enter tusuna bas
                .build()//birden fazla actions methodu kullanildiginda build() kullanilmasi onerilir.Yapiyi guclendirir.
                .perform();

        //‘ cok pahali!’ Yazdır (SHIFT TUSUNA BASILMAYARAK)

        //Ve ENTER tusuna bas

    }
}
