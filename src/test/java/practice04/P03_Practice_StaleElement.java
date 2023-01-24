package practice04;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class P03_Practice_StaleElement extends TestBase {
    //Amazon sayfasina gidelim
    //iphone aratalim
    //Cikan urunlerde sadece Apple iphone yazanlari tiklayalim
    @Test
    public void test03() {

        //Amazon sayfasina gidelim
        driver.get("https://www.amazon.com");

        //iphone aratalim
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);

        //Cikan urunlerde sadece Apple iphone yazanlari tiklayalim
        List<WebElement>urunler = driver.findElements(By.partialLinkText("Apple iPhone"));
        //TEXT ICINDE APPLE IPHONE YAZISI GECENLERI ALICAK
        //[contains(text(),'Apple iPhone')]

        for (int i = 0; i <urunler.size() ; i++) {
            urunler = driver.findElements(By.partialLinkText("Apple iPhone"));
            urunler.get(i).click();
            driver.navigate().back();//org.openqa.selenium.StaleElementReferenceException:

        }
        //StaleElementReferansException hatasi handle etmek icin for loop icine webelementlerden olusturdugumuz
        //listi koymaliyiz.



    }
}
