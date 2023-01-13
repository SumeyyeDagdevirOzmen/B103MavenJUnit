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
    public void test01() {

//     http://szimek.github.io/signature_pad/ sayfasına gidiniz
        driver.get("http://szimek.github.io/signature_pad/");
//     Çıkan ekrana istediğiniz çizgi yada şekli çiziniz
        WebElement canvas = driver.findElement(By.xpath("//div[@class='signature-pad--body']"));

        Actions actions = new Actions(driver);


        int x =canvas.getSize().getWidth();
        int y =canvas.getSize().getHeight();
       // var ctx = canvas.getContext("2d");

//        actions
//                .clickAndHold(canvas)//Kaynagi tut
//                .moveByOffset(430, 30)
//                .release()//kaynagi birak
//                .build()
//                .perform();
        actions.moveToElement(canvas, 100, 100).clickAndHold().moveByOffset(400,400).
                moveByOffset(800,800).moveByOffset(1000,-500).release().perform();





        // canvas.click();



//        actions.moveToElement(canvas, 100, 100).clickAndHold().moveByOffset(400,400).perform();
//        actions.clickAndHold().moveByOffset(800,800).perform();
//        actions.clickAndHold().moveByOffset(400,800).release().build().perform();




    }


//    Cizimden sonra clear butonuna basalim
//    Son olarak sayfayı temizleyiniz


    }

