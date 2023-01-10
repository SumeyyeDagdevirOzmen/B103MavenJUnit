package homework;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class C06_Faker extends TestBase {
    //Faker Kutuphanesi HOMEWORK
    //Faker class’i testlerimizi yaparken ihtiyac duydugumuz isim, soyisim, adres vb bilgiler icin fake
    //degerler uretmemize imkan tanir.
    //Faker degerler uretmek icin Faker class’indan bir obje uretir ve var olan method’lari kullaniriz.
    //"https://facebook.com"  Adresine gidin
    //“create new account”  butonuna basin
    //“firstName” giris kutusuna bir isim yazin
    //“surname” giris kutusuna bir soyisim yazin
    //“email” giris kutusuna bir email yazin
    //“email” onay kutusuna emaili tekrar yazin
    //Bir sifre girin
    //Tarih icin gun secin
    //Tarih icin ay secin
    //Tarih icin yil secin
    //Cinsiyeti secin
    //Isaretlediginiz cinsiyetin secili, diger cinsiyet kutusunun secili olmadigini test edin.
    //Sayfayi kapatin


    @Test
    public void fakerTest() {

        //"https://facebook.com"  Adresine gidin
        driver.get("https://facebook.com");
        driver.findElement(By.xpath("//button[@class='_42ft _4jy0 _9xo7 _4jy3 _4jy1 selected _51sy']")).click();

        //“create new account”  butonuna basin
        driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();

        //“firstName” giris kutusuna bir isim yazin
        //“surname” giris kutusuna bir soyisim yazin
        //“email” giris kutusuna bir email yazin
        //“email” onay kutusuna emaili tekrar yazin
        //Bir sifre girin
        Faker faker = new Faker();
        String firstName = faker.name().firstName();
        System.out.println(firstName);
        String lastName = faker.name().lastName();
        String emailAddress= faker.internet().emailAddress();
        String password = faker.internet().password();

          driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(firstName,Keys.TAB,lastName
                  ,Keys.TAB,emailAddress);
          driver.findElement(By.xpath("//input[@name='reg_email_confirmation__']")).sendKeys(emailAddress,Keys.TAB,password,
                  Keys.TAB,Keys.TAB,"20",Keys.TAB,"May",Keys.TAB,"2000",Keys.TAB,
                    Keys.TAB);
          //Tarih icin gun secin
        //Tarih icin ay secin
        //Tarih icin yil secin
        //Cinsiyeti secin
        //Isaretlediginiz cinsiyetin secili, diger cinsiyet kutusunun secili olmadigini test edin.


        WebElement female = driver.findElement(By.xpath("//input[@value='1']"));
        WebElement male = driver.findElement(By.xpath("//input[@value='2']"));
        WebElement ozel = driver.findElement(By.xpath("//input[@value='-1']"));
        waitFor(3);
        female.click();
        //Isaretlediginiz cinsiyetin secili, diger cinsiyet kutusunun secili olmadigini test edin.
        Assert.assertTrue(female.isSelected());
        Assert.assertFalse(male.isSelected());
        Assert.assertFalse(ozel.isSelected());

//        List<WebElement> radioButtonGrup = driver.findElements(By.xpath("//*[@type='radio']"));
//        for (WebElement w : radioButtonGrup){
//            System.out.println(w.isSelected());
//        }
//        Assert.assertTrue(radioButtonGrup.get(0).isSelected());
//        Assert.assertFalse(radioButtonGrup.get(1).isSelected());
//        Assert.assertFalse(radioButtonGrup.get(2).isSelected());


        //Sayfayi kapatin



    }
}
