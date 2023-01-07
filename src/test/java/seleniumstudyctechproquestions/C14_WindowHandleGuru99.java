package seleniumstudyctechproquestions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.Set;

public class C14_WindowHandleGuru99 extends TestBase {
    @Test
    public void test01() throws InterruptedException {
        // url'ye git: http://demo.guru99.com/popup.php
        driver.get("http://demo.guru99.com/popup.php");
        WebElement iframe = driver.findElement(By.xpath("//iframe[@id='gdpr-consent-notice']"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.xpath("//span[text()='Accept All']")).click();
        waitFor(4);
        //ilk pencereyi al
        String window1 = driver.getWindowHandle();
        String firstPage = driver.getCurrentUrl();

        // "Click Here" butonuna tıklayın
        driver.findElement(By.xpath("//a[text()='Click Here']")).click();

        //setteki tüm pencereyi al
        Set<String> allWindows= driver.getWindowHandles();

        //diğer pencereye geç
        allWindows.stream().filter(t->!t.contains(window1)).limit(1).forEach(t->driver.switchTo().window(t));

        //e-posta kimliğini (somepne@gmail.com) girin ve bu girişe bir şey yazın
        driver.findElement(By.xpath("//input[@name='emailid']")).sendKeys("somepne@gmail.com",
                //Gönder düğmesine tıklayarak
                Keys.TAB, Keys.ENTER);
        Thread.sleep(3000);

        //""This access is valid only for 20 days."" ifadesinin beklendiği gibi olduğunu doğrula
        String actualText = driver.findElement(By.xpath("//h3[text()='This access is valid only for 20 days.']")).getText();
        Assert.assertEquals("This access is valid only for 20 days.",actualText);

        //Tekrar ilk pencereye geç
        driver.switchTo().window(window1);

        //İlk pencerede olduğunu doğrula
        String url = driver.getCurrentUrl();
        Assert.assertEquals(firstPage,url);
    }

}
