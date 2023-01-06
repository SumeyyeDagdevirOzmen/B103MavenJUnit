package day10;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C02_Actions2 extends TestBase {
    @Test
    public void hoverOverTest() {
        /*
        MANUAL:
        1. Amazon home sayfasina git
        2. Account & list e uzerinde bekle -mouse over - hover over
        3.Acilan pencerede Account linkine tokla
        4.Acilan sayfanin Title inin, your Account oldugunu dogrula
         */

        //1. Amazon home sayfasina git
        driver.get("https://www.amazon.com");

        //Account & list'in uzerinde bekle -mouse over - hover over
        //Action Objesi
        Actions actions =new Actions(driver);
        //Elemani bul
        WebElement accountList = driver.findElement(By.id("nav-link-accountList"));
        waitFor(1);
        //Uygun actions methodunu kullan. En sonda perform() kullanmayi unutma!
        actions.moveToElement(accountList).perform();//bu elementin ustune git sonra bu islemi gerceklestir
        waitFor(3);

        //  3.Acilan pencerede Account linkine tokla
        driver.findElement(By.linkText("Account")).click();

        //  4.Acilan sayfanin Title inin, 'Your Account' oldugunu dogrula
        Assert.assertTrue(driver.getTitle().contains("Your Account"));


    }
}
