package day14_Webtabels;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import test.utilities.ReusableMethods;
import test.utilities.TestBase;

import java.util.List;

public class C02_farkliTaglarlaOlusturulanWebTabellar extends TestBase {

    @Test
    public void Test01(){

        //1. “https://testotomasyonu.com/webtables2” sayfasina gidin
        driver.get("https://testotomasyonu.com/webtables2");
        ////*[@role='trow'][2]/*[@role='tdata'][3]
        // 2. Headers da bulunan basliklari yazdirin
        List<WebElement>baslikElementleriList=driver.findElements(By.xpath("//*[@role='hrow']/*[@role='hdata']"));
        System.out.println("Basliklar:"+ ReusableMethods.stringListesineDonustur(baslikElementleriList));
        // 3. 3.sutunun basligini yazdirin
        System.out.println("3.sutun basligi: "+baslikElementleriList.get(2).getText());
        // 4. Tablodaki tum datalari yazdirin
        WebElement tumTableElementi=driver.findElement(By.className("table"));
        System.out.println("Tum body:\n"+tumTableElementi.getText());

        // 5. Tabloda kac tane cell (data) oldugunu yazdirin
        List<WebElement>bodydekidataElementleriList=driver.findElements(By.xpath("//*[@role='trow']/*[@role='tdata']"));
        System.out.println("Bodydeki cell sayisi:"+bodydekidataElementleriList.size());
        // 6. Tablodaki satir sayisini yazdirin

        List<WebElement>SatirElementlerilist=driver.findElements(By.xpath("//*[@role='trow']"));
        System.out.println("tablodaki sutun sayisi"+SatirElementlerilist.size());
        // 7. Tablodaki sutun sayisini yazdirin tablodaki sutun sayisi5
        System.out.println("Tablodaki sutun sayisi:"+baslikElementleriList.size());
        // 8. Tablodaki 3.kolonu yazdirin Tablodaki sutun sayisi:4
        List<WebElement>ucuncuSutunElementleriList=driver.findElements(By.xpath("//*[@role='trow']/*[@role='tdata'][3]"));
        System.out.println("ucuncu sutun datalari: "+ReusableMethods.stringListesineDonustur(ucuncuSutunElementleriList));
        // 9. Tabloda " Category" si Furniture olan urunun fiyatini yazdirin
        // 3.satir, 2.sutundaki elementi yazdiralim  Furniture

        System.out.println(getCellData(3,2)); // Furniture

        // 1. satir, 4. sutundaki datayi yazdiralim  Go

        System.out.println(getCellData(1,4)); // Go




        //10. Bir method olusturun, Test sayfasindan satir ve sutun verildiginde datayi yazdirsin
        System.out.println("Furniture kategorisindeki urunlerin fiyatlari : "); // $399.00

        for (int i = 1; i <= SatirElementlerilist.size(); i++) {

            if (getCellData(i,2).equalsIgnoreCase("Furniture")){

                System.out.println(getCellData(i,3));
            }

        }



    }
    public String getCellData(int satirNo , int sutunNo){

        //       //*[@role='trow'] [    2     ] / *[@role ='tdata'] [    2   ]

        String dinamikXPath = "//*[@role='trow'] [" + satirNo + "] / *[@role ='tdata'] [" + sutunNo + "]";

        WebElement istedenCellElementi = driver.findElement(By.xpath(dinamikXPath));

        return istedenCellElementi.getText();
    }

}
