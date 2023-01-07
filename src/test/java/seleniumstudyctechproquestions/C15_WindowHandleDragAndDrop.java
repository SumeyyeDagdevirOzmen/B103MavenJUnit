package seleniumstudyctechproquestions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C15_WindowHandleDragAndDrop extends TestBase {

    /*
     #go to url : http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html
    #Fill in capitals by country
   */
      /*
       #url'ye gidin: http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html
      #Ülkeye göre başkentleri doldurun
     */

    WebElement city, country;
    @Test
    public void dragAndDropTest() {


        // #go to url : http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html
        driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
//        for(int i =1 ; i<8 ; i++){
//            WebElement source = driver.findElement(By.id("box"+i));
//            WebElement target = driver.findElement(By.id("box"+(100+i)));
//            Actions actions = new Actions(driver);
//            actions.dragAndDrop(source,target).release().build().perform();
//        }

        Actions actions = new Actions(driver);
        // #go to url : http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html
        driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
        // #Fill in capitals by country
        WebElement cities = driver.findElement(By.id("dropContent"));
        String[] arrCity = cities.getText().split("\n");
        for (int i = 1; i <= arrCity.length; i++) {
            city = driver.findElement(By.id("box" + i));
            country = driver.findElement(By.id("box" + (100+i)));
            actions.dragAndDrop(city, country).release().build().perform();

        }

   /*
         Actions actions = new Actions(driver);
          //#Fill in capitals by country
       WebElement sourceOslo= driver.findElement(By.id("box1"));
       WebElement targetNorway= driver.findElement(By.id("box101"));
       actions.dragAndDrop(sourceOslo,targetNorway).perform();

        WebElement sourceStockholm= driver.findElement(By.id("box2"));
        WebElement targetSweden= driver.findElement(By.id("box102"));
        actions.dragAndDrop(sourceStockholm,targetSweden).perform();

        WebElement sourceWashington= driver.findElement(By.id("box3"));
        WebElement targetUs= driver.findElement(By.id("box103"));
        actions.dragAndDrop(sourceWashington,targetUs).perform();

        WebElement sourceCopenhagen= driver.findElement(By.id("box4"));
        WebElement targetDenmark= driver.findElement(By.id("box104"));
        actions.dragAndDrop(sourceCopenhagen,targetDenmark).perform();

        WebElement sourceSeul= driver.findElement(By.id("box5"));
        WebElement targetSouthKorea= driver.findElement(By.id("box105"));
        actions.dragAndDrop(sourceSeul,targetSouthKorea).perform();

        WebElement sourceRomeo= driver.findElement(By.id("box6"));
        WebElement targetItaly= driver.findElement(By.id("box106"));
        actions.dragAndDrop(sourceRomeo,targetItaly).perform();

        WebElement sourceMadrid= driver.findElement(By.id("box7"));
        WebElement targetSpain= driver.findElement(By.id("box107"));
        actions.dragAndDrop(sourceMadrid,targetSpain).perform();

    */
    }
}
