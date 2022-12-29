package day07;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C04_PromptAlert extends TestBase {
    //    3. butona tıklayın,

    @Test
    public void sendKeysmethod() throws InterruptedException {
        // https://testcenter.techproeducation.com/index.php?page=javascript-alerts  adresine gidin.
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");

        //    3. butona tıklayın,

        driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
        Thread.sleep(6000);
        //    uyarıdaki metin kutusuna isminizi yazin,
        driver.switchTo().alert().sendKeys("Sumeyye");
        Thread.sleep(5000);
        //    OK butonuna tıklayın
        driver.switchTo().alert().accept();
        Thread.sleep(5000);
        //    ve result mesajında isminizin görüntülendiğini doğrulayın.
        String actualResult = driver.findElement(By.id("result")).getText();
        String expectedResult ="Sumeyye";
        Assert.assertTrue(actualResult.contains(expectedResult));
        Thread.sleep(5000);
    }

}
