package day14;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C02_ScreenShot2 extends TestBase {
    //Class : ScreenShot2
    //Techpro education a git
    //Sosyal medya elemanlarını goruntusunu al
    @Test
    public void ScreenShotOfSpecificElements() throws IOException {
        //Class : ScreenShot2
        //Techpro education a git
        driver.get("https://www.techproeducation.com");
        //Sosyal medya elemanlarının goruntusunu al
        //1. Ekran goruntusunu cek
        WebElement sosyalMedyaIconlari = driver.findElement(By.xpath("(//div[@class='elementor-social-icons-wrapper elementor-grid'])[1]"));
        File image = sosyalMedyaIconlari.getScreenshotAs(OutputType.FILE);
        //2.goruntuyu kaydet
        String currentTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
      //Path of screenshot save folder               folder / folder    /file name
        String path = System.getProperty("user.dir")+"/test-output/Screenshots/"+currentTime+"image.png";
        FileUtils.copyFile(image,new File(path));

        waitFor(3);
        //LOGO'nun ekran goruntusunu al
       takeScreenshotOfElement(driver.findElement(By.xpath("//*[@title='Online IT Courses']")));
    }
}
