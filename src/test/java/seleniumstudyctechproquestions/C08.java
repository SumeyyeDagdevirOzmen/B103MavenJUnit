package seleniumstudyctechproquestions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C08 {

        /*
        1-https://rahulshettyacademy.com/AutomationPractice/ adresine gidin
        2-Dropdown Example menüsünün görünür olduğunu doğrulayın.
        3-Option3 ü seçin.
        4-Option3 ün seçili olduğunu doğrulayın.
        */
        static WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void test01(){
        // 1-https://rahulshettyacademy.com/AutomationPractice/ adresine gidin
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        //2-Dropdown Example menüsünün görünür olduğunu doğrulayın.
        WebElement dropdownMenu = driver.findElement(By.xpath("//*[text()='Dropdown Example']"));
        Assert.assertTrue(dropdownMenu.isDisplayed());

        //  3-Option3 ü seçin.
       WebElement options= driver.findElement(By.xpath("//select[@id='dropdown-class-example']"));
        Select select = new Select(options);
        select.selectByVisibleText("Option3");
        //   4-Option3 ün seçili olduğunu doğrulayın.
        String actualText = select.getFirstSelectedOption().getText();
        Assert.assertTrue(actualText.contains("Option3"));

    }
    @After
    public void tearDown(){
        driver.close();
    }

}
