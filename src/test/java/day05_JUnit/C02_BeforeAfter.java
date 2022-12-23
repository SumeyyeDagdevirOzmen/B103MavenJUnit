package day05_JUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C02_BeforeAfter {
    @Before
    public void setUp(){

        System.out.println("Her Test Methodundan Once Calisir");
    }
    @After
    public void tearDown(){
        System.out.println("Her Test Methodundan sonra calisir.");
    }
    @Test
    public void test01(){
        System.out.println("Ilk Test");
    }
    @Test
    public void test02(){
        System.out.println("Ikinci Test");
    }


}
