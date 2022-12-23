package day05_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_BeforeClassAfterClass {

    /*
    @BeforeClass ve @AfterClass notasyonlari sadece static method'lar icin calisir.
    @BeforeClass ve @AfterClass kullanirsak olusturdugumuz @Test methodlarinin hepsini ayni anda calistirip
    en son @AfterClass'i calistiririz.
     Ama sadece @Before ve @After kullanirsak her test icin @before ve @after'i kullanir.
      WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        @BeforeClass--->Test01, Test02, Test03....-->@AfterClass
        Before--> Test01---> After
        Before--> Test02---> After
     */

    @BeforeClass
    public static void setUp() {
        System.out.println("Butun Testlerden once calisti.");
    }

    @AfterClass
    public static void tearDown() {
        System.out.println("Butun testlerden sonra calisti.");
    }
    @Before
    public void setUp01(){
        System.out.println("Her testden once calisir");
    }
    @After
    public void tearDown01(){
        System.out.println("Her testden sonra calisir");
    }
    @Test
    public void test01(){
        System.out.println("Ilk Test");
    }
    @Test
    public void test02(){
        System.out.println("Ikinci Test");
    }
    @Test
    @Ignore//Calistirmak istemedigimiz testler icin kullaniriz ve o test calismaz.C
    public void test03(){
        System.out.println("Ucuncu Test");
    }
}
