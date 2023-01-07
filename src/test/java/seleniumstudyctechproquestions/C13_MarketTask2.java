package seleniumstudyctechproquestions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.List;

public class C13_MarketTask2 extends TestBase {

    //Go to https://www.amazon.com.tr/
    //Search iPhone13 512
    //Check that the results are listed
    //Click iPhone13 at the top of the list
    //Log the following values for each size .Size information .Price .Color .Stock status
    //Isim - Renk - Stok - Boyut - Fiyat
    /*
    We expect you tu automate the following steps via Selenium Web Driver, regerdless of
    checking for expected/actual results. We prefer Chrome as the browser, but the choice
    is yours.
    Notes: It may also be necessary to write code to accept the cookies warning.
     */
    @Test
    public void test01() throws InterruptedException {
        //  1. Go to "https://www.amazon.com.tr/"
        driver.get("https://www.amazon.com.tr/");
        driver.findElement(By.xpath("//*[@name=\"accept\"]")).click(); //accept cookies
        //  2. Search iPhone13 512
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iPhone13 512", Keys.ENTER);
        //  3. Check that the result are listed
        Assert.assertTrue(driver.findElement(By.xpath("//*[.='SONUÇLAR']")).isDisplayed());
        //  4. Click iPhone13 at the top of the list
        driver.findElement(By.xpath("//img[@class=\"s-image\"][1]")).click();
        //  5. Log the following values for each size
        //size_name_2
        //  .Size information .Price .Color .Stock status
        List<WebElement> renkler = driver.findElements(By.xpath("(//ul[@class=\"a-unordered-list a-nostyle a-button-list a-declarative a-button-toggle-group a-horizontal dimension-values-list\"])[1]/li[@data-asin]"));
        for(int i=0; i<renkler.size(); i++){
            List<WebElement> renkler1 = driver.findElements(By.xpath("(//ul[@class=\"a-unordered-list a-nostyle a-button-list a-declarative a-button-toggle-group a-horizontal dimension-values-list\"])[1]/li[@data-asin]/span/span"));
            renkler1.get(i).click();

            List<WebElement> boyutlar = driver.findElements(By.xpath("(//*[@id=\"tp-inline-twister-dim-values-container\"])[2]//ul/li[@data-asin]"));
            for(int k=0; k<boyutlar.size(); k++){
                if(boyutlar.get(k).getText().contains("Mevcut")){
                    System.out.println(driver.findElement(By.id("productTitle")).getText().split("\\(")[0]+ " ("+ boyutlar.get(k).getText().split("\n")[0] +")" + " - " + driver.findElement(By.id("inline-twister-expanded-dimension-text-color_name")).getText());
                    System.out.println("\t\tBoyut: " + boyutlar.get(k).getText().split("\n")[0]);
                    System.out.println("\t\tRenk:  " + driver.findElement(By.id("inline-twister-expanded-dimension-text-color_name")).getText());
                    System.out.println("\t\tFiyat: " + "stokta olmadığı için fiyat bilgisi yok");
                    System.out.println("\t\tStok: " + "Stokta Yok...");
                }else{
                    boyutlar.get(k).click();
                    Thread.sleep(2000);
                    Actions action = new Actions(driver);
                    action.moveByOffset(0, 0).click().build().perform();
                    Thread.sleep(2000);
                    System.out.println(driver.findElement(By.id("productTitle")).getText());
                    System.out.println("\t\tBoyut: " + boyutlar.get(k).getText().split("\n")[0]);
                    System.out.println("\t\tRenk:  " + driver.findElement(By.id("inline-twister-expanded-dimension-text-color_name")).getText());
                    System.out.println("\t\tFiyat: " + boyutlar.get(k).getText().split("\n")[1]);
                    if(driver.findElement(By.xpath("//*[@class=\"a-section a-spacing-base a-spacing-top-micro }\"]/span")).getText().contains("kargo")){
                        System.out.println("\t\tStok: Stokta var...");
                    }else{
                        System.out.println("\t\tStok: " + driver.findElement(By.xpath("//*[@class=\"a-section a-spacing-base a-spacing-top-micro }\"]/span")).getText());
                    }
                }
                System.out.println("**************************************************************************************");
            }
        }
    }
}
