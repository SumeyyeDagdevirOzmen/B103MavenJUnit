package day10;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C04_Actions4 extends TestBase {
    @Test
    public void dragAndDropTest() {
        //Class: Action4
        // EN FAZLA SURUKLEMEK ICIN KULLANILAN METHOD BUDUR
        //Method: dragAndDropTest
        //Given user is on https://jqueryui.com/droppable/
        driver.get("https://jqueryui.com/droppable/");
        //Kaynak ve hedef elementleri Iframe'in icinde ve iframe'in icine girmemiz gerekiyor.
        driver.switchTo().frame(0);
        //And user moves the target element(Drag me to my target) in to  destination(Drop here)
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));

        //drag and drop surukleme islemini gerceklestirir.
        Actions actions = new Actions(driver);
        actions.dragAndDrop(source, target).perform();
    }

    @Test
    public void clickAndHoldTest() {
        //Given user is on https://jqueryui.com/droppable/
        driver.get("https://jqueryui.com/droppable/");

        //Kaynak ve hedef elementleri Iframe'in icinde ve iframe'in icine girmemiz gerekiyor.
        driver.switchTo().frame(0);

        //And user moves the target element(Drag me to my target) in to  destination(Drop here)
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));

        //drag and drop surukleme islemini gerceklestirir.
        Actions actions = new Actions(driver);
        actions.clickAndHold(source)//kaynagi tut.
                .moveToElement(target)//hedefe koy
                .release()//Kaynagi birak
                .build()//onceki methodlarin iliskisini kur/guclendir. Kullanilmasi tercih edilir.
                .perform();//islemi gerceklestir

    }

    @Test
    public void moveByOffSetTest() {
        //Given user is on https://jqueryui.com/droppable/
        driver.get("https://jqueryui.com/droppable/");

        //Kaynak ve hedef elementleri Iframe'in icinde ve iframe'in icine girmemiz gerekiyor.
        driver.switchTo().frame(0);

        //And user moves the target element(Drag me to my target) in to  destination(Drop here)
        WebElement source = driver.findElement(By.id("draggable"));


        //drag and drop surukleme islemini gerceklestirir.
        Actions actions = new Actions(driver);
        actions
                .clickAndHold(source)//Kaynagi tut
                .moveByOffset(430, 30)
                .release()//kaynagi birak
                .build()
                .perform();

    }
}
