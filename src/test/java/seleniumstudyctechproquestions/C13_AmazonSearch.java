package seleniumstudyctechproquestions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class C13_AmazonSearch extends TestBase {

    //Go to https://www.amazon.com.tr/
    //Search iPhone13 512
    //Check that the results are listed
    //Click iPhone13 at the top of the list
    //Log the following values for each size .Size information .Price .Color .Stock status
    //Isim - Renk - Stok - Boyut - Fiyat

    @Test
    public void testSearchResults() {
        // Search for "iPhone 13 512"
        WebElement searchField = driver.findElement(By.id("twotabsearchtextbox"));
        searchField.sendKeys("iPhone 13 512");
        searchField.submit();

        // Check that the results are listed
        WebElement resultsContainer = driver.findElement(By.id("s-results-list-atf"));
        assert resultsContainer.isDisplayed();

        // Click on the first result (iPhone 13)
        WebElement firstResult = driver.findElement(By.cssSelector("#s-results-list-atf > li:nth-child(1) > div > div > div > div.a-section.a-text-center > div > div > a"));
        firstResult.click();

        // Log the size, price, color, and stock status for each size
        List<WebElement> sizeElements = driver.findElements(By.cssSelector("#variation_size_name > div > span"));
        for (WebElement sizeElement : sizeElements) {
            String size = sizeElement.getText();

            WebElement priceElement = driver.findElement(By.cssSelector("#priceblock_ourprice"));
            String price = priceElement.getText();

            WebElement colorElement = driver.findElement(By.cssSelector("#variation_color_name > div > span"));
            String color = colorElement.getText();

            WebElement stockStatusElement = driver.findElement(By.cssSelector("#availability > span"));
            String stockStatus = stockStatusElement.getText();

            System.out.println("Size: %s, Price: %s, Color: %s, Stock Status: %s" +" " +size+" " + price+ " " +color+ " " +stockStatus);
        }
    }

}
