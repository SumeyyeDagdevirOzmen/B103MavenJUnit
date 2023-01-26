package day07;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C06_Files  {
    //masaustunde text dosyasi olustur
    //masaustundeki text dosyasinin varligini tets et //Selenium masaustune mudahale edemez java ile yapicam


    @Test
    public void name() {
        // C:\Users\mamap -> bu kisim herkesin bilgisayarinda farklidir          \Desktop\text.txt->Bu kisim herkesin bilgisayarinda aynidir.
        String dosyaYolu="C:\\Users\\mamap\\Desktop\\text.txt";
        //Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));//Dosyam mevcut mu degil mi? diye assert ediyorum. Bu islemei dinamik hale getirelim,cunku bu yontem dinamik degil

        String farkliKisim=System.getProperty("user.home");//Bu bana herkesin bilgisayarindaki farkli olan kismi dinamik olarak verir
        //System.out.println(farkliKisim);
        String ortakKisim="\\Desktop\\text.txt";
        String filePath = farkliKisim+ortakKisim;//Dosya yolunu dinamik olarak elde ettim.
        //System.out.println(filePath);

        Assert.assertTrue(Files.exists(Paths.get(filePath)));




    }
}
