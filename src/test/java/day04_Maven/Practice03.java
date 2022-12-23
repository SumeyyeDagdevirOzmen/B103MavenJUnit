package day04_Maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Practice03 {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //    ~ Navigate to http://tutorialsninja.com/demo/index.php?route=common/home
        driver.get("http://tutorialsninja.com/demo/index.php?route=common/home");
        //    ~ click on Phones & PDAs
        driver.findElement(By.xpath("//a[text()='Phones & PDAs']")).click();

        //    ~ get the brandName of phones

        List<WebElement> brandNames=  driver.findElements(By.xpath("//h4"));
        for(WebElement w:brandNames){
            System.out.println(w.getText());
        }
        System.out.println("-------------------------------");

        //    ~ click on add to button for all elements
        List<WebElement> buttonForAllElements = driver.findElements(By.xpath("(//*[text()='Add to Cart'])"));
        for(WebElement w:buttonForAllElements){
            w.click();
        }

        //    ~ click on black total added cart button
        driver.findElement(By.id("cart-total")).click();

        //    ~ get the names of list from the cart
       List<WebElement> namesOfList = driver.findElements(By.xpath("//*[@class='text-left']"));
       for(WebElement w:namesOfList){
           System.out.println(w.getText());
       }

        //    ~ compare the names from displaying list and cart list
        if(brandNames.equals(namesOfList)){
            System.out.println("Test PASSED");
        }else System.out.println("Test FAILED");
       // close the driver
        Thread.sleep(3000);
        driver.close();
    }
}
