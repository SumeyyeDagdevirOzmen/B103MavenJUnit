package day13;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

public class C03_NullPointerException  {
    /*
    NullPointerException:
    //Degiskenleri olusturup instantiate(Objede new kelimesini kullanmak) etmedigimizde aliriz.
    Örn: driver = new ChoromeDriver()'da "new" kelimesini kullanmadığımızda NullPointerException hatasını alırız.
    Ornegin WebDriver driver; deyip =new ChromeDriver demezsek nullpointerexception aliriz.
    Cozumu: Degiskeni new keleimesini kullanarak bir deger atamaliyiz yani instantiate etmeliyiz.

     */

    WebDriver driver;
    Faker faker;
    @Test
    public void nullPointerExceptionTest() {
        driver.get("https://www.techproeducation.com");//java.lang.NullPointerException aliriz
    }
    @Test
    public void nullPointerExceptionTest2(){
       // faker = new Faker();
        System.out.println(faker.name().fullName());//java.lang.NullPointerException
    }
}
