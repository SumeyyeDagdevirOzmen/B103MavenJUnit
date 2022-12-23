package day04_Maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Homework {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //C01_TekrarTesti isimli bir class olusturun
        // 2- https://www.google.com/ adresine gidin
        driver.get("https://www.google.com/");

        // 3- cookies uyarisini kabul ederek kapatin
        driver.findElement(By.xpath("//*[text()='Accept all']")).click();
        //4-Sayfa basliginin “Google” ifadesi icerdigini test edin

       String actualHeader =driver.getTitle();
        String expectedHeader ="Google";

       if((actualHeader.contains(expectedHeader))){
            System.out.println("Test PASSED");
        }else System.out.println("Test FAILED");

        //5-Arama cubuguna “Nutella” yazip aratin
        WebElement aramaMotoru =driver.findElement(By.xpath("//*[@class = 'gLFyf']"));
        aramaMotoru.sendKeys("nutella");
        aramaMotoru.submit();
        //6-Bulunan sonuc sayisini yazdirin
        WebElement sonucYazisi = driver.findElement(By.xpath("//*[@id='result-stats']"));
        System.out.println("sonucYazisi = " + sonucYazisi.getText());
        //7-sonuc sayisinin 10 milyon’dan fazla oldugunu test edin

        List<String> myList = new ArrayList<>(Arrays.asList(sonucYazisi.getText().split(" ")));
        System.out.println("Sonuc Sayisi : "+myList.get(1).replace(",",""));
        int sayi= Integer.parseInt(myList.get(1).replace(",",""));


        if(sayi>10000000){
            System.out.println("Test PASSED");
        }else System.out.println("Test FAILED");


        String[] list =sonucYazisi.getText().split(" ");
        System.out.println(Arrays.toString(list));

//        String result = Integer.parseInt(list[1].replace(",","")) > Integer.parseInt("10000000") ?
//                "Test PASSED" : "Test FAILED";
//        System.out.println("Sonuc 10 milyon'dan fazla mi? : " + result);

        //8-Sayfayi kapatin
           driver.close();
    }
}
