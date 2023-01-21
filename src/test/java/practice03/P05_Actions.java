package practice03;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class P05_Actions extends TestBase {
    /*
    - http://szimek.github.io/signature_pad/ sayfasına gidiniz
    - Çıkan ekrana istediğiniz çizgi yada şekli çiziniz
    -Cizimden sonra clear butonuna basalim
    - Son olarak sayfayı temizleyiniz
     */

    @Test
    public void test01() throws InterruptedException {

        // - http://szimek.github.io/signature_pad/ sayfasına gidiniz
        driver.get("http://szimek.github.io/signature_pad/");
        WebElement canvas = driver.findElement(By.xpath("//canvas"));
        Actions actions = new Actions(driver);
        actions.moveToElement(canvas).clickAndHold();
        for (int i = 0; i < 20 ; i++) {
            actions.moveByOffset(-5,-5);
        }
        for (int i = 0; i < 20 ; i++) {
            actions.moveByOffset(0,5);
        }
        for (int i = 0; i < 20 ; i++) {
            actions.moveByOffset(5, 0);
        }

        actions.release().build().perform();

        //    - Çıkan ekrana istediğiniz çizgi yada şekli çiziniz
        //    -Cizimden sonra clear butonuna basalim


        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[text()='Clear']")).click();

        //    - Son olarak sayfayı temizleyiniz







    }

}