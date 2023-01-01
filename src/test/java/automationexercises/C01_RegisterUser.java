package automationexercises;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.hc.core5.http.message.LineFormatter;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C01_RegisterUser {
 /*
    1. Launch browser
    2. Navigate to url 'http://automationexercise.com'
    3. Verify that home page is visible successfully
    4. Click on 'Signup / Login' button
    5. Verify 'New User Signup!' is visible
    6. Enter name and email address
    7. Click 'Signup' button
    8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
    9. Fill details: Title, Name, Email, Password, Date of birth
    10. Select checkbox 'Sign up for our newsletter!'
    11. Select checkbox 'Receive special offers from our partners!'
    12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
    13. Click 'Create Account button'
    14. Verify that 'ACCOUNT CREATED!' is visible
    15. Click 'Continue' button
    16. Verify that 'Logged in as username' is visible
    17. Click 'Delete Account' button
    18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
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
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("https://automationexercise.com/");

        //3. Verify that home page is visible successfully
        WebElement logoName= driver.findElement(By.xpath("//*[@alt='Website for automation practice']"));
        Assert.assertTrue(logoName.isDisplayed());

        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//a[.=' Signup / Login']")).click();

        //5. Verify 'New User Signup!' is visible
        WebElement visibleText= driver.findElement(By.xpath("//*[text()='New User Signup!']"));
        Assert.assertTrue(visibleText.isDisplayed());

        //6. Enter name and email address
        //7. Click 'Signup' button
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Sumeyye", Keys.TAB,"edup8@gmail.com",
                Keys.TAB,Keys.SPACE);

        //8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        WebElement actualText = driver.findElement(By.xpath("//*[text()='Enter Account Information']"));
        Assert.assertTrue(actualText.isDisplayed());

        //9. Fill details: Title, Name, Email, Password, Date of birth
        //10. Select checkbox 'Sign up for our newsletter!'
        //11. Select checkbox 'Receive special offers from our partners!'
        //12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        //13. Click 'Create Account button'
        WebElement information = driver.findElement(By.xpath("//*[@id='id_gender2']"));
        information.click();
        information.sendKeys(Keys.TAB,Keys.TAB,"12345",Keys.TAB,"20",Keys.TAB,"April",Keys.TAB,"2020",
                Keys.TAB,Keys.SPACE,Keys.TAB,Keys.SPACE,Keys.TAB,"Sumeyye",Keys.TAB,"ozmen",Keys.TAB,"tech",Keys.TAB,
                "adres",Keys.TAB,"adres2",Keys.TAB,"Canada",Keys.TAB,"toronto",Keys.TAB,"city",Keys.TAB,"12340",Keys.TAB,"1496616",
                Keys.TAB,Keys.SPACE);

        //14. Verify that 'ACCOUNT CREATED!' is visible
        WebElement accountCreated=driver.findElement(By.xpath("//*[text()='Account Created!']"));
        Assert.assertTrue(accountCreated.isDisplayed());

        //15. Click 'Continue' button
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[text()='Continue']")).click();


        //16. Verify that 'Logged in as username' is visible
        WebElement LoggedAccount = driver.findElement(By.xpath("//*[text()=' Logged in as ']"));
        Assert.assertTrue(LoggedAccount.isDisplayed());
        Thread.sleep(3000);

        //    17. Click 'Delete Account' button
        driver.findElement(By.xpath("//*[text()=' Delete Account']")).click();
        Thread.sleep(3000);

        //    18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
        WebElement deletedAccount= driver.findElement(By.xpath("//b"));
        Assert.assertTrue(deletedAccount.isDisplayed());
        driver.findElement(By.xpath("//*[@data-qa='continue-button']")).click();

    }

    @After
    public void tearDown()  {
        driver.close();
    }
}


