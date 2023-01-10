package homework;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C05 extends TestBase {
                /*
                Keyboard Base Actions
            Homework
            Yeni Class olusturun ActionsClassHomeWork
            1- "http://webdriveruniversity.com/Actions" sayfasina gidin  2- Hover over Me First" kutusunun ustune gelin
            Link 1" e tiklayin
            Popup mesajini yazdirin
            Popup'i tamam diyerek kapatin
            “Click and hold" kutusuna basili tutun
            7-“Click and hold" kutusunda cikan yaziyi yazdirin
            8- “Double click me" butonunu cift tiklayin
                 */
    @Test
    public void keyboardBaseActionsTest(){

        // 1- "http://webdriveruniversity.com/Actions" sayfasina gidin  2- Hover over Me First" kutusunun ustune gelin
        driver.get("http://webdriveruniversity.com/Actions");

        //            Link 1" e tiklayin
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//button[.='Hover Over Me First!']"))).perform();
        waitFor(3);
        driver.findElement(By.linkText("Link 1")).click();

        //            Popup mesajini yazdirin
        System.out.println("Popup Message : "+ driver.switchTo().alert().getText());

        //            Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();

        //            “Click and hold" kutusuna basili tutun
        driver.switchTo().defaultContent();
        WebElement clickAndHoldText = driver.findElement(By.xpath("//p[.='Click and Hold!']"));
        actions.clickAndHold(clickAndHoldText).perform();

        //  7-“Click and hold" kutusunda cikan yaziyi yazdirin
        WebElement textBox = driver.findElement(By.id("click-box"));
        System.out.println("Kutu metni : "+ textBox.getText());

        // 8- “Double click me" butonunu cift tiklayin
       actions.doubleClick(driver.findElement(By.tagName("h2"))).perform();

    }
}
