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
import java.util.List;

public class C09_Dropdown {
    /*
    Bir class oluşturun: DropDown

            https://the-internet.herokuapp.com/dropdown adresine gidin.
            1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
            2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
            3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
            4.Tüm dropdown değerleri(value) yazdırın
            5. Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse False yazdırın.

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
        driver.get("https://the-internet.herokuapp.com/dropdown");
        WebElement option1=driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select select = new Select(option1);
        select.selectByIndex(1);
        System.out.println(select.getFirstSelectedOption().getText());

        //2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
        select.selectByValue("2");
        System.out.println(select.getFirstSelectedOption().getText());

        // 3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        select.selectByVisibleText("Option 1");
        System.out.println(select.getFirstSelectedOption().getText());

        //4.Tüm dropdown değerleri(value) yazdırın
        List<WebElement> allOptions = select.getOptions();
        for(WebElement w:allOptions){
            System.out.println(w.getText());
        }
        //  5. Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse False yazdırın.
        int actualSize = allOptions.size();
        Assert.assertFalse(actualSize>4);
        String result = actualSize==4 ? "true" : "false";
        System.out.println(result);

    }
    @After
    public void tearDown(){
      driver.close();
    }

}