package team23;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class C11_ExplicitWait {
    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() throws Exception {

        driver.close();
    }

    @Test
    public void explicitWaitTest() throws InterruptedException {


        //1. Bir class olusturun : WaitTest
        //2. Iki tane metod olusturun : implicitWait() , explicitWait()
        //Iki metod icin de asagidaki adimlari test edin.
        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));


        //4. Remove butonuna basin.
        WebElement removeButton = driver.findElement(By.xpath("//button[text()='Remove']"));
        removeButton.click();
        //  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Remove']")));

        //5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
        Thread.sleep(3000);
        Assert.assertTrue(driver.findElement(By.xpath("//p[@id='message']")).isDisplayed());


        //6. Add buttonuna basin
        WebElement addButton = driver.findElement(By.xpath("//button[text()='Add']"));
        addButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Add']")));

        //7. It’s back mesajinin gorundugunu test edin
        Thread.sleep(3000);
        Assert.assertTrue(driver.findElement(By.xpath("//p[@id='message']")).isDisplayed());

    }
}

