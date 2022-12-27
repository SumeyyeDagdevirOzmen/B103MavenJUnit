package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P07 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        // Navigate to website  https://testpages.herokuapp.com/styled/index.html
        driver.get("https://testpages.herokuapp.com/styled/index.html");
        // Under the  ORIGINAL CONTENTS click on Alerts
        driver.findElement(By.xpath("//*[@id='alerts']")).click();
        // print the URL
        String actualURL= driver.getCurrentUrl();
        System.out.println("Alerts Page URL = " + actualURL);
        // navigate back
        driver.navigate().back();
        // print the URL
        System.out.println("webPageCurrentUrl = " + driver.getCurrentUrl());
        // Click on Basic Ajax
        driver.findElement(By.xpath("//*[@id='basicajax']")).click();
        // print the URL
        System.out.println("Basic Ajax Url= "+driver.getCurrentUrl());
        // enter value-> 20 and Enter
        driver.findElement(By.id("lteq30")).sendKeys("20", Keys.ENTER);
        // and then verify Submitted Values is displayed open page
        WebElement submitText = driver.findElement(By.xpath("//p[text()='Submitted Values']"));
        Assert.assertTrue(submitText.isDisplayed());
        // close driver
        driver.close();
    }
}
