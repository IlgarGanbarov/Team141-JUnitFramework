package day11_actiosClass;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import test.utilities.ReusableMethods;
import test.utilities.TestBase;

public class C02_Actions extends TestBase {
    @Test
    public void test01(){
        //1- https://testotomasyonu.com/click sitesine gidin
        driver.get("https://www.testotomasyonu.com/click ");
        ReusableMethods.bekle(15);

        //2- “DGI Drones” uzerinde sag click yapin
        Actions actions=new Actions(driver);

        WebElement dgiDronElementi=driver.findElement(By.id("pic2_thumb"));
        ReusableMethods.bekle(12);
        actions.contextClick(dgiDronElementi).perform();
        ReusableMethods.bekle(15);


        //3- Alert’te cikan yazinin “Tebrikler!... Sağ click yaptınız.” oldugunu test edin.
        String expectedalertyazisi="Tebrikler!... Sağ click yaptınız";
        String actualAlertYazisi=driver.switchTo().alert().getText();
        Assertions.assertEquals(expectedalertyazisi,actualAlertYazisi);
        //4- Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();
        ReusableMethods.bekle(15);


    }
}
