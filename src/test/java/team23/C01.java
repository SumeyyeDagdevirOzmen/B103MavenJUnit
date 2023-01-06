package team23;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01 {
                //1. Launch browser
            //2. Navigate to url 'http://automationexercise.com'
            //3. Verify that home page is visible successfully
            //4. Click on 'Signup / Login' button
            //5. Verify 'New User Signup!' is visible
            //6. Enter name and email address
            //7. Click 'Signup' button
            //8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
            //9. Fill details: Title, Name, Email, Password, Date of birth
            //10. Select checkbox 'Sign up for our newsletter!'
            //11. Select checkbox 'Receive special offers from our partners!'
            //12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
            //13. Click 'Create Account button'
            //14. Verify that 'ACCOUNT CREATED!' is visible
            //15. Click 'Continue' button
            //16. Verify that 'Logged in as username' is visible
            //17. Click 'Delete Account' button
            //18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
    WebDriver driver;
    //    Eger test sinifinda birden fazla method olusturulmussa, @Before kullanir
    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
    @Test
    public void test1() throws InterruptedException {
        Faker fake = new Faker();
        String email = fake.internet().emailAddress();
        driver.get("https://automationexercise.com/");
        WebElement logoName = driver.findElement(By.xpath("//*[@alt='Website for automation practice']"));
        Assert.assertTrue(logoName.isDisplayed());
        driver.findElement(By.xpath("//a[.=' Signup / Login']")).click();
        WebElement visibleText = driver.findElement(By.xpath("//*[text()='New User Signup!']"));
        Assert.assertTrue(visibleText.isDisplayed());
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("tlg", Keys.TAB, email,
                Keys.TAB, Keys.SPACE);
        Thread.sleep(2000);
        WebElement actualText = driver.findElement(By.xpath("//*[text()='Enter Account Information']"));
        Assert.assertTrue(actualText.isDisplayed());
        Thread.sleep(2000);
        WebElement information = driver.findElement(By.xpath("//*[@id='id_gender2']"));
        information.click();
        information.sendKeys(Keys.TAB, Keys.TAB, "12345", Keys.TAB, "20", Keys.TAB, "April", Keys.TAB, "2020",
                Keys.TAB, Keys.SPACE, Keys.TAB, Keys.SPACE, Keys.TAB, "tlg", Keys.TAB, "er", Keys.TAB, "tech", Keys.TAB,
                "adres", Keys.TAB, "adres2", Keys.TAB, "Canada", Keys.TAB, "toronto", Keys.TAB, "city", Keys.TAB, "12340", Keys.TAB, "1496616",
                Keys.TAB, Keys.SPACE);
        Thread.sleep(2000);
        WebElement accountCreated = driver.findElement(By.xpath("//*[text()='Account Created!']"));
        Assert.assertTrue(accountCreated.isDisplayed());
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[text()='Continue']")).click();
        Thread.sleep(4000);
        driver.navigate().refresh();
        driver.findElement(By.xpath("//*[text()='Continue']")).click();
        Thread.sleep(2000);
        WebElement LoggedAccount = driver.findElement(By.xpath("//*[text()=' Logged in as ']"));
        Assert.assertTrue(LoggedAccount.isDisplayed());
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[text()=' Delete Account']")).click();
        WebElement deletedAccount = driver.findElement(By.xpath("//b"));
        Assert.assertTrue(deletedAccount.isDisplayed());
        driver.findElement(By.xpath("//*[@data-qa='continue-button']")).click();
    }
    @After
    public void tearDown() {
       driver.close();
    }
}

