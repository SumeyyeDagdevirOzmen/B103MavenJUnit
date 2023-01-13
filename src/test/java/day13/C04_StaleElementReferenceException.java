package day13;
/*
Stale Element means the element is no longer fresh. It is old and no longer available
When the element is no longer fresh on the page and you try to use it
When the element is detached from the DOM
When the element is removed after session started
Solution:
Relocate the same element again. You can use a new variable name as well.
 */

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C04_StaleElementReferenceException extends TestBase {
    /*
    StaleElementReferenceException:
    Stale element demek eleman eski, kullanilamaz durumda,kullanima artik elverisli degil demektir.
    -Sayfayi yenilediginizde yani refresh yapildiginda olur
    -Sayfada ileri geri gittigimizde olur(-Sayfada back() veya forward() yaparsak)
    Cozum:
    Elementi tekrar bulmak

     */

    @Test
    public void staleElementReferenceExceptionTest1() {
        driver.get("https://www.techproeducation.com");
        waitFor(5);

        //LMS LOGIN linkine tikla ve o sayfanin URL'inin lms icerdigini test et
        WebElement lmsLoginLink = driver.findElement(By.linkText("LMS LOGIN"));
        waitFor(5);
        lmsLoginLink.click();
        Assert.assertTrue(driver.getCurrentUrl().contains("lms"));
        waitFor(5);

        //Tekrar anasayfaya gel ve LMS LOGIN sayfasina tekrar git.
        driver.navigate().back();//tekrar anasayfaya gittik
        waitFor(5);
        lmsLoginLink.click();//LMS'e git
    }

    @Test
    public void staleElementReferenceExceptionTest2() {
        driver.get("https://www.techproeducation.com");
        waitFor(5);
        WebElement lmsLoginLink = driver.findElement(By.linkText("LMS LOGIN"));
        waitFor(5);
        driver.navigate().refresh();
        waitFor(5);
        lmsLoginLink.click();//Sayfayi buldugum elementi sayfa yenilendikten sonra kullanmak istedim
        //org.openqa.selenium.StaleElementReferenceException

    }
}
