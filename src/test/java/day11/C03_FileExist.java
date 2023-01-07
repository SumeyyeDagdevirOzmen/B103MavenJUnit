package day11;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C03_FileExist {
    //Class : FileExistTest
    //Method : isExist
    //Masa ustunden bir dosyanın varligini test et

    @Test
    public void isExistTest(){
        String userDIR = System.getProperty("user.dir");
        System.out.println(userDIR);//C:\Users\mamap\IdeaProjects\com.B103Maven_Junit

        String userHome = System.getProperty("user.home");
        System.out.println(userHome);//Root directory'ini verir. C:\Users\mamap

        //logo.jpeg indirip Masaustune kaydedin
        //logo masaustunde: C:\Users\mamap\desktop

        String dosyaYolu = userHome+"\\Desktop\\logo.jpeg";//"C:\\Users\\mamap\\Desktop\\logo.jpeg"
        System.out.println(dosyaYolu);

        boolean isExist = Files.exists(Paths.get(dosyaYolu));//Dosya var ise true yoksa false return edecek
        Assert.assertTrue(isExist);

    }
}
