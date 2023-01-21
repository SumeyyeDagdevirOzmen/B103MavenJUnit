package team23;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.Random;

public class C15_Homework extends TestBase {

    //https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html adresine gidelim
    //Hesap makinasından 2 basamaklı random iki tane sayı seçelim ve random 4 işlemden birini yaptıralım
    //Sonucu konsola yazdırıp
    //Sonucun doğrulamasını yapalım

    @Test
    public void test01() {
        //https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html adresine gidelim
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html");

        //Hesap makinasından 2 basamaklı random iki tane sayı seçelim ve random 4 işlemden birini yaptıralım

        //Sonucu konsola yazdırıp
        //Sonucun doğrulamasını yapalım
        Random rand = new Random();
        int num1 = rand.nextInt(90) + 10; //generate random number between 10-99
        int num2 = rand.nextInt(90) + 10; //generate random number between 10-99
        int operation = rand.nextInt(4); //generate random number between 0-3

        WebElement num1Field = driver.findElement(By.xpath("//div[@class='screen']"));
        num1Field.click();
        Actions actions = new Actions(driver);
        actions.sendKeys(Integer.toString(num1)).click().perform();

//
       WebElement num2Field = driver.findElement(By.xpath("//span[@class='btn btn-outline-primary']"));
       actions.click(num2Field).sendKeys(Integer.toString(num2)).click().perform();

        //actions.sendKeys(Integer.toString(num2)).click().perform();

        WebElement operationBtn;
        switch (operation) {
            case 0:
                operationBtn = driver.findElement(By.xpath("//span[.='+']"));
                break;
            case 1:
                operationBtn = driver.findElement(By.xpath("//span[.='-']"));
                break;
            case 2:
                operationBtn = driver.findElement(By.xpath("//span[.='÷']"));
                break;
            case 3:
                operationBtn = driver.findElement(By.xpath("//span[.='x']"));
                break;
            default:
                operationBtn = null;
                break;
        }
        operationBtn.click();
        WebElement result = driver.findElement(By.xpath("//div[@class='screen']"));
        int resultNum = Integer.parseInt(result.getText());
        System.out.println("Result: " + resultNum);
//
        int expectedResult;
        switch (operation) {
            case 0:
                expectedResult = num1 + num2;
                break;
            case 1:
                expectedResult = num1 - num2;
                break;
            case 2:
                expectedResult = num1 * num2;
                break;
            case 3:
                expectedResult = num1 / num2;
                break;
            default:
                expectedResult = 0;
                break;
        }

        String expresult2 = Integer.valueOf(expectedResult).toString();
        String actualResultNUm= Integer.valueOf(resultNum).toString();
        Assert.assertEquals(expresult2,actualResultNUm);
//        if (resultNum == expectedResult) {
//            System.out.println("Result is correct");
//        } else {
//            System.out.println("Result is incorrect");
//        }

    }
    }
