package practice02;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

public class Dropdown extends TestBase {
    @Test
    public void test01() {
        //Amazon sayfasina gidelim
        driver.get("https://www.amazon.com");

        //Dropdown menuyu yazdiralim
        List<WebElement> dropdown = driver.findElements(By.xpath("//select[@id='searchDropdownBox']"));
        //Select selecObject = new Select(dropdown);
        dropdown.forEach(t-> System.out.println(t.getText()));
        /*
                WebElement dropdown = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        Select select = new Select(dropdown);
        for (WebElement w : select.getOptions()) {
            System.out.println(w.getText());
        }
         */
        //Dropdown menuden Baby secelim
        driver.findElement(By.xpath("//select[@id='searchDropdownBox']")).sendKeys("Baby",
                Keys.TAB,"Milk",Keys.ENTER);

        //Arama bolumunden milk aratalim.

    }
}
