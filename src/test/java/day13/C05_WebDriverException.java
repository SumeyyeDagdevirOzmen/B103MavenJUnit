package day13;

        /*
        WebDriverException
        When you close the browser, but still want to use that in correctly
        When the versions of the driver and browsers are not compatible
        Solution
        Your design should be good. We should use singleton Driver to prevent this exception
        Keep drivers up to date that is compatible with the  browser version
        _____________________________________________________________________
        Seleniumda aldigin 5 exception
        Null pointer, no such element, time out, slale element reference, web driver
        Genel olarak exception aldiginda bozum yolun nedir?
        Hata mesajini oku
        Genel olarak zamanlama, yanlis locator, iframe hataları olabiliyor
        Hata mesajina gore exception I cozdukden sonra tekrar kodumu calistirim
        Selniumda kullandigin waitler nelerdir>
        Implicit yada explicit yada fluent
        Hangi waiti tercih edersin?
        Test Base (Driver sinifinda) implicit wait kullanıyorum. Cogu problemi bozuyor Cozemedigi durumlarda explicit wait kullanıyorum.
        Neden Explicit wait?
        Explicit wait element e ouzel yazilabilir. Yerel cozum gerektiğinde explicit wait I kullanmak zorundayiz.
        Senkronize(bekleme) problemlerini nasıl çözersin
        Selenium waitlerini kullanarak. Implicit wait driver im da var, ama yetmedigi durumlarda explicit wait kullanirim.
         Bu yüzden ReusableMethod sinifimda tekrar tekrar kullanabileceğimiz explicit wait method lari var.
         Kolaylıkla explicit wait ile bekleme problemlerini cozebiliyoruz.

         =================================================================================================================
         Tell me 5 exception that you get/What type of exceptions do you get in selenium?
            Null pointer, no such element, time out, slate element reference, web driver
            What is your solution?
            Read the error message and learn what is the error and where it is.
            In general, error happens because of the timing issue, wrong locator, or iframe/windows/alerts
            Each error has specific solutions but in general, I debug my code, and do some research then execute the code one more time after the fix.
            What type of waits do you use?
            I use implicit or explicit wait
            Which wait do you prefer?
            Explicit wait works better in some cases. When I use explicit wait, and still see timeout exception, then then there can be other issues such as incorrect locators.
            Why do you prefer that wait?
            I already have implicit wait in my Driver class, but I prefer explicit wait when I need to use an expected condition such as element is not visible.
            How do you resolve synronization issue?
            I use implicit or explicit wait. In my driver class, I already have implicit wait, that handles most of the wait issues, but when it is not enough than I use explicit wait.
         */

public class C05_WebDriverException {
    /*
    WebDriverException
Driver versiyonları ve browser versiyonları ayni veya yakin olmadiginda alinir
Driver(Browser) kapattikdan sonra tekrar kullanmak istediğiniz durumlarda alınabilir.
Solution
Framework designinin guzel kurulmuş olması gerekir, ornegin Driver sinifinda birden farza driver.quit() olmamali
     */
    /*
      /*
       Tester olarak ekran görüntüsü neden alınır ?
          Dökümantasyon için
             Geçen Test Case'lerin geçtiğini kayda geçirmek
             Kalan Test Case'lerin de kaldığını/ bug bulunduğunda kayda geçirmek için
     */

        /*
            https://www.techproeducation.com sayfasına git
            LMS Login linkinin sayfada olduğunu test et

            =============================================

            MAC :command+shift 3 hepsini 4 istedigimizi alir hocam 5de resim sheklinde (mac)
            MAC : Command + Shift + 4 -> Manual olarak ekran goruntusunu al
            WINDOWS : Windows + Shift + S -> Manual olarak ekran goruntusunu al
         */

        /*
           TEST EXECUTION DOCUMENTATION
              1.Adım: Ana sayfaya git ve LMS Login element'ini test et
         */

}
