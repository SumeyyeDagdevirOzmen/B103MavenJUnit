package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P06 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //https://id.heroku.com/login sayfasina gidin
        driver.get("https://id.heroku.com/login ");
        //Bir mail adersi giriniz
        driver.findElement(By.xpath("//*[@id='onetrust-accept-btn-handler']")).click();//cookies

        driver.findElement(By.xpath("//*[@id='email']")).sendKeys("sumeyyedag@yahoo.com");
        //Bir password giriniz
        driver.findElement(By.xpath("//*[@id='password']")).sendKeys("1234567!");
        //Login butonuna tiklayiniz
        driver.findElement(By.xpath("//*[text()='Log In']")).click();
        //"There was a problem with your login." texti gorunur ise
        //"kayit yapilamadi" yazdiriniz
        //eger yazi gorunur degilse "kayit yapildi" yazdiriniz
        WebElement yazi = driver.findElement(By.xpath("//div[@class='alert alert-danger']"));
       String result= yazi.isDisplayed() ? "Kayit Yapilamadi" : "Kayit Yapildi";
        System.out.println(result);


        //sayfayı kapatiniz
        driver.close();
    }
}
