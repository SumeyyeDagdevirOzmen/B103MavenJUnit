package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P09 {
    /*
       https://www.google.com/ adresine gidin
       cookies uyarisini kabul ederek kapatin
       Sayfa basliginin “Google” ifadesi icerdigini test edin
       Arama cubuguna “Nutella” yazip aratin
       Bulunan sonuc sayisini yazdirin
       sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
       Sayfayi kapatin
     */
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @Test
    public void test01(){
        //https://www.google.com/ adresine gidin
        driver.get("https://google.com");
        //cookies uyarisini kabul ederek kapatin
        driver.findElement(By.xpath("//*[text()='Accept all']")).click();
        //Sayfa basliginin “Google” ifadesi icerdigini test edin
        String actualTitle = driver.getTitle();
        String expectedTitle = "Google";
        Assert.assertTrue(actualTitle.contains(expectedTitle));
        //Arama cubuguna “Nutella” yazip aratin
        driver.findElement(By.xpath("//*[@class='gLFyf']")).sendKeys("Nutella", Keys.ENTER);
        //Bulunan sonuc sayisini yazdirin
        String [] sonucSayisi = driver.findElement(By.xpath("//*[@id='result-stats']")).getText().split(" ");
        String sonuc = sonucSayisi[1];
        System.out.println("Sonuc Sayısı = " +sonuc);
        //sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
        sonuc=sonuc.replaceAll("\\D",""); // ReplaceAll methodu ile \\D'i kullanarak bütün noktalama işaretlerini hiçlikle değiştir
        int istenenSayi = 10000000;
        Assert.assertTrue(Integer.parseInt(sonuc)>istenenSayi);
        //Sayfayi kapatin
        driver.close();
    }
    }



/*
//6- Bulunan sonuc sayisini yazdirin
String sonuc = driver.findElement(By.xpath("//*[@id='result-stats']")).getText();
String[] sonucSayisi = sonuc.split(" ");
Arrays.stream(sonucSayisi).limit(2).skip(1).forEach(t -> System.out.println("Arama Sonuc Sayisi = " + t));
 */
/*
//7- sonuc sayisinin 10 milyon'dan fazla oldugunu test edin
String sayi = sonucSayisi[1].replace(".", "");
int number = Integer.parseInt(sayi);
Assert.assertTrue(number>10000000);
 */

/*
String [] sonucYazisi=driver.findElement(By.id("result-stats")).getText().split(" ");
System.out.println("Sonuc Sayisi: "+sonucYazisi[1]);
int sonucSayisi = Integer.parseInt(sonucYazisi[1].replace(".", ""));
Assert.assertTrue(sonucSayisi>10000000);
 */