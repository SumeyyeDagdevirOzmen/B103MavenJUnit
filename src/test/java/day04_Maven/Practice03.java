package day04_Maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class Practice03 {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //    ~ Navigate to http://tutorialsninja.com/demo/index.php?route=common/home
        driver.get("http://tutorialsninja.com/demo/index.php?route=common/home");
        //    ~ click on Phones & PDAs
        driver.findElement(By.xpath("//a[text()='Phones & PDAs']")).click();

        //    ~ get the brandName of phones

        List<WebElement> brandName=  driver.findElements(By.xpath("//title"));
        for(WebElement w:brandName){
            System.out.println(w.getText());
        }


        //    ~ click on add to button for all elements
        //    ~ click on black total added cart button
        //    ~ get the names of list from the cart
        //    ~ compare the names from displaying list and cart list
        //
    }
}
