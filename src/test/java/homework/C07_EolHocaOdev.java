package homework;

import utilities.TestBase;

public class C07_EolHocaOdev extends TestBase {
    //https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html adresine gidelim
    //Hesap makinasından 2 basamaklı random iki tane sayı seçelim ve random 4 işlemden birini yaptıralım
    //Sonucu konsola yazdırıp
    //Sonucun doğrulamasını yapalım
}


/*
@Test
    public void test01() throws InterruptedException {
    //https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html adresine gidelim
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html");
    //Hesap makinasından 2 basamaklı random iki tane sayı seçelim ve random 4 işlemden birini yaptıralım
        int rakam1 = (int)(Math.random()*(9)+1);
        int rakam2 = (int)(Math.random()*11);
        int rakam3 = (int)(Math.random()*(9)+1);
        int rakam4 = (int)(Math.random()*11);
        String sayi1String = ""+rakam1+rakam2;
        String sayi2String = ""+rakam3+rakam4;
        double sayi1 = Double.parseDouble(sayi1String);
        double sayi2 = Double.parseDouble(sayi2String);
        driver.findElement(By.xpath("//*[@class='keys']//span[.='"+rakam1+"']")).click();
        driver.findElement(By.xpath("//*[@class='keys']//span[.='"+rakam2+"']")).click();
        waitFor(2);
        List<WebElement> islemler =  driver.findElements(By.xpath("//*[@class='keys']//span[@class='operator btn btn-outline-success']"));
        WebElement secilenIslem = islemler.get((int)(Math.random()*4));
        secilenIslem.click();
        waitFor(2);
        driver.findElement(By.xpath("//*[@class='keys']//span[.='"+rakam3+"']")).click();
        driver.findElement(By.xpath("//*[@class='keys']//span[.='"+rakam4+"']")).click();
        driver.findElement(By.xpath("//*[@class='keys']//span[@class='btn btn-outline-warning']")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//*[@id='spinner']"))));
    //Sonucu konsola yazdırıp
        String sonuc = driver.findElement(By.xpath("//*[@class='screen']")).getText();
        double actualResult = Double.parseDouble(sonuc);
        System.out.println("Gerçek Sayı = " + actualResult);
    //Sonucun doğrulamasını yapalım
        double expectedResult = 0;
        if(secilenIslem.getText().equals("+")){
            expectedResult = sayi1+sayi2;
        }else if(secilenIslem.getText().equals("-")){
            expectedResult = sayi1-sayi2;
        }else if(secilenIslem.getText().equals("x")){
            expectedResult = sayi1*sayi2;
        }else if(secilenIslem.getText().equals("÷")){
            expectedResult = sayi1/sayi2;
        }
        System.out.println("Beklenen Sayı = " + expectedResult);
        Assert.assertTrue(expectedResult==actualResult);
    }
 */


//___________________________________________________________________________________________________________________
/*
  driver.get("https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html");
    //IKI BASAMAKLI ILK SAYI
    Faker faker = new Faker();
    String sayi1IlkBasamak = String.valueOf(faker.number().numberBetween(0, 10));
    String sayi1IkinciBasamak = String.valueOf(faker.number().numberBetween(0, 10));


    int number2 = Integer.valueOf(faker.number().digits(2));
    driver.findElement(By.xpath("//*[@class='keys']//span[.='" + sayi1IlkBasamak + "']")).click();
    driver.findElement(By.xpath("//*[@class='keys']//span[.='" + sayi1IkinciBasamak + "']")).click();
    waitFor(2);

    //YAPILMASI ISTENEN ISLEMIN SECILMESI
    List<WebElement> sayilar = driver.findElements(By.xpath("//*[@class='keys']"));

    List<WebElement> islemler = new ArrayList<>();
    WebElement toplamaIslemi = driver.findElement(By.xpath("//span[.='+']"));
    WebElement cikarmaIslemi = driver.findElement(By.xpath("//span[.='-']"));
    WebElement bolmeIslemi = driver.findElement(By.xpath("//span[.='÷']"));
    WebElement carpmaIslemi = driver.findElement(By.xpath("//span[.='x']"));

    islemler.add(toplamaIslemi);
    islemler.add(cikarmaIslemi);
    islemler.add(bolmeIslemi);
    islemler.add(carpmaIslemi);
    islemler.add(toplamaIslemi);
    waitFor(2);
    islemler.get(faker.number().numberBetween(0, 4)).click();

    //IKINCI IKI BASAMAKLI SAYININ BELIRLENMESI


    String sayi2IlkBasamak = String.valueOf(faker.number().numberBetween(0, 10));
    String sayi2IkinciBasamak = String.valueOf(faker.number().numberBetween(0, 10));

    driver.findElement(By.xpath("//*[@class='keys']//span[.='" + sayi2IlkBasamak + "']")).click();
    driver.findElement(By.xpath("//*[@class='keys']//span[.='" + sayi2IkinciBasamak + "']")).click();


    //ISLEMIN YAPILMASI
    driver.findElement(By.xpath("//span[.='=']")).click();
 */

//&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
/*
 @Test
    public void test01() {

        //https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html adresine gidelim
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html");

        //Hesap makinasından 2 basamaklı random iki tane sayı seçelim ve random 4 işlemden birini yaptıralım
        List<WebElement> sayilar = driver.findElements(By.xpath("//span[@class='btn btn-outline-primary']"));
        List<WebElement> islemler = driver.findElements(By.xpath("//span[@class='operator btn btn-outline-success']"));
        WebElement esittir = driver.findElement(By.xpath("//span[@class='btn btn-outline-warning']"));



        int r1 = (int)(Math.random()*10);
        int r2 = (int)(Math.random()*10);
        int rIslem = (int)(Math.random()*4);

        sayilar.get(r1).click();
        islemler.get(rIslem).click();
        sayilar.get(r2).click();
        esittir.click();
        waitFor(6);
        WebElement sonucYazisi = driver.findElement(By.xpath("//div[@class='screen']"));


        double sayi1 = Double.parseDouble(sayilar.get(r1).getText());
        double sayi2 = Double.parseDouble(sayilar.get(r2).getText());


        switch (rIslem){
            case 0 :
                Assert.assertTrue((sayi1+sayi2)==Double.parseDouble(sonucYazisi.getText()));
                break;
            case 1:
                Assert.assertTrue((sayi1-sayi2)==Double.parseDouble(sonucYazisi.getText()) );
                break;
            case 2:
                Assert.assertTrue((sayi1/sayi2)==Double.parseDouble(sonucYazisi.getText()));
                break;
            case 3:
                Assert.assertTrue((sayi1*sayi2)==Double.parseDouble(sonucYazisi.getText()));
                break;


        }
 */