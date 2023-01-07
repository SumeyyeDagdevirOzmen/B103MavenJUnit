package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public abstract class  TestBase {
    //TestBase i abstract yapmamizin sebebi bu sinifin objesini olustirmak istemiyorum.
    //TestBase testBase = new TestBase(); -> YAPILAMAZ
    //Amacim bu sinifi extend etmek ve icindeki hazir methodlari kullanmak.
    //driver objesini olustur.Driver ya public ya da protected olmali .
    // Sebebi child classlarda kullanilabilmesi icin.
    // Sebepi child classlarda gorulebilir olmasi
    protected static WebDriver driver;

    // setUp
    @Before
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    //tearDown
    @After
    public void tearDown() {
        waitFor(5);
       // driver.quit();
    }

    //    MULTIPLE WINDOW
    //1 parametre alir:gecis yapmak istedigim sayfanin title'i
    //Ornek:
    // driver.get("https://the-internet.herokuapp.com/windows");
    // switchToWindow("New Window");
    //switchToWindow("The Internet  ")
    public static void switchToWindow(String targetTitle) {
        String origin = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
            if (driver.getTitle().equals(targetTitle)) {
                return;//cik loop yapmayi birak break gibi.
            }
        }
        driver.switchTo().window(origin);
    }

    //windowNumber sıfır (0)'dan başlıyor.
    // index numarasini parametre olarak alir
    //Veo indexli pencereye gecis yapar
    public static void switchToWindow(int windowNumber){
        List<String> list = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(list.get(windowNumber));
    }

    /*   HARD WAIT:
    @param : second
*/
    public static void waitFor(int seconds){
        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


/*
public static void clickOutside() {
    Actions action = new Actions(driver);
    action.moveByOffset(0, 0).click().build().perform();
}
 */