package day09_JsAlerts;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import test.utilities.ReusableMethods;
import test.utilities.TestBase;

import java.util.List;

public class C03_IFrame extends TestBase {

    @Test
    public void iFrameTest(){

        //1- https://testotomasyonu.com/discount adresine gidin
        driver.get("https://testotomasyonu.com/discount");
        //2- Elektronics Products yazisinin gorunur olduğunu test edin

        // Electronics Products yazisinin bir iframe icinde oldugunu gorduk
        // o yaziya ulasabilmek icin 3 adim atmamiz gerekir
        // ilk adim : Electronics Products'in icinde oldugu iFrame'i locate edelim

        WebElement electronicsIframe = driver.findElement(By.xpath("(//iframe)[1]"));

        // ikinci adim : locate ettigimiz iFrame'e gecis yapalim

        driver.switchTo().frame(electronicsIframe);

        // ucuncu adim : artik bu iframe icindeki elementleri kullanabilirsiniz
        // ONEMLI : bir iFrame'e gecis yapinca, siz oradan cikmadikca
        //          driver o iFrame'in icinde kalacaktir

        WebElement electronicsyaziElementi = driver.findElement(By.xpath("//*[text()='Electronics Products']"));

        Assertions.assertTrue(electronicsyaziElementi.isDisplayed());

        //3- Dell bilgisayar urun isminin ‘DELL Core I3 11th Gen’ olduğunu test edin

        String expectedUrunismi = "DELL Core I3 11th Gen";

        String actualUrunIsmi = driver
                .findElement(By.xpath("//*[text()='DELL Core I3 11th Gen ']"))
                .getText();

        Assertions.assertEquals(expectedUrunismi,actualUrunIsmi);

        //4- Sagdaki bolumde gorunen urunler arasinda ‘Men Slim Fit’ içeren en az 1 urun olduğunu test edin

        //soldaki IMframe icinde oldugumuzdan

        //driver.switchTo().defaultContent();
        driver.switchTo().parentFrame();

        WebElement fasionIframe = driver.findElement(By.xpath("(//iframe)[2]"));
        driver.switchTo().frame(fasionIframe);
        List<WebElement>urunIsimElementleri=driver.findElements(By.tagName("p"));
       // System.out.println("bulunan urun ismi"+urunIsimElementleri.size());
        boolean menSlimFitvarmi=false;
        for (WebElement eachUrunisimElementi:urunIsimElementleri){
            if (eachUrunisimElementi.getText().contains("Men Slim Fit")){
                menSlimFitvarmi=true;
            }
        }
        Assertions.assertTrue(menSlimFitvarmi);

        //5- ‘Fashion’ yazisinin gorunur olduğunu test edin
        WebElement fasionYaziElementi=driver.findElement(By.xpath("//*[text()='Fashion']"));
        Assertions.assertTrue(fasionYaziElementi.isDisplayed());

        //6- ‘Here are some products’ yazisinin gorunur olduğunu test edin
        driver.switchTo().defaultContent();
        WebElement hereAreYaziElementi=driver.findElement(By.xpath("//*[text()='Here are some products.']"));
        Assertions.assertTrue(hereAreYaziElementi.isDisplayed());


        //7- Sayfayi kapatin
        ReusableMethods.bekle(3);
    }
}
