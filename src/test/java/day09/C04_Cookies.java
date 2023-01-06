package day09;

import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

public class C04_Cookies extends TestBase {

    @Test
    public void handleCookiesTest(){
        //Amazona git
        driver.get("https://www.amazon.com");
        waitFor(2);

        //1.toplam cookie sayisini bul
        Set<Cookie> allCookies =  driver.manage().getCookies();
        int cookieSayisi = allCookies.size();
        System.out.println("Sayfadaki Cookie Sayisi = " + cookieSayisi+" adet cookie var");


        //Tum cookie leri yazdiralim
         //     allCookies.stream().forEach(t -> System.out.println(t.getName()));
        int count=0;
        for(Cookie eachCookie: allCookies){
            count++;
            System.out.println("eachCookie = " + eachCookie);//Cookie nin tum bilgilerini yazdik
            System.out.println("Cookie Isimleri : "+count+".cookie= "+eachCookie.getName());
        }
        //3. Bir Cookie yi ismiyle bul
        System.out.println("Cookiyi ismiyle cagiriyorum : "+driver.manage().getCookieNamed("i18n-prefs"));

        //4. Yeni bir cookie ekle
        Cookie favoriCookiem = new Cookie("Cikolatam","antep-fistikli-cikolata");
        driver.manage().addCookie(favoriCookiem);//sayfaya yeni cookie ekle
        waitFor(3);
        System.out.println("Yeni Cookie Sayisi= "+driver.manage().getCookies().size());//cookie sayisi artti
        //5. Bir Cookie yi ismiyle sil
        driver.manage().deleteCookieNamed("session-id");
        //6. Tum cookie leri sil
        driver.manage().deleteAllCookies();
        waitFor(3);
        System.out.println("TUM COOKIES LERI SILDIM. YENI COOKIE SAYISI : "+driver.manage().getCookies().size());

    }
}
