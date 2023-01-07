package seleniumstudyctechproquestions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.List;
//go to web site : https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/
//maximize the web site
// ikinci emojiye tıklayın
// ikinci emoji altındaki tüm öğelere tıklayın
// ana iframe'e geri dön
//formu doldurun,(Formu istediğiniz metinlerle doldurun)
// uygula butonuna tıklayın

public class C10Iframe extends TestBase {

    @Test
    public void test() throws InterruptedException {
        //go to web site : https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/
        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ARROW_DOWN).perform();

        // ikinci emojiye tıklayın
        WebElement iframe=driver.findElement(By.xpath("(//iframe[@id='emoojis'])"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.xpath("(//span[@class='mdl-tabs__ripple-container mdl-js-ripple-effect'])[2]")).click();


        // ikinci emoji altındaki tüm öğelere tıklayın

        List<WebElement> allEmojies = driver.findElements(By.xpath("//*[@id='nature']//img"));
       for(WebElement element : allEmojies){
           element.click();
       }


        // ana iframe'e geri dön
        waitFor(4);
        driver.switchTo().defaultContent();

        //formu doldurun,(Formu istediğiniz metinlerle doldurun)
        driver.findElement(By.xpath("//input[@id='text']")).sendKeys("Sumeyyyeemoji", Keys.TAB,
                "Happy",Keys.TAB,"Spring",Keys.TAB,"Strawberry",Keys.TAB,"Fun",Keys.TAB,"LondonEye",Keys.TAB,"object",Keys.TAB,":)))))",
                Keys.TAB,"fluffy",Keys.TAB,";",Keys.TAB,":)",Keys.TAB);
        Thread.sleep(2000);

        // uygula butonuna tıklayın
        driver.findElement(By.id("send")).click();

    }
}

/*
    @Test
    public void iframeTest() throws InterruptedException {
        // ikinci emojiye tıklayın
        int size = driver.findElements(By.tagName("iframe")).size();
        System.out.println("Total iFrames : " + size);
        WebElement iframe=driver.findElement(By.xpath("(//iframe[@id='emoojis'])"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.xpath("(//span[@class='mdl-tabs__ripple-container mdl-js-ripple-effect'])[2]")).click();
        List<WebElement> emojis=driver.findElements(By.xpath("//*[@id=\"nature\"]/div/img"));
        emojis.stream().forEach(t->t.click());
        driver.switchTo().defaultContent();
        List<WebElement> forum=driver.findElements(By.xpath("(//input[@class='mdl-textfield__input'])"));
        List <String> inputTexts = new ArrayList<>(Arrays.asList("Hello World!", "Merhaba Javacanlar", "Turkey" ,"Kebab", "Java ile Hayat Cok Guzel", "İstanbul", "Adam" ,"58" , "34", "63", "63"));
        for (int i = 0; i <inputTexts.size() ; i++) {
            forum.get(i).sendKeys(inputTexts.get(i));
        }
        driver.findElement(By.id("send")).click();
    }
 */

/*

    @Test
        public void test01() {
            //go to web site : https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/
            driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");
            // ikinci emojiye tıklayın
//            WebElement iframe= driver.findElement(By.xpath("//iframe[@id='emoojis']"));
//           driver.switchTo().frame(iframe);
           driver.switchTo().frame(1);
           driver.findElement(By.xpath("(//span[@class='mdl-tabs__ripple-container mdl-js-ripple-effect'])[2]")).click();
            // ikinci emoji altındaki tüm öğelere tıklayın
            List<WebElement> alleEmoji= driver.findElements(By.xpath("//*[@id='nature']/div/img"));
            alleEmoji.stream().forEach(t->t.click());
            // ana iframe'e geri dön
            driver.switchTo().defaultContent();
            //formu doldurun,(Formu istediğiniz metinlerle doldurun)
            List<WebElement> form = driver.findElements(By.xpath("//input[@class='mdl-textfield__input']"));
            List<String> textler = new ArrayList<>(Arrays.asList("aa","bb","cc","dd","ee","ff","gg","hh","j","k","l"));
            for(int i=0 ; i<textler.size(); i++){
                form.get(i).sendKeys(textler.get(i));
            }
        // uygula butonuna tıklayın
            driver.findElement(By.xpath("//button[@id='send']")).click();
    }
 */