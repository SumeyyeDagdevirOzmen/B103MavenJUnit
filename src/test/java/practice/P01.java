package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P01 {
    //"amazon.com" adresine gidelim.
    //-Bu web adresinin basligini(title) ve adres(url)'ni  yazdiralim.
    //title ve url'nin "spend" kelimesni icerip icermedigini kontrol edelim.
    //-Ardindan "trendy.com" adresine gidelim
    //-bu adresin basligini alalim ve "Sitesi" kelismesini icerip icermedigini kontrol edelim
    //-Bi onceki web sayfamiza geri donelim
    //-sayfayi yenileyelim
    //-Daha sonra trendyol sayfamiza tekrar donelim ve sayfayi kapatalim

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //"amazon.com" adresine gidelim.
        driver.get("https://www.amazon.com/");

        //-bu web adresinin sayfa basligini(title) ve adres(url)ini yazdıralım
        String actualTitle = driver.getTitle();
        String actualUrl = driver.getCurrentUrl();
        System.out.println("Sayfa Başlığı : "+actualTitle);
        System.out.println("Sayfa Url'i : "+actualUrl);

        //-title ve url'nin "Spend" kelimesinin icerip icermedigini kontrol edelim
        Assert.assertFalse(actualTitle.contains("Spend") && actualUrl.contains("Spend"));

        //-Ardindan "trendyol.com" adresine gidelim
        driver.get("https://trendyol.com");

        //-bu adresin basligini alalim ve "Sitesi" kelismesini icerip icermedigini kontrol edelim
        String trendyolTitle = driver.getTitle();
        System.out.println("Trendyol title= "+trendyolTitle);
        Assert.assertFalse(trendyolTitle.contains("Sitesi"));

        //-Bi onceki web sayfamiza geri donelim
        driver.navigate().back();

        //-sayfayi yenileyelim
        Thread.sleep(2000);
        driver.navigate().refresh();

        //-Daha sonra trendyol sayfamiza tekrar donelim ve sayfayi kapatalim
        Thread.sleep(3000);
        driver.navigate().forward();
        driver.quit();// Birden fazla sayfada çalışılmış ise quit() methodu kullanılır
    }

}
