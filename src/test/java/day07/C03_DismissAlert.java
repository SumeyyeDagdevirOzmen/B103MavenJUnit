package day07;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C03_DismissAlert extends TestBase {
    @Test
    public void dismissAlertTest() throws InterruptedException {
        // https://testcenter.techproeducation.com/index.php?page=javascript-alerts  adresine gidin.
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");

        //2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının “You clicked: Cancel” oldugunu test edin.
        Thread.sleep(5000);
        driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
        driver.switchTo().alert().dismiss();//Cancel secenegine tikladik.
        Thread.sleep(5000);
        //result mesajının “You clicked: Cancel” oldugunu test edin.
       String actualResult = driver.findElement(By.id("result")).getText();
       String expectedResult = "You clicked: Cancel";
        Assert.assertEquals(expectedResult, actualResult);

    }
}
