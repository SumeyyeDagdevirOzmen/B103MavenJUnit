package homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

/*
          Test01 :  1- amazon gidin
        Arama kutusunun solundaki dropdown menuyu handle edip listesini ekrana yazdırın
        dropdown menude 40 eleman olduğunu doğrulayın
        Test02
        dropdown menuden elektronik bölümü seçin
        arama kutusuna iphone yazip aratin ve bulunan sonuç sayısını yazdırın
        sonuc sayisi bildiren yazinin iphone icerdigini test edin
        ikinci ürüne relative locater kullanarak tıklayin
        ürünün title'ni ve fiyatını variable’a  assign edip ürünü sepete ekleyelim
        Test03
        yeni bir sekme açarak amazon anasayfaya gidin
        dropdown’dan bebek bölümüne secin
        bebek puset aratıp bulundan sonuç sayısını yazdırın
        sonuç yazsının puset içerdiğini test edin
        5-üçüncü ürüne relative locater kullanarak tıklayin
        6-title ve fiyat bilgilerini assign edelim ve ürünü sepete ekleyin  Test 4
        1-sepetteki ürünlerle eklediğimiz ürünlerin aynı olduğunu isim ve fiyat olarak doğrulayın
           */
public class C03 extends TestBase {
    @Test
    public void test02() {

        //1- amazon gidin
        driver.get("https://www.amazon.com");



        //  Arama kutusunun solundaki dropdown menuyu handle edip listesini ekrana yazdırın
        WebElement dropDown = driver.findElement(By.id("searchDropdownBox"));
        Select select = new Select(dropDown);
        List<WebElement> list = select.getOptions();
        // list.stream().forEach(t-> System.out.println(t.getText()));
        for (WebElement element : list) {
            System.out.println("DropdownMenu = " + element.getText());
        }




        //        dropdown menude 40 eleman olduğunu doğrulayın
        int numberOfElement = list.size();
        System.out.println("Size of All Elements: " + numberOfElement);
        Assert.assertFalse(numberOfElement == 40);



        // dropdown menuden elektronik bölümü seçin
        waitFor(3);
        driver.findElement(By.xpath("//option[text()='Electronics']")).click();
        //select.selectByVisibleText("Electronics");



        // arama kutusuna iphone yazip aratin ve bulunan sonuç sayısını yazdırın
        WebElement searchox = driver.findElement(By.id("twotabsearchtextbox"));
        searchox.sendKeys("iphone", Keys.ENTER);



        //sonuc sayisi bildiren yazinin iphone icerdigini test edin
        String actualResultText = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']")).getText();
        String expectedResultText = "iphone";
        Assert.assertTrue(actualResultText.contains(expectedResultText));


        List<WebElement> productList = driver.findElements(By.xpath("//div[@class='a-section a-spacing-small puis-padding-left-small puis-padding-right-small']"));
        System.out.println(productList.get(1).getText());
        String title = driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small puis-padding-left-small puis-padding-right-small'])[2]")).getText();
        System.out.println("Title : " + title);


        //        ikinci ürüne relative locater kullanarak tıklayin
        WebElement ilkUrun = driver.findElement(By.xpath("(//div//img [@data-image-index='1'])[1]"));
        WebElement ucuncuUrun = driver.findElement(By.xpath("(//div//img [@data-image-index='3'])[1]"));
        WebElement ikinciUrun = driver.findElement(with(By.tagName("div")).toRightOf(ilkUrun).toLeftOf(ucuncuUrun));
       // ikinciUrun.click();

//        WebElement ikinciUrun2 = driver.findElement(By.xpath("(//div//img [@data-image-index='2'])[1]"));
//        ikinciUrun2.click();




//         ürünün title'ni ve fiyatını variable'a  assign edip ürünü sepete ekleyelim
        WebElement price = driver.findElement(By.xpath("//div[@class='a-section a-spacing-micro']"));
        WebElement addToCart = driver.findElement(By.xpath("//span[@id='submit.add-to-cart']"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='submit.add-to-cart']")));
        addToCart.click();

    }

}


