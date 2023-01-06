package seleniumstudyctechproquestions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
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
        // ikinci emojiye tıklayın
        driver.switchTo().frame("emoojis");
        driver.findElement(By.xpath("(//span[@class='mdl-tabs__ripple-container mdl-js-ripple-effect'])[2]")).click();
        Thread.sleep(3000);

        // ikinci emoji altındaki tüm öğelere tıklayın

        List<WebElement> allEmojies = driver.findElements(By.xpath("//*[@class='mdl-tabs__panel is-active']//img"));

        for(WebElement element : allEmojies){
            element.click();
            break;
        }
        Thread.sleep(2000);

        // ana iframe'e geri dön
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