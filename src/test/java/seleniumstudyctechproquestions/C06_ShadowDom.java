package seleniumstudyctechproquestions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class C06_ShadowDom {
    /*
1-https://books-pwakit.appspot.com/ adresine gidin.
2-"BOOKS" başlığının görünür olduğunu doğrulayın
3-Arama çubuğunda "Selenium" u aratın.
4-Arama sonuçlarındaki ilk ürün isminin "Selenium" içerdiğini doğrulayın.
*/
    /*
    Soruyu çözmek için shadow hakkında kısa bir araştırma yapmanız gerekiyor.
    Shadow DOM “DOM içindeki bir DOM” olarak düşünebilirsiniz.
     Aslında bazı zamanlar UI otomasyonunu engellemek için kullanılıyor.
     Manuel ve API testleri yapmak durumunda kalıyoruz.Bu yapıyı da tecrübe etmiş olun diye paylaştım bu soruyu.




DOM : HTML’deki her bir elamanın birbiri ile hiyerarşik bir yapı oluşturması ile oluşan yapı.
(Bunu ağaç şeklinde iç içe dallanmış bir yapı olarak düşünebiliriz)
Shadow DOM: DOM elemanlarından içerisinde kapsül halinde gizli bir DOM Tree yapısını Styling ile birlikte enjekte edebilmenizi sağlar.
(Kısacası Shadow DOM Normal DOM’un içerisine element kapsüllemeye yarar.)
Biraz JavaScript bilmek gerekiyor çünkü;
JavaScript öğeleriyle tetiklenen bu yapıyı, yine JavaScript querySelector vs. gibi öğelerle çözmek mümkün (edited)
     */
    WebDriver driver;
    @Before
    public void setUp () {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://books-pwakit.appspot.com/");
    }
    @After
    public void tearDown (){ //driver.quit();
    }
    //1.yöntem getShadowRoot() + JavascriptExecutor ile
    @Test
    public void findShadowDOMWithoutSeleniumFindElement () throws InterruptedException {
        // Provide Access So The Driver Can Execute JavaScript
        JavascriptExecutor jsExecutor
                = (JavascriptExecutor) driver;
        // Execute JavaScript To Return A WebElement
        WebElement bookSearchField = (WebElement) jsExecutor.executeScript(
                "return document.querySelector(\"body > book-app\")." +
                        "shadowRoot.querySelector(\"#input\")");
        //"BOOKS" başlığının görünür olduğunu doğrulayın
        String cssSelectorForHost1 = "book-app[apptitle='BOOKS']";
        Thread.sleep(1000);
        SearchContext shadow = driver.findElement(By.cssSelector("book-app[apptitle='BOOKS']")).getShadowRoot();
        Thread.sleep(1000);
        System.out.println(shadow.findElement(By.cssSelector("a[href='/']")).getText());
        // Perform An Action On The WebElement
        bookSearchField.sendKeys("Seleinum"+ Keys.ENTER);
        // 4-Arama sonuçlarındaki ilk ürün isminin "Selenium" içerdiğini doğrulayın.
        String cssSelectorForHost11 = "book-app[apptitle='BOOKS']";
        String cssSelectorForHost22 = "book-explore[class='_page']";
        String cssSelectorForHost33 = " section:nth-child(2) > ul:nth-child(1) > li:nth-child(1) > book-item:nth-child(1)";
        Thread.sleep(1000);
        SearchContext shadow0 = driver.findElement(By.cssSelector("book-app[apptitle='BOOKS']")).getShadowRoot();
        Thread.sleep(1000);
        SearchContext shadow1 = shadow0.findElement(By.cssSelector("book-explore[class='_page']")).getShadowRoot();
        Thread.sleep(1000);
        SearchContext shadow2 = shadow1.findElement(By.cssSelector(" section:nth-child(2) > ul:nth-child(1) > li:nth-child(1) > book-item:nth-child(1)")).getShadowRoot();
        Thread.sleep(1000);
        System.out.println(shadow2.findElement(By.cssSelector(".title")).getText());
    }
//2.yöntem JavascriptExecutor ile
//    @Test
//    public void findShadowDOMWithSeleniumFindElement () {
//        // #1 Find Shadow Host
//        WebElement shadowHost = driver.findElement(By.tagName("book-app"));
//
//        // #2 Execute JavaScript To Return The Shadow Root
//        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
//        WebElement shadowRoot = (WebElement) jsExecutor.executeScript(
//                "return arguments[0].shadowRoot", shadowHost);
//
//        // #3 Find The WebElement Then Perform An Action On The WebElement
//        WebElement app_header = shadowRoot.findElement(By.tagName("app-header"));
//        WebElement app_toolbar
//                = app_header.findElement(By.cssSelector(".toolbar-bottom"));
//        WebElement book_input_decorator
//                = app_toolbar.findElement(By.tagName("book-input-decorator"));
//        WebElement searchField = book_input_decorator.findElement(By.id("input"));
//        searchField.sendKeys("Seleinum"+ Keys.ENTER);
//    }
}

/*
 shadowsuz çözülmez. Javascritpexecuter methodlarıyla çözülür onuda henüz öğrenmediniz
 JavascriptExecutor js = (JavascriptExecutor) driver;
        String str = "return document.querySelector('body > book-app').shadowRoot.querySelector('#input')";
        WebElement el = (WebElement) ((JavascriptExecutor) driver).executeScript(str);
        el.sendKeys("gönderilecek yazı");
JavaScript ile de bu şekilde locate edilebilir. (Books başlığının altındaki arama kutusu için
 */