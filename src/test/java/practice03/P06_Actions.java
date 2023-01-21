package practice03;

import com.beust.ah.A;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class P06_Actions extends TestBase {
    /*
     -https://jqueryui.com/slider/#colorpicker adrese gidiniz
     -Kutucuk içindeki rengi önce kırmızı sonra sarı yapınız
     -Sari oldugunu test edelim
     */
    @Test
    public void test01() {
        driver.get("https://jqueryui.com/slider/#colorpicker");
        WebElement iframe = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
        driver.switchTo().frame(iframe);

        //-Kutucuk içindeki rengi önce kırmızı sonra sarı yapınız

        WebElement greenSlider = driver.findElement(By.xpath("(//*[@class='ui-slider-handle ui-corner-all ui-state-default'])[2]"));
        WebElement blueSlider = driver.findElement(By.xpath("(//*[@class='ui-slider-handle ui-corner-all ui-state-default'])[3]"));
        Actions actions = new Actions(driver);
        actions.dragAndDropBy(greenSlider, -175, 0).perform();//Genellikle slider'lar icin bu method kullanilir.
        actions.dragAndDropBy(blueSlider,-80,0).perform();
        actions.dragAndDropBy(greenSlider, 301, 0).release().build().perform();
        //actions.dragAndDropBy(greenSlider,-175,0).dragAndDropBy(blueSlider,-80,0).perform().dragAndDropBy(greenSlider, 301, 0).release().build().perform();
        // bu sekilde tek seferde yapilabilir.



        //     -Sari oldugunu test edelim
        WebElement yellowBox = driver.findElement(By.xpath("//*[@style='background-color: rgb(255, 255, 0);']"));
        //assert yellowBox.isDisplayed();
        Assert.assertTrue(yellowBox.isDisplayed());
        //getCssValue("background-color");

    }
}

/*
Actions actions =new Actions(driver);
WebElement greenBar= driver.findElement(By.id("green"));

int barGenislik= greenBar.getSize().getWidth();

actions.clickAndHold(greenBar)
        .moveByOffset((barGenislik/2)*-1,0)
        .release()
        .perform();
 */

            /*
            for (int i=0 ; i<200 ;i++){

            actions.sendKeys(Keys.ARROW_LEFT).build().perform();
        }
             */
