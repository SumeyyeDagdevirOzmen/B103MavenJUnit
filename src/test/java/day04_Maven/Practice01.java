package day04_Maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Practice01 {
    static String ilkUrunText;
    static WebElement ilkUrun;
    WebElement sepetKontrol;

    public static void main(String[] args) {


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //1. "https://www.saucedemo.com" Adresine gidin
        driver.get("https://www.saucedemo.com");
        if (driver.getTitle().equalsIgnoreCase("Swag Labs")){
            System.out.println("Title Test i PASS");
        }else {
            System.out.println("Title Test i FAIL");
        }
        //2. Username kutusuna "standard_user" yazdirin
        driver.findElement(By.xpath("//*[@id='user-name']")).sendKeys("standard_user", Keys.ENTER);
        //3. Password kutusuna "secret_sauce" yazdirin
        driver.findElement(By.xpath("//*[@id='password']")).sendKeys("secret_sauce", Keys.ENTER);
        //4. Login tusuna basin
        driver.findElement(By.xpath("//*[@name='login-button']")).click();

        String basariliGiris=driver.findElement(By.xpath("(//div[@class='header_secondary_container'])//span")).getText();
        if (basariliGiris.equalsIgnoreCase("Products")){
            System.out.println("Basarili giris testi PASS");
        }else {
            System.out.println("Basarili giris testi FAİL");
        }
        //5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
        WebElement ilkUrunIsmi =driver.findElement(By.className("inventory_item_name"));
        String urunIsmi2=ilkUrunIsmi.getText();
        System.out.println(urunIsmi2);
        ilkUrunIsmi.click();
             //   driver.findElement(By.className("inventory_item_img"));
        //6. Add to Cart butonuna basin
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        //7. Alisveris sepetine tiklayin
        driver.findElement(By.xpath("//span")).click();
        if (driver.getCurrentUrl().contains("cart")){
            System.out.println("Sepet Page Goruntuleme Testi PASS");
        }else {
            System.out.println("Sepet Page Goruntuleme Testi FAIL");
        }
        //8. Sectiginiz urunun basarili olarak sepete eklendigini control edin


        WebElement actualUrunName = driver.findElement(By.xpath("//*[text()='Sauce Labs Backpack']"));
        String sonuc = actualUrunName.getText().equals(urunIsmi2) ? "The process of buying PASSED" : "The process of buying FAILED";
        System.out.println(sonuc);
       //9. Sayfayi kapatin
        driver.quit();
        //Not:class seviyesinde oluşturduğunuz static bir String değer ile
        // 5.step ve 8.step de titledan gelecek String değerleri validate etmenizi bekliyoruz. (edited)
    }
}
