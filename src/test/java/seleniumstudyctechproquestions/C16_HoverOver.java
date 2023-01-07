package seleniumstudyctechproquestions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Interaction;
import utilities.TestBase;

public class C16_HoverOver extends TestBase {
    @Test
    public void hoverOverTest(){
        //1. "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");

        //2. "Hover over Me First" kutusunun ustune gelin
        Actions action = new Actions(driver);
        WebElement firstBox = driver.findElement(By.xpath("(//button[@class='dropbtn'])[1]"));
        action.moveToElement(firstBox).perform();
        //3. "Link 1" e tiklayin
        WebElement link1 = driver.findElement(By.xpath("//a[text()='Link 1']"));
        link1.click();
        //4. Popup mesajini yazdirin
        System.out.println(driver.switchTo().alert().getText());

        //5. Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();

        //6. "Click and hold" kutusuna basili tutun
        WebElement clickAndHoldBox = driver.findElement(By.xpath("//p[.='Click and Hold!']"));
        action.clickAndHold(clickAndHoldBox).build().perform();

        //7. "Click and hold" kutusunda cikan yaziyi yazdirin
        System.out.println(driver.findElement(By.xpath("//div[@id='click-box']")).getText());

        //8. "Double click me" butonunu cift tiklayin
        WebElement doubleClickButton = driver.findElement(By.xpath("//div[@id='double-click']"));
        action.moveToElement(doubleClickButton).doubleClick().build().perform();

        //9. "Double click me" butonunun renk değiştridiğini doğrulayın
        //WebElement sari=driver.findElement(By.xpath("//div[@class='div-double-click']"));
        WebElement yesil=driver.findElement(By.xpath("//div[@class='div-double-click double']"));
        Assert.assertTrue(yesil.isDisplayed());

    }

}

/*
  //8. "Double click me" butonunu cift tiklayin
    WebElement doubleClickButton= driver.findElement(By.id("double-click"));
    String color1= doubleClickButton.getCssValue("background-color");
    System.out.println("color1 = " + color1);
    actions.doubleClick(doubleClickButton).build().perform();

    //9. "Double click me" butonunun renk değiştridiğini doğrulayın
    String color2= doubleClickButton.getCssValue("background-color");
    System.out.println("color2 = " + color2);
    Assert.assertNotEquals(color1, color2);
 */