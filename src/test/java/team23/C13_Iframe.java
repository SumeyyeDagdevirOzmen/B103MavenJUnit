package team23;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C13_Iframe extends TestBase {
    //1. “http://webdriveruniversity.com/IFrame/index.html” sayfasina gidin
    //2. “Our Products” butonuna basin
    //3. “Cameras product”i tiklayin
    //4. Popup mesajini yazdirin
    //5. “close” butonuna basin
    //6. "WebdriverUniversity.com (IFrame)" linkini tiklayin
    //7. "http://webdriveruniversity.com/index.html" adresine gittigini test edin
    @Test
    public void iframeTest() {
        //1. “http://webdriveruniversity.com/IFrame/index.html” sayfasina gidin
        driver.get("http://webdriveruniversity.com/IFrame/index.html");

        //2. “Our Products” butonuna basin
        WebElement iframe = driver.findElement(By.xpath("//iframe[@id='frame']"));
        driver.switchTo().frame(iframe);
        WebElement ourProducts = driver.findElement(By.xpath("//a[text()='Our Products']"));
        waitFor(3);
        ourProducts.click();

        //3. “Cameras product”i tiklayin
        driver.findElement(By.xpath("//p[text()='Cameras']")).click();

        //4. Popup mesajini yazdirin
        waitFor(3);
        WebElement popUp = driver.findElement(By.xpath("//div[@class='modal-body']"));
        System.out.println("Popup Message = " + popUp.getText());
        //5. “close” butonuna basin
        WebElement popUpClose = driver.findElement(By.xpath("//button[text()='Close']"));
        popUpClose.click();

        //6. "WebdriverUniversity.com (IFrame)" linkini tiklayin
        driver.switchTo().parentFrame();
        driver.findElement(By.xpath("(//a[@id='nav-title'])[1]")).click();


        //7. "http://webdriveruniversity.com/index.html" adresine gittigini test edin
        String url = driver.getCurrentUrl();
        Assert.assertEquals("http://webdriveruniversity.com/index.html",url);
    }
}
