package seleniumstudyctechproquestions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C07_MonkeyTest {
    static WebDriver driver;
    public static void attack(){
        JavascriptExecutor js =(JavascriptExecutor)driver;
        String script="javascript: (function() {\n" +
                "    function callback() {\n" +
                "        gremlins.createHorde({\n" +
                "            species: [gremlins.species.clicker(),gremlins.species.toucher(),gremlins.species.formFiller(),gremlins.species.scroller(),gremlins.species.typer()],\n" +
                "            mogwais: [gremlins.mogwais.alert(),gremlins.mogwais.fps(),gremlins.mogwais.gizmo()],\n" +
                "            strategies: [gremlins.strategies.distribution(),gremlins.strategies.allTogether(),gremlins.strategies.bySpecies()]\n" +
                "        }).unleash();\n" +
                "    }\n" +
                "    var s = document.createElement(\"script\");\n" +
                "    s.src = \"https://unpkg.com/gremlins.js\";\n" +
                "    if (s.addEventListener) {\n" +
                "        s.addEventListener(\"load\", callback, false);\n" +
                "    } else if (s.readyState) {\n" +
                "        s.onreadystatechange = callback;\n" +
                "    }\n" +
                "    document.body.appendChild(s);\n" +
                "    })()";
        js.executeAsyncScript(script);
    }
    public static void main(String[] args) {
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.techproeducation.com");
        attack();
    }
}
    //Monkey Testi Manuel Test dersinde duymuşsunuzdur onu otomasyona dokmusler
      //  Techproeducation birgun firsat verirse sizlere anlatmak isterim
//Javascript bilmenize gerek yok aslinda ,javascriptExecutor da size anlatilacak. onun haricindeki script kismi hazir bulunuyor
//.Ben olaya biraz espri katmak istedim.Bu kodda olan javascriptexecutor kısmı size anlatılacak,diğer kısımlar advance;
// onlara ihtiyacınız olmayacak.Kod çalıştıktan sonra hata veriyor o konuda da sıkıntınız yok.