package day15;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class C02_WebTables extends TestBase {
    //https://the-internet.herokuapp.com/tables
    //Create a class: WebTables
    //Task 1 : Table1’i print edin
    //Task 2 : 3. Row’ datalarını print edin
    //Task 3 : Son row daki dataları print edin
    //Task 4 : 5. Column datalarini print edin
    //Task 5 : Iki parametreli bir Java metot oluşturalım: printData
    //Parameter 1 = row numarasi
    //Parameter 2 = column numarasi
    //printData(2,3);  => 2nd row, 3rd column daki datayı print etsin


    private static Logger logger = LogManager.getLogger(C02_WebTables.class.getName());

    @Test
    public void table1Print() {

        //https://the-internet.herokuapp.com/tables
        driver.get("https://the-internet.herokuapp.com/tables");
        //Task 1 : Table1’i print edin
        //1.yol:Tum verileri alir
        String table1 = driver.findElement(By.xpath("//table[@id='table1']")).getText();
    //    System.out.println("Table 1 Verileri");
        logger.info("TABLE 1 VERILERI");
        System.out.println("table1  = " + table1);
        //2. Butun verileri tek tek alir
        List<WebElement> tumVeriler = driver.findElements(By.xpath("//table[@id='table1']//td"));
        //tumVeriler.forEach(t-> System.out.println(t.getText()));
        for (WebElement veri : tumVeriler) {
            System.out.println(veri.getText());
        }
    }

    @Test
    public void row3Print() {
        //    Task 2 : 3. Row’ datalarını print edin
        driver.get("https://the-internet.herokuapp.com/tables");
        List<WebElement> row3Elements = driver.findElements(By.xpath("//table[@id='table1']//tbody//tr[3]//td"));
        row3Elements.forEach(veri-> System.out.println(veri.getText()));
    }

    @Test
    public void sonSatirVerileri() {
        //Task 3 : Son row daki dataları print edin
        driver.get("https://the-internet.herokuapp.com/tables");
        List<WebElement>sonSatir= driver.findElements(By.xpath("//table[@id='table1']//tbody//tr[last()]//td"));
        sonSatir.forEach(veri-> System.out.println(veri.getText()));
    }

    @Test
    public void sutun5Test() {
        //Task 4 : 5. Column datalarini print edin
        driver.get("https://the-internet.herokuapp.com/tables");
        List<WebElement> sutun5 = driver.findElements(By.xpath("//table[@id='table1']//tbody//tr//td[5]"));
        sutun5.forEach(veri-> System.out.println(veri.getText()));
    }

    //Task 5 : Iki parametreli bir Java metot oluşturalım: printData
    //Parameter 1 = row numarasi
    //Parameter 2 = column numarasi
    //printData(2,3);  => 2nd row, 3rd column daki datayı print etsin

    public void printData(int satir, int sutun) {

        driver.get("https://the-internet.herokuapp.com/tables");
        String myXpath ="//table[@id='table1']//tbody//tr["+satir+"]//td["+sutun+"]";
        System.out.println(driver.findElement(By.xpath(myXpath)).getText());
    }

    public void printData(int satir, int sutun,String tagName) {

        driver.get("https://the-internet.herokuapp.com/tables");
        String myXpath ="//"+tagName+"//tbody//tr["+satir+"]//td["+sutun+"]";
        System.out.println(driver.findElement(By.xpath(myXpath)).getText());
    }

    @Test
    public void printDataSet() {
        printData(2,3);//fbach@yahoo.com
        printData(2,3,"table");//fbach@yahoo.com
        printData(1,2);//John
    }

    @Test
    public void headersTest() {
        driver.get("https://the-internet.herokuapp.com/tables");
        List<WebElement> headerList= driver.findElements(By.xpath("//table[@id='table1']//thead"));
        headerList.forEach(t-> System.out.println(t.getText()));




    }

    /*
            public void rowColumnDataPrint(String tableNumber, String rowNumber, String columnNumber){
        String rowData=    driver.findElement(By.xpath("//table["+tableNumber+"]//tr["+rowNumber+"]//td["+columnNumber+"]")).getText();
        System.out.println("rowData = " + rowData);
        }
     */

    /*
    https://the-internet.herokuapp.com/tables
Create a class: WebTables
Task 1 : Table1’i print edin
Task 2 : 3. Row’ datalarını print edin
Task 3 : Son row daki dataları print edin
Task 4 : 5. Column datalarini print edin
Task 5 : Iki parametreli bir Java metot oluşturalım: printData
Parameter 1 = row numarasi
Parameter 2 = column numarasi
printData(2,3);  => 2nd satir, 3rd sutun daki datayı print etsin

public void printData(int row, int column) {
    driver.get("https://the-internet.herokuapp.com/tables ");
    List<WebElement> columnFiveElements = driver.
            findElements(By.xpath("//table[@id='table1']//tbody//tr[" + row + "]//td[" + column + "]"));
    columnFiveElements.stream().forEach(t -> System.out.println(t.getText()));
}
     */

}


/*
List<WebElement> allRows = driver.findElements(By.xpath("//table[@id=\"table1\"]//tr"));
int rowNum = 1;
for (WebElement eachRow: allRows) {
    System.out.println("Row " + rowNum + "=>" + eachRow.getText());
    rowNum++;
}
//3. Row
System.out.println("3. Data = " + allRows.get(3).getText());
 */
/////RESUABLE METHODS
//public static List<String> getElementsText(List<WebElement> list) {
//    List<String> elementText = new ArrayList<>();
//    for (WebElement w : list) {
//        if (!w.getText()) {
//            elementText.add(w.getText());
//        }
//    }
//    return elementText;
//}