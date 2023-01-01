package homework;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;
import java.util.Set;

public class C01 extends TestBase
{
    /*
    Bir class olusturun: IframeOdev
    https://the-internet.herokuapp.com/iframe  sitesine gidiniz
    sayfadaki toplam iframe sayısını bulunuz.
    Sayfa basliginda ‘Editor’ yazını içerdiğini test edelim.
    Paragrafdaki yaziyi silelim
    Sonrasinda paragrafa “iframein icindeyim” yazisini yazdıralım
    Alt kısımdaki yazının ‘Elemental Selenium’ yazisini içerdiğini test edelim


*/
    @Test
    public void test() throws InterruptedException {
        // https://the-internet.herokuapp.com/iframe  sitesine gidiniz
        driver.get("https://the-internet.herokuapp.com/iframe");


        // sayfadaki toplam iframe sayısını bulunuz.
        List<WebElement> listOfIframe = driver.findElements(By.xpath("//iframe"));
        System.out.println("Toplam Size : " + listOfIframe.size());

        // Sayfa basliginda ‘Editor’ yazını içerdiğini test edelim.
        String header = driver.findElement(By.tagName("h3")).getText();
        Assert.assertTrue(header.contains("Editor"));

        // Paragrafdaki yaziyi silelim
        driver.switchTo().frame(0);
        WebElement box = driver.findElement(By.xpath("//p[.='Your content goes here.']"));
        box.clear();
        Thread.sleep(3000);
        //  Sonrasinda paragrafa “iframein icindeyim” yazisini yazdıralım
        box.sendKeys("iframein icindeyim");
        Thread.sleep(4000);

        // Alt kısımdaki yazının ‘Elemental Selenium’ yazisini içerdiğini test edelim
        driver.switchTo().defaultContent();
        String actualText = driver.findElement(By.xpath("//*[.='Elemental Selenium']")).getText();
        Assert.assertTrue(actualText.contains("Elemental Selenium"));

    }
}