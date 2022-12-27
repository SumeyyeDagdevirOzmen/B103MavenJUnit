package day05_JUnit;

import day06.C02_DropdownReusable;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class Practice06 {

    /* Given kullanici "https://editor.datatables.net/" sayfasina gider
    Then new butonuna basar
    And editor firstname kutusuna "<firstName>" bilgileri girer
    And editor lastname kutusuna "<lastName>" bilgileri girer
    And editor position kutusuna "<position>" bilgileri girer
    And editor office kutusuna "<office>" bilgileri girer
    And editor extension kutusuna "<extension>" bilgileri girer
    And editor startdate kutusuna "<startDate>" bilgileri girer
    And editor salary kutusuna "<salary>" bilgileri girer
    When Create tusuna basar
    Then Kullanıcının eklendiğini doğrular.
    And Eklediği kullanıcı kaydını siler
    Then Kullanıcinin silindiğini doğrular.
    */
    WebDriver driver;
    @Before
            public void setUp(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://editor.datatables.net/");
    }
    @Test
    public void test01() throws InterruptedException {
        //Then new butonuna basar
        driver.findElement(By.xpath("//*[@class='dt-button buttons-create']")).click();
       // And editor firstname kutusuna "<firstName>" bilgileri girer
        driver.findElement(By.xpath("//*[@id='DTE_Field_first_name']")).sendKeys("Kathy");
        // And editor lastname kutusuna "<lastName>" bilgileri girer
        driver.findElement(By.xpath("//*[@id='DTE_Field_last_name']")).sendKeys("Brown");
        // And editor position kutusuna "<position>" bilgileri girer
        driver.findElement(By.xpath("//*[@id='DTE_Field_position']")).sendKeys("IT Teacher");
        //    And editor office kutusuna "<office>" bilgileri girer
        driver.findElement(By.xpath("//*[@id='DTE_Field_office']")).sendKeys("London");
        //And editor extension kutusuna "<extension>" bilgileri girer
        driver.findElement(By.xpath("//*[@id='DTE_Field_extn']")).sendKeys("20");
        //And editor startdate kutusuna "<startDate>" bilgileri girer
        driver.findElement(By.xpath("//*[@id='DTE_Field_start_date']")).click();
        //year
        selectFromDropdown(driver.findElement(By.xpath("//select[@class='dt-datetime-year']")), "2008");
        //Month
        selectFromDropdown(driver.findElement(By.xpath("//select[@class='dt-datetime-month']")),"September");
        //day
        driver.findElement(By.xpath("//*[@class='selectable'][6]")).click();//06

        //And editor salary kutusuna "<salary>" bilgileri girer
        driver.findElement(By.xpath("//*[@id='DTE_Field_salary']")).sendKeys("600000");
        // When Create tusuna basar
        driver.findElement(By.xpath("//*[@class='btn']")).click();
        //Then Kullanıcının eklendiğini doğrular.
        driver.findElement(By.xpath("//*[@type='search']")).sendKeys("Kathy Brown");

        String actualName= driver.findElement(By.xpath("//*[@class='sorting_1']")).getText();
        String expectedName= "Kathy Brown";
        Assert.assertEquals(actualName, expectedName);
        Thread.sleep(2000);

       // And Eklediği kullanıcı kaydını siler
        driver.findElement(By.className("sorting_1")).click();
       driver.findElement(By.xpath("//span[text()='Delete']")).click();
        driver.findElement(By.xpath("//button[@class='btn']")).click();

        //    Then Kullanıcinin silindiğini doğrular.
       String actualKayit= driver.findElement(By.xpath("//*[@class='dataTables_empty']")).getText();
       String expectedKayit="No matching records found";
       Assert.assertEquals(actualKayit, expectedKayit);


       
    }
    @After
    public void tearDown(){

      driver.close();
    }


    public void selectFromDropdown(WebElement dropdown,String secenek) {
        List<WebElement> options =dropdown.findElements(By.tagName("option"));
        for(WebElement eachOption : options){
            if(eachOption.getText().equals(secenek)){
                eachOption.click();
                break;
            }
        }
    }

}
