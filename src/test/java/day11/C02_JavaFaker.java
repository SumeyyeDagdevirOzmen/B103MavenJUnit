package day11;

import com.github.javafaker.Faker;
import org.junit.Test;

public class C02_JavaFaker {


    @Test
    public void javaFakerTest(){
    //1.Faker objesi olustur.
       Faker faker = new Faker();
       //2.Faker objesi ile fake data olustur.
        //first nama datasi
    String firstNAme = faker.name().firstName();
        System.out.println(firstNAme);
        //last nama datasi
        String lName = faker.name().lastName();
        System.out.println(lName);

        //Kullanici adi alabiliriz
        String userName = faker.name().username();
        System.out.println(userName);

        //meslek ismi
        String profession = faker.name().title();
        System.out.println(profession);

        //sehor
        System.out.println(faker.address().city());

        //eyalet
        System.out.println(faker.address().state());

        //full adres
        System.out.println(faker.address().fullAddress());

        //cep telefon numarasi
        System.out.println(faker.phoneNumber().cellPhone());

        //email
        System.out.println(faker.internet().emailAddress());

        //posta kodu
        System.out.println(faker.address().zipCode());

        //Random (rastgele) 15 haneli numara
        System.out.println(faker.number().digits(15));
    }

        /*
        TEST DATA : kullanicai adi, sifre, tel no, email, sehir, kredi kart no,...
        Test datalarini kimden alinir?
        1. BA-Business analyst (Acceptance Criteria lari yazar)
        2. Test Lead
        3. Manual Tester
        4. Tech Lead & Team Lead & Dev Lead
        5. Developer
        6. Database
        7. API call lar
        8. Documantasyonlar. Ognegin, API swagger dokumani.
        9. Java Faker da fake data almak icin kullanyoruz
        NERDEN GELMEZ : end user -kullanicidan, scrum master,
         */
}
