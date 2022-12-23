package day05_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class Practice01 {
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://outlook.live.com/owa/");
    }

    @After
    public void tearnDown() throws InterruptedException {
        driver.close();
    }

    @Test
    public void test() throws InterruptedException {

        //3. Sign in butonuna basalim
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//*[@class='internal sign-in-link'])[2]")).click();

        //4. Email kutusuna @isareti olmayan bir mail yazip enter'a
        //bastigimizda "Invalid email address" uyarisi ciktigini test edelim

        WebElement gmail= driver.findElement(By.id("i0116"));
        gmail.sendKeys("Batch103", Keys.ENTER);

        WebElement uyari=  driver.findElement(By.xpath("//*[@id='usernameError']"));
        String expectedUyari= "Bu ada sahip bir Microsoft hesabı yok. Başka bir hesap girin ya da yeni bir hesap alın.";
        String actualUyari= uyari.getText();

        Assert.assertTrue(actualUyari.equals(expectedUyari));


    }
}