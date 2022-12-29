package seleniumstudyctechproquestions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class C03_Maven {
    //1. "https://www.saucedemo.com" Adresine gidin
//2. Username kutusuna "standard_user" yazdirin
//3. Password kutusuna "secret_sauce" yazdirin
//4. Login tusuna basin
//5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
//6. Add to Cart butonuna basin
//7. Alisveris sepetine tiklayin
//8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
//9. Sayfayi kapatin
   // Not:class seviyesinde oluşturduğunuz
    // static bir String değer ile 5.step ve 8.step de titledan gelecek String değerleri validate etmenizi bekliyoruz.
    //***********************************************************************************************************
    //Arkadaşlar çözüme Title testi gibi ,yönlendirildiğiniz sayfanın doğru olup-olmadığının testi gibi ,eklemeler yaptım.
    // Bunu alışkanlık haline getirmelisiniz böyle şeyler taskler de belirtilmez ama yapmanız gerekir.
    static WebDriver driver;
    static String ilkUrunText;
    static WebElement ilkUrun;
    WebElement sepetKontrol;
    public static void main(String[] args) {

        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1. “https://www.saucedemo.com” Adresine gidin
        driver.get("https://www.saucedemo.com");
        if (driver.getTitle().equalsIgnoreCase("Swag Labs")){
            System.out.println("Title Test i PASS");
        }else {
            System.out.println("Title Test i FAIL");
        }
        //2. Username kutusuna “standard_user” yazdirin
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        //3. Password kutusuna “secret_sauce” yazdirin
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
        //4. Login tusuna basin
        driver.findElement(By.xpath("//input[@id='login-button']")).click();

        String basariliGiris=driver.findElement(By.xpath("(//div[@class='header_secondary_container'])//span")).getText();

        if (basariliGiris.equalsIgnoreCase("Products")){
            System.out.println("Basarili giris testi PASS");
        }else {
            System.out.println("Basarili giris testi FAİL");
        }
        //5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin

        ilkUrunText=driver.findElement(By.xpath("//div[@class='inventory_item_name'][1]")).getText();
        driver.findElement(By.xpath("//div[@class='inventory_item_name'][1]")).click();
        //6. Add to Cart butonuna basin
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        //7. Alisveris sepetine tiklayin
        driver.findElement(By.className("shopping_cart_link")).click();
        if (driver.getCurrentUrl().contains("cart")){
            System.out.println("Sepet Page Goruntuleme Testi PASS");
        }else {
            System.out.println("Sepet Page Goruntuleme Testi FAIL");
        }
        //8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
        String sepetKontrol= driver.findElement(By.id("item_4_title_link")).getText();
        if (sepetKontrol.equalsIgnoreCase(ilkUrunText)){
            System.out.println("İlk ürün sepette TEST PASS");
        }else {
            System.out.println("İlk ürün sepette TEST FAİLED");
        }
        //9. Sayfayi kapatin
        driver.quit();
    }
}
