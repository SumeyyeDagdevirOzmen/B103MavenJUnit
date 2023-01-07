package homework;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.Set;

public class C02 extends TestBase {

    @Test
    public void test01() throws InterruptedException {
        //https://testcenter.techproeducation.com/index.php?page=multiple-windows
        driver.get("https://testcenter.techproeducation.com/index.php?page=multiple-windows");
        String window1Handle = driver.getWindowHandle();

        //Title in ‘Windows’ oldugunu test edin
        String actualTitle = driver.getTitle();
        String expectedTitle = "Windows";
        Assert.assertEquals(expectedTitle,actualTitle);

        //Click here a tiklayin
        waitFor(3);
        driver.findElement(By.xpath("//*[text()='Click Here']")).click();
        waitFor(4);

        //Sonra açılan sayfadaki title in ‘New Window’ oldugunu dogrulayin
        Set<String> allWindowHandles = driver.getWindowHandles();//{window1handle , window2Handle}
        for (String eachHandle : allWindowHandles) {
            //eger listedeki id window1 e esit degilse, otomatik olarak (bir sonrakine) window2 ye esittir
            if (!eachHandle.equals(window1Handle)) {
                driver.switchTo().window(eachHandle);//Burdaki eachHandle window2 handle'ina esittir.
                break;
            }
        }
        /*
         String eachWindow = driver.getWindowHandle();
        Set<String> allHandles = driver.getWindowHandles();
        allHandles.stream().filter(t->!t.equals(eachWindow)).limit(1).forEach(t->driver.switchTo().window(t));
         */
        String actualTitle2=driver.getTitle();
        String expectedTitle2="New Window";
        Assert.assertEquals(expectedTitle2,actualTitle2);
        Thread.sleep(3000);

        //1.window'a geri dondum
        driver.switchTo().window(window1Handle);




    }

}
