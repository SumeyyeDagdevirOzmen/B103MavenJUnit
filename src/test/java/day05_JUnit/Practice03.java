package day05_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Practice03 {

    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://tutorialsninja.com/demo/index.php?route=common/home");
    }

    @After
    public void tearnDown() throws InterruptedException {

        // driver.close();
    }

    @Test
    public void test() throws InterruptedException {

//    ~ click on Phones & PDAs
        driver.findElement(By.xpath("//*[text()='Phones & PDAs']")).click();

//    ~ get the brandName of phones
        List<String> list= new ArrayList<>();
        List<WebElement> phoneNames= driver.findElements(By.xpath("//h4"));
        for (WebElement w :phoneNames){
            list.add(w.getText()) ;
        }
        System.out.println("telefon marka isimileri : "+ list);


//    ~ click on add to button for all elements
        List <WebElement> addToCart= driver.findElements(By.xpath("(//*[text()='Add to Cart'])"));
        for (WebElement w: addToCart){
            w.click();
        }

//    ~ click on black total added cart button
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@class='btn btn-inverse btn-block btn-lg dropdown-toggle']")).click();

//    ~ get the names of list from the cart
        List <String> list2= new ArrayList<>();
        List<WebElement> listoftheCart =  driver.findElements(By.xpath("//*[@class='text-left']"));
        for (WebElement w: listoftheCart){
            list2.add(w.getText());
        }
        System.out.println(list2);

//    ~ compare the names from displaying list and cart list
        Assert.assertTrue(list.containsAll(list2));
    }
}








