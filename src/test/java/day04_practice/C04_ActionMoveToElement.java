package day04_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.Set;

// https://amazon.com adresine gidiniz
// sag ust bolumde bulunan dil secenek menusunun acilmasi icin mause'u bu menunun ustune getirelim
// Change country/region butonuna basiniz
// United States dropdown'undan 'Turkey (Türkiye)' seciniz
// Go to website butonuna tiklayiniz
// acilan yeni sayfadanin Title'inin Elektronik icerdigini test ediniz
public class C04_ActionMoveToElement extends TestBase {
    @Test
    public void test04() {

        // https://amazon.com adresine gidiniz
        driver.get("https://amazon.com");
        String firstPageHandle = driver.getWindowHandle();

        // sag ust bolumde bulunan dil secenek menusunun acilmasi icin mause'u bu menunun ustune getirelim
        Actions actions = new Actions(driver);
        WebElement language = driver.findElement(By.xpath("//a[@id='icp-nav-flyout']"));
        actions.moveToElement(language).perform();

        // Change country/region butonuna basiniz
        driver.findElement(By.xpath("(//div[text()='Change country/region.'])[1]")).click();

        // United States dropdown'undan 'Turkey (Türkiye)' seciniz
        WebElement dropDownMenu = driver.findElement(By.xpath("//select[@id='icp-dropdown']"));
        Select select = new Select(dropDownMenu);
        select.selectByVisibleText("Turkey (Türkiye)");

        //dropdown opsiyon listesi 'go to website' butonuna engel oldugu icin,
        // herhangi bir yere click yapip dropdown opsiyon listesinin toparlanmasini sagladik.
        driver.findElement(By.xpath("//span[text()='Changing country/region website']")).click();//Bos bir yere tikladik gotowebsite butonuna tiklayabilmek icin

        // Go to website butonuna tiklayiniz

        driver.findElement(By.xpath("//span[@id='icp-save-button']")).click();

        // acilan yeni sayfadanin Title'inin Elektronik icerdigini test ediniz
//
//        Set<String> windowHandleSeti = driver.getWindowHandles();
//
//        String secondPageHandle="";
//        for (String each : windowHandleSeti) {
//            if(!each.equals(firstPageHandle)){
//                secondPageHandle =each;
//            }
//        }
//        driver.switchTo().window(secondPageHandle);

        switchToWindow(1);
        String title = driver.getTitle();
        Assert.assertTrue(title.contains("Elektronik"));

    }
}