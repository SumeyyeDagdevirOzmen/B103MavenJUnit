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

        driver.get("http://szimek.github.io/signature_pad/");
        WebElement canvas = driver.findElement(By.xpath("//*[@class='signature-pad--body']"));
        Actions actions = new Actions(driver);
        // move to starting point of name
        actions.moveToElement(canvas, 100, 100);
        // Press the left mouse button and move the mouse to draw the letter 'h'
        actions.clickAndHold().moveByOffset(0, 50).moveByOffset(50, 0).moveByOffset(0, -50).moveByOffset(-50, 0).release().perform();

        //move to next letter position
        actions.moveByOffset(60, 0);
        // Press the left mouse button and move the mouse to draw the letter 'u'
        actions.clickAndHold().moveByOffset(0, 50).moveByOffset(50, 0).moveByOffset(0, -50).moveByOffset(-50, -50).moveByOffset(0, 50).release().perform();

        // move to next letter position
        actions.moveByOffset(60, 0);
        // Press the left mouse button and move the mouse to draw the letter 's'
        actions.moveByOffset(0, 50).moveByOffset(50, -50).moveByOffset(0, 50).moveByOffset(-50, -50).moveByOffset(0, 50).perform();
        actions.moveByOffset(60, 0);
        // Press the left mouse button and move the mouse to draw the letter 'e'
        actions.clickAndHold().moveByOffset(0, -50).moveByOffset(50, 50).moveByOffset(0, -50).moveByOffset(-50, 0).release().perform();
        actions.moveByOffset(60, 0);
        // Press the left mouse button and move the mouse to draw the letter 'y'
        actions.clickAndHold().moveByOffset(50, -50).moveByOffset(-50, 50).release().perform();
        actions.moveByOffset(60, 0);
        // Press the left mouse button and move the mouse to draw the letter 'i'
        actions.clickAndHold().moveByOffset(25, -25).moveByOffset(-25, 25).moveByOffset(25, -25).release().perform();
        actions.moveByOffset(60, 0);
        // Press the left mouse button and move the mouse to draw the letter 'n'
        actions.clickAndHold().moveByOffset(0, -50).moveByOffset(50, 0).moveByOffset(0, 50).moveByOffset(-50, 0).release().perform();

        // Locate the clear button
        //  WebElement clearBtn = driver.findElement(By.cssSelector("a.btn.clear"));
        // Click the clear button
        //  clearBtn.click();

    }

}