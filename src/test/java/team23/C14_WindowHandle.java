package team23;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C14_WindowHandle extends TestBase {
    //1."http://webdriveruniversity.com/" adresine gidin
    //2."Login Portal" a kadar asagi inin
    //3."Login Portal" a tiklayin
    //4.Diger window'a gecin
    //5."username" ve "password" kutularina deger yazdirin
    //6."login" butonuna basin
    //7.Popup'ta cikan yazinin "validation failed" oldugunu test edin
    //8.Ok diyerek Popup'i kapatin
    //9.Ilk sayfaya geri donun
    //10.Ilk sayfaya donuldugunu test edin

    @Test
    public void windowHandleTest() {
        ///1."http://webdriveruniversity.com/" adresine gidin
        driver.get("http://webdriveruniversity.com/");

        //2."Login Portal" a kadar asagi inin
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();


        //3."Login Portal" a tiklayin
        driver.findElement(By.xpath("//h1[text()='LOGIN PORTAL']")).click();

        //4.Diger window'a gecin
        switchToWindow(1);

        //5."username" ve "password" kutularina deger yazdirin
        //6."login" butonuna basin
        Faker faker = new Faker();
        driver.findElement(By.xpath("//input[@id='text']")).sendKeys(faker.name().firstName(),
                Keys.TAB,faker.internet().password(),Keys.TAB,Keys.ENTER);

        //7.Popup'ta cikan yazinin "validation failed" oldugunu test edin
        String actualPopUpText = driver.switchTo().alert().getText();
       String expectedText= "validation failed";
       Assert.assertEquals(expectedText, actualPopUpText);

        //8.Ok diyerek Popup'i kapatin
        driver.switchTo().alert().accept();

        //9.Ilk sayfaya geri donun
        switchToWindow(0);
        //10.Ilk sayfaya donuldugunu test edin
        Assert.assertTrue(driver.findElement(By.xpath("//h1[text()='My Courses & Promo Codes']")).isDisplayed());
    }
}
