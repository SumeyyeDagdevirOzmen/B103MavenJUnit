package seleniumstudyctechproquestions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
/*
// go to url :http://demo.automationtesting.in/Alerts.html
 //"Alert with OK" butonuna tıklayın ve "click the button to display an  alert box:" 'a tıklayın
//Alert(I am an alert box!) konsolda yazdırın ve Alert'ü kabul edin.
  //"Alert with OK & Cancel" butonuna tıklayın ve"click the button to display a confirm box " butonuna tıklayın
  //Alert'ü kapatın
  //"Alert with Textbox" butonuna tıklayın ve "click the button to demonstrate the prompt box " butonuna tıklayın.
  //Açılan alert e 'TechProEducation' (Lütfen İsminizi girin).
  //Gönderdiğiniz metnin isminizi içerdiğini doğrulayın
 */
public class C10_Alert {
    WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void test01(){
        driver.get("http://demo.automationtesting.in/Alerts.html");
        //"Alert with OK" butonuna tıklayın ve "click the button to display an  alert box:" 'a tıklayın
        driver.findElement(By.xpath("//*[text()='Alert with OK ']")).click();
        driver.findElement(By.xpath("//*[@class='btn btn-danger']")).click();
        //    accept Alert(I am an alert box!) and print alert on console
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
        //"Alert with OK & Cancel" butonuna tıklayın ve"click the button to display a confirm box " butonuna tıklayın
        driver.findElement(By.xpath("//*[text()='Alert with OK & Cancel ']")).click();
        driver.findElement(By.xpath("//*[text()='click the button to display a confirm box ']")).click();
        //Alert'ü kapatın
        driver.switchTo().alert().dismiss();
        //"Alert with Textbox" butonuna tıklayın ve "click the button to demonstrate the prompt box " butonuna tıklayın.
        driver.findElement(By.xpath("//*[text()='Alert with Textbox ']")).click();
        driver.findElement(By.xpath("//*[text()='click the button to demonstrate the prompt box ']")).click();
        driver.switchTo().alert().sendKeys("Sumeyye");
        driver.switchTo().alert().accept();
        WebElement AA =driver.findElement(By.xpath("//p[@id='demo1']"));
        String actual = AA.getText();
        System.out.println(actual);
        String beklenen = "Sumeyye";
        Assert.assertTrue(actual.contains(beklenen));
    }


}
