package day04_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

import java.util.Set;

public class C03_WindowHandles extends TestBase {
    //Otomatik gecislerle ilgili bir soru.
    // 'https://www.n11.com' adresine gidin
    // arama motoruna 'oppo' yazıp aratın
    // ilk ürüne tıklayın
    // Basligin 'Oppo' icerdigini test edin.
    // ilk sayfaya donun ve Title'ını yazdırın

    @Test
    public void test03() {
        // 'https://www.n11.com' adresine gidin
        driver.get("https://www.n11.com");
        String firstPageHandle = driver.getWindowHandle();

        // arama motoruna 'oppo' yazıp aratın
        WebElement searchBox = driver.findElement(By.xpath("//input[@id='searchData']"));
        searchBox.sendKeys("oppo"+ Keys.ENTER);

        // ilk ürüne tıklayın
        WebElement firstProduct = driver.findElement(By.xpath("(//img[@class='lazy cardImage'])[1]"));
        firstProduct.click();

        Set<String> windowHandleSeti = driver.getWindowHandles();

        String secondPageHandle="";
        for (String each : windowHandleSeti) {
            if(!each.equals(firstPageHandle)){
                secondPageHandle =each;
            }
        }

        System.out.println(windowHandleSeti);

        System.out.println(firstPageHandle);


        driver.switchTo().window(secondPageHandle);

        // Basligin 'Oppo' icerdigini test edin.

        WebElement title = driver.findElement(By.xpath("//h1[@class='proName']"));
        Assert.assertTrue(title.getText().contains("Oppo"));

        // ilk sayfaya donun ve Title'ını yazdırın

        driver.switchTo().window(firstPageHandle);
        System.out.println("First Page Title = "+ driver.getTitle());


    }
}

/*
List<String> allHandles = new ArrayList<>(driver.getWindowHandles());
driver.switchTo().window(allHandles.get(1));
 */
/*
Set<String> acikPencereler = driver.getWindowHandles();
for (String w:acikPencereler) {
    if(w!=ilkSayfa){
        driver.switchTo().window(w);
        break;
    }
}
 */