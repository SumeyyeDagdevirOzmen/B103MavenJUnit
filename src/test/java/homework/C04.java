package homework;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C04 extends TestBase {

    /*
        Bir Class olusturalim KeyboardActions2
        https://html.com/tags/iframe/ sayfasina gidelim
        video’yu gorecek kadar asagi inin
        videoyu izlemek icin Play tusuna basin
        videoyu calistirdiginizi test edin
     */

    @Test
    public void keyboardActionsTest() {
        driver.get(" https://html.com/tags/iframe/");

        //  video’yu gorecek kadar asagi inin
        Actions action = new Actions(driver);
        action.sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ARROW_DOWN)
                .build()
                .perform();

        // videoyu izlemek icin Play tusuna basin
        WebElement iframe = driver.findElement(By.xpath("(//iframe[@frameborder='0'])"));
        driver.switchTo().frame(iframe);
        WebElement playButton = driver.findElement(By.xpath("//button[@aria-label='Play']"));
        playButton.click();

        // videoyu calistirdiginizi test edin
        Assert.assertTrue(driver.findElement(By.xpath("//video[@class='video-stream html5-main-video']")).isDisplayed());


    }
}
