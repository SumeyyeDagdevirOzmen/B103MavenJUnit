package automationexercises;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_LoginCorrectEmailPassword {
    /*
    1. Launch browser
    2. Navigate to url 'http://automationexercise.com'
    3. Verify that home page is visible successfully
    4. Click on 'Signup / Login' button
    5. Verify 'Login to your account' is visible
    6. Enter correct email address and password
    7. Click 'login' button
    8. Verify that 'Logged in as username' is visible
    9. Click 'Delete Account' button
    10. Verify that 'ACCOUNT DELETED!' is visible
     */
    WebDriver driver;
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @Test
    public void test01() throws InterruptedException {
        //2. 'http://automationexercise.com' URL'sine gidin
        driver.get("http://automationexercise.com");
        //3. Ana sayfanın başarıyla göründüğünü doğrulayın
        WebElement w= driver.findElement(By.xpath("//*[@src='/static/images/home/logo.png']"));
        Assert.assertTrue(w.isDisplayed());
        //4. 'Kaydol / Giriş Yap' düğmesine tıklayın
        driver.findElement(By.xpath(" //*[text()=' Signup / Login']")).click();
        //5. "Hesabınıza giriş yapın"ın göründüğünü doğrulayın
        WebElement w1=driver.findElement(By.xpath("//*[text()='Login to your account']"));
        Assert.assertTrue(w1.isDisplayed());
        Thread.sleep(2000);
        //6. Doğru e-posta adresini ve şifreyi girin
        driver.findElement(By.xpath("(//*[@type='email'])[1]")).sendKeys("dagdevir@gmail.com",
                Keys.TAB,"12345678",Keys.TAB,Keys.ENTER);
        //7. 'Giriş' düğmesine tıklayın
        //8. "Kullanıcı adı olarak oturum açıldı" ifadesinin görünür olduğunu doğrulayın
        WebElement w2=driver.findElement(By.xpath("//*[text()=' Logged in as ']"));
        Assert.assertTrue(w2.isDisplayed());
        //9. 'Hesabı Sil' düğmesini tıklayın
        driver.findElement(By.xpath("//*[@href='/delete_account']")).click();
        //10. 'HESAP SİLİNDİ!' görünür
        Assert.assertTrue(driver.findElement(By.xpath("//b[.='Account Deleted!']")).isDisplayed());
    }
}


