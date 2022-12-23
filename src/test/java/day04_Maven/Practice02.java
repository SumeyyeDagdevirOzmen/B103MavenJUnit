package day04_Maven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Practice02 {

    static String ilkUrunText;
    static WebElement ilkUrun;
    WebElement sepetKontrol;
    public static void main(String[] args) {

        WebDriver driver= new ChromeDriver();
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
/*
 public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


//        2- https://www.google.com/ adresine gidin
        driver.get("https://www.google.com/");
//        3- cookies uyarisini kabul ederek kapatin
//        4Sayfa basliginin "Google" ifadesi icerdigini test edin
        WebElement baslik = driver.findElement(By.xpath("//*[@class='lnXdpd']"));
        if (baslik.isDisplayed()) {
            System.out.println("Passed");
        } else System.out.println("Failed");

//        5Arama cubuguna "Nutella" yazip aratin
        driver.findElement(By.xpath("//*[@class='gLFyf']")).sendKeys("Nutella", Keys.ENTER);
//        6Bulunan sonuc sayisini yazdirin
        List<WebElement> sonucSayisi = driver.findElements(By.xpath("//*[@id='result-stats']"));
        for (WebElement w : sonucSayisi) {
            System.out.println(w.getText());
        }
//        7sonuc sayisinin 10 milyon'dan fazla oldugunu test edin
        String[] sonuc = sonucSayisi.get(0).getText().split(" ");
        System.out.println(sonuc[1]);
        String sonucReal = sonuc[1].toString();
        String sayi = sonucReal.replaceAll("\\p{Punct}", "");
        System.out.println("sayi =" + sayi);
        int num = Integer.valueOf(sayi);
        if (num > 10000000) {
            System.out.println("Passed");
        } else System.out.println("Failed");


        //8Sayfayi kapatin
        driver.close();

    }
}
 */
