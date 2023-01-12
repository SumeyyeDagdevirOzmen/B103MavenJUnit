package team23;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.TestBase;

public class C09 extends TestBase {
    @Test
    public void whatshapTest(){
        //rehberinizdeki kayitli isim
        String isim = "sumeyye";
        String gondermekIstediginizMesaj = "Hi";
        String gondermekIstediginizMesaj2 = "Helloooo Friend!)";
        int kacTaneMesajAtmakIstiyorsunuz = 5;


        driver.get("https://web.whatsapp.com/");
        driver.findElement(By.xpath("//span[@data-testid='chat']")).click();
        driver.
                findElement(By.xpath("//div[@class='_1UWac _3hKpJ focused']//div[@title='Arama metni giriş alanı']")).
                sendKeys(isim+ Keys.TAB + Keys.ENTER);


        for (int i = 0; i < kacTaneMesajAtmakIstiyorsunuz; i++) {
            driver.findElement(By.xpath("//p[@class='selectable-text copyable-text']")).sendKeys(gondermekIstediginizMesaj + Keys.ENTER);

        }
        driver.findElement(By.xpath("//p[@class='selectable-text copyable-text']")).sendKeys("How is it going bro?)" + Keys.ENTER);
        waitFor(8);
        driver.findElement(By.xpath("//p[@class='selectable-text copyable-text']")).sendKeys("Hi! Everything is fine" + Keys.ENTER);
        for (int i = 0; i < kacTaneMesajAtmakIstiyorsunuz; i++) {
            driver.findElement(By.xpath("//p[@class='selectable-text copyable-text']")).sendKeys(gondermekIstediginizMesaj2 + Keys.ENTER);
        }
        driver.findElement(By.xpath("//p[@class='selectable-text copyable-text']")).sendKeys("Ok see you."+Keys.ENTER );
        driver.findElement(By.xpath("//p[@class='selectable-text copyable-text']")).sendKeys("See you later" + Keys.ENTER);


    }
}
