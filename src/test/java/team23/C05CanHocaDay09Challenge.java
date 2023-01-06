package team23;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;

public class C05CanHocaDay09Challenge extends TestBase {
    @Test
    public void test01(){

        //       url'ye git: http://demo.guru99.com/popup.php
        driver.get("http://demo.guru99.com/popup.php");
        WebElement iframe = driver.findElement(By.xpath("//iframe[@id='gdpr-consent-notice']"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.xpath("//span[text()='Accept All']")).click();
        //       ilk pencereyi al
       String ilkPencere = driver.getWindowHandle();
        //       "Click Here" butonuna tıklayın
         driver.findElement(By.xpath("//a[.='Click Here']")).click();
         String url=driver.getCurrentUrl();
        System.out.println(url);
         String windowHandle2 =driver.getWindowHandle();
        //       setteki tüm pencereyi al
        List<String> windowHandles = new ArrayList<>(driver.getWindowHandles());
        System.out.println("Window Handles= "+windowHandles);

        //       diğer pencereye geç
        driver.switchTo().window(windowHandles.get(1));

        //       e-posta kimliğini (somepne@gmail.com) girin ve bu girişe bir şey yazın
        driver.findElement(By.xpath("//*[@type='text']")).sendKeys("abcd@gmail.com", Keys.ENTER);
        //       Gönder düğmesine tıklayarak

        //       ""This access is valid only for 20 days."" ifadesinin beklendiği gibi olduğunu doğrula
        String actualMessage = driver.findElement(By.xpath("//h3")).getText();
        String expectedMessage= "This access is valid only for 20 days.";
        Assert.assertEquals(expectedMessage, actualMessage);


        //       Tekrar ilk pencereye geç
        driver.switchTo().window(windowHandles.get(0));
        //       İlk pencerede olduğunu doğrula
        Assert.assertTrue(driver.findElement(By.xpath("//a[.='Click Here']")).isDisplayed());
        //
    }

}
