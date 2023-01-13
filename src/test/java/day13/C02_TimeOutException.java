package day13;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

/*
TimeOutException:
If you use explicit wait and wait time is not enough/locator still incorrect then TimeOutException
Simply put, wait time is over but the commend is not completed
Solution:
-Increase the wait time
-Try using different wait. For example try using javascript executor wait for the page to load. This is also a dynamic wait
-I have different explicit waits in my Reusable util class. I have javascript executor wait as well. ReusableMethods.waitForPageToLoad(1);
-Case by case, I prefer different explicit waits to maximize the performance of the automation script
 */
public class C02_TimeOutException extends TestBase {
    /*
TimeOutException explicit wait kullanıldığı zaman ve element bulunamadığında alınan bir hatadır.
Şimdiye kadar karşılaşmamızın nedeni sadece implicit wait kullanmış olmamızdır.
Explicit wait ve yanlış locatar kullandığımız zaman TimeOutException alırız.
Explicit wait var, doğru locatar kullandık ama süre yeterli olmadığı durumlarda TimeOutException alırız.
Explicit wait var, doğru locatar kullandık, süre yeterli ama iframe var TimeOutException alırız.

Solution:
-Sureyi arttirmak
-Farkli explicit wait (ornegin waitforvisibilityOfElementLocated  cozmedi onun yerine presenceOfElementLocator) cesidi kullanmak.
Yada JavaScript executer daki waitleri sayfa gecislerini beklemek icin kullanabilirim.
-Locater'i tekrar kontrol etmek
-Frameworkumde hazir reusable methodlar var. Bu durumda timeoutexception aldigimda, hizlica o methodlar yardimiyla problemi cozebiliyoruz.
*/
/*
org.openqa.selenium.TimeoutException: Expected condition failed: expilicit wait kullandigimda ve locator bulunamdiginda alirim.
 */

    @Test
    public void  timeOutExceptionTest() {
        driver.get("https://techproeducation.com");

        //Expilicit wait icin olusturdugumuz method'lardan birini kullanalim
        //Parametre 1:Beklemek istedigim element, Parametre 2:Max sure
//       waitForVisibility(driver.findElement(By.xpath("//input[@type='searchh']")),25).
//        sendKeys("QA"+ Keys.ENTER);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("YANLIS ID")));//org.openqa.selenium.TimeoutException: Expected condition failed:
    }
}
