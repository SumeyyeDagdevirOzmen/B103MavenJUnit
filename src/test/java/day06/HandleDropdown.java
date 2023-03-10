package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class HandleDropdown {
    /*
             https://the-internet.herokuapp.com/dropdown adresine gidin.
        1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
        3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        4.Tüm dropdown değerleri(value) yazdırın
        5. Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse
        False yazdırın.
     */
    WebDriver driver;


    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.get("https://the-internet.herokuapp.com/dropdown");
    }
    @Test
    public void test01() {
        //1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        WebElement dropDown = driver.findElement(By.xpath("//*[@id='dropdown']"));
        Select dropDownList = new Select(dropDown);
        dropDownList.selectByIndex(1);
    }
        @Test
        public void test02() {
            //  2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
            WebElement dropDown = driver.findElement(By.xpath("//*[@id='dropdown']"));
            Select dropDownList = new Select(dropDown);
            dropDownList.selectByValue("2");
            dropDownList.getFirstSelectedOption().getText();
            //dropDownList.selectByValue("Option2");

        }

    }


