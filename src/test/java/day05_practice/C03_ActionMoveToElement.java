package day05_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.Set;

public class C03_ActionMoveToElement extends TestBase {
    @Test
    public void test03() {

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

        Set<String> allWindows = driver.getWindowHandles();

        System.out.println(firstPageHandle);
        System.out.println(allWindows);

        String secondPageHandle="";
        for (String each : allWindows) {
            if(!each.equals(firstPageHandle)){
                secondPageHandle =each;
            }

        }
        driver.switchTo().window(secondPageHandle);

        String secondPageTitle = driver.getTitle();
        System.out.println(secondPageTitle);

        Assert.assertTrue(secondPageTitle.contains("Elektronik"));

    }
}