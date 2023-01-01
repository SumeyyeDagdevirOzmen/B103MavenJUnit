package day07;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C05_IFrame extends TestBase {

    @Test
    public void iframeTest(){
        driver.get("https://testcenter.techproeducation.com/index.php?page=iframe");
        /*
        Iframe nedir?
        https://testcenter.techproeducation.com/index.php?page=iframe
        Ana sayfadaki An iframe with a thin black border: metnin 'black border' yazisinin oldugunu test edelim
        Ayrica ‘Applications lists’ yazisinin sayfada oldugunu test edelim
        Son olarak footer daki ‘Powered By’ yazisini varligini test edilip

         */
        // Ana sayfadaki An iframe with a thin black border: metnin 'black border' yazisinin oldugunu test edelim
        String anaMetin = driver.findElement(By.xpath("//p[.='An iframe with a thin black border:']")).getText();
        //tag[.='metin'];Bana bu tagli metni ver
        ////tag[text()='metin'];
        String expectedText ="black border";
        Assert.assertTrue(anaMetin.contains(expectedText));

        //  Ayrica ‘Applications lists’ yazisinin sayfada oldugunu test edelim

        //Applications Lists elementi iframe in icinde. Iframe switch yapmam sart
        driver.switchTo().frame(0);//index 0 dan baslar. ilk iframe e switch yapiyoruz.

        String icMetin = driver.findElement(By.xpath("//h1[.='Applications lists']")).getText();
        String expectedText1="Applications lists";
        Assert.assertEquals(expectedText1,icMetin);

        //Son olarak footer daki ‘Powered By’ yazisini varligini test edilip

//        Alternatif olarak altdaki secenekler de kullanilabilir
//        Assert.assertTrue(expectedText1.contains(icMetin));
//        Assert.assertTrue(driver.findElement(By.xpath("//*[.='Applications lists']")).isDisplayed());


        //Anasayfadaki Povered by yazisini test etmek istiyorum ama driver hala ifarame'in icinde. Iframe'in disina cikmak icin
        //driver.switchTo().defaultContent()/parentFrame(); kullaniriz.
        driver.switchTo().defaultContent();
        String footerText = driver.findElement(By.xpath("(//footer[@class='blog-footer'][1])//p")).getText();// By.xpath("//p[text()='Povered By']") bunu da kullanabilirsin.
        System.out.println("footerText = " + footerText);
        Assert.assertTrue(footerText.contains("Povered By"));
    }

}
