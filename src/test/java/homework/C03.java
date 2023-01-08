package homework;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    public void test01(){
        //1- amazon gidin
        driver.get("https://www.amazon.com");

        //  Arama kutusunun solundaki dropdown menuyu handle edip listesini ekrana yazdırın
        WebElement dropDown = driver.findElement(By.id("searchDropdownBox"));
        Select select = new Select(dropDown);
        List<WebElement> list=select.getOptions();
        list.stream().forEach(t-> System.out.println(t.getText()));
//        for(WebElement element:list){
//            System.out.println("DropdownMenu = " + element.getText());
//        }

        //        dropdown menude 40 eleman olduğunu doğrulayın
        int numberOfElement = list.size();
        System.out.println("Size of All Elements: "+ numberOfElement);

        Assert.assertFalse(numberOfElement==40);

        // dropdown menuden elektronik bölümü seçin
        waitFor(3);
        driver.findElement(By.xpath("//option[text()='Electronics']")).click();

        // arama kutusuna iphone yazip aratin ve bulunan sonuç sayısını yazdırın
        WebElement searchox = driver.findElement(By.id("twotabsearchtextbox"));
                searchox.sendKeys("iphone", Keys.ENTER);
            //        sonuc sayisi bildiren yazinin iphone icerdigini test edin
        String actualResultText = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']")).getText();
        String expectedResultText = "iphone";
        Assert.assertTrue(actualResultText.contains(expectedResultText));
            //        ikinci ürüne relative locater kullanarak tıklayin
        driver.findElement(By.xpath("(//span[@class='a-size-base-plus a-color-base a-text-normal'])[2]")).click();
            //        ürünün title'ni ve fiyatını variable’a  assign edip ürünü sepete ekleyelim
        WebElement product = driver.findElement(By.xpath("//span[@id='productTitle']"));
       // String[] productTitle = product.getText().split(" ");
        System.out.println(product.getText());
        WebElement price = driver.findElement(By.xpath("//span[text()='$15.99']"));
        System.out.println(price.getText());

        WebElement addToCart = driver.findElement(By.xpath("//span[@id='submit.add-to-cart']"));
        addToCart.click();

        //1-sepetteki ürünlerle eklediğimiz ürünlerin aynı olduğunu isim ve fiyat olarak doğrulayın
        String actualTextInBox = driver.findElement(By.xpath("//div[@class='a-column a-span11 a-text-left a-spacing-top-large']")).getText();
        Assert.assertTrue(actualTextInBox.contains(price.getText()));
    }

    }


