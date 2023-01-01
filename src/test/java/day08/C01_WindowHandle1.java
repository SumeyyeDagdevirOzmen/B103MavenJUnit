package day08;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.util.Set;

public class C01_WindowHandle1 extends TestBase {
    /*
         ● Tests package’inda yeni bir class olusturun: WindowHandle2
        ● https://the-internet.herokuapp.com/windows adresine gidin.
        ● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        ● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        ● Click Here butonuna basın.
        ● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        ● Sayfadaki textin “New Window” olduğunu doğrulayın.
        ● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.
     */

    @Test
    public void handleWindowTest() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/windows");
        //ILK SAYFANIN ID SINI ALALIM
        String window1Handle = driver.getWindowHandle();

        //  ● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        String window1Text = driver.findElement(By.xpath("//h3")).getText();
        Assert.assertEquals("Opening a new window", window1Text);

        // ● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String window1Title = driver.getTitle();
        Assert.assertEquals("The Internet", window1Title);

        // ● Click Here butonuna basın.
        driver.findElement(By.linkText("Click Here")).click();
        Thread.sleep(3000);

        // ● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.

        //BU NOKTADA 2 PENCERE ACIK VE IKINCISINE GECIS YAPMAK ISTIYORUM.
        //BUNUN ICIN driver.getWindowHandles() ILE TUM PENCERELERIN IDLERINI ALALIM.
        Set<String> allWindowHandles = driver.getWindowHandles();//{window1handle , window2Handle}
        for (String eachHandle : allWindowHandles) {
            //eger listedeki id window1 e esit degilse, otomatik olarak (bir sonrakine) window2 ye esittir
            if (!eachHandle.equals(window1Handle)) {
                driver.switchTo().window(eachHandle);//Burdaki eachHandle window2 handle'ina esittir.
                break;
            }
        }
        //        BU NOKTADA DRIVER 2. PENCEREDE
        // Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        Assert.assertEquals("New Window", driver.getTitle());

       //Sayfadaki textin “New Window” olduğunu doğrulayın.
        String window2Text = driver.findElement(By.xpath("/h3")).getText();
        Assert.assertEquals("New Window", window2Text);
        String window2Handle = driver.getWindowHandle();

        //Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu  doğrulayın.
        Thread.sleep(3000);
        // 1. windowa gecis yapiyorum
        driver.switchTo().window(window1Handle);
        Assert.assertEquals("The Internet", driver.getTitle());
        Thread.sleep(3000);
        // 2.windowa tekrar gecelim.
        driver.switchTo().window(window2Handle);
        Thread.sleep(3000);
        //1.windowa tekrar gecelim.
        driver.switchTo().window(window1Handle);
    }
}


//Set<String> tumPencereler= driver.getWindowHandles();//buradan iki tane handle gelecek
//tumPencereler.stream().filter(t->!t.equals(handle1)).forEach(t->driver.switchTo().window(t));

//Bu şekilde List olarak alıp index le sekmelere geçiş yapsak
//ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
//driver.switchTo().window(tabs.get(1));