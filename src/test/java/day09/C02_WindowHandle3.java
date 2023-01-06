package day09;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class C02_WindowHandle3 extends TestBase {
    @Test
    public void newWindowHandleTest() {

        //1. TechPro education sayfasinin title'inin "Techpro Education" metnini icerdigini test edin.
        driver.get("https://www.techproeducation.com");
        String techProHandle = driver.getWindowHandle();
        Assert.assertTrue(driver.getTitle().contains("Techpro Education"));
        //2. Yeni bir pencerede Amazon sayfasini acip title'in "Amazon" metnini icerdigini test edin.
        waitFor(3);
        driver.switchTo().newWindow(WindowType.WINDOW);//1.yeni window olusturur. 2. Oraya gecis yapar
        driver.get("https://www.amazon.com");
        Assert.assertTrue(driver.getTitle().contains("Amazon"));

        //3. Yeni bir pencerede LinkedIn sayfasini acip title'in "LinkedIn" metnini icerdigini test edin.
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.linkedin.com");
        Assert.assertTrue(driver.getTitle().contains("LinkedIn"));

        waitFor(3);
        //DRIVER NERDE? LINKEDINDE
        //TECHPRO SAYFASINA GITMEK ICIN TEKRAR   driver.switchTo().window(techProHandle);
        driver.switchTo().window(techProHandle);
        waitFor(3);
        //Driver nerde? TechPro
        Assert.assertTrue(driver.getTitle().contains("Techpro Education"));
        waitFor(3);

    }



}