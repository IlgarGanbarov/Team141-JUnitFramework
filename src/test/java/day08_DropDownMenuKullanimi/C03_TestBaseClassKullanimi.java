package day08_DropDownMenuKullanimi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import test.utilities.ReusableMethods;
import test.utilities.TestBase;

import java.util.List;

import static day08_DropDownMenuKullanimi.C01_RadioButton.driver;

public class C03_TestBaseClassKullanimi extends TestBase {
    @Test
    public void aramaTesti() {
        // testotomasyonu anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");

        // phone icin arama yapin

        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("phone" + Keys.ENTER);

        // arama sonucunda urun bulunabildigini test edin

        List<WebElement> bulunanUrunElementleriList =
                driver.findElements(By.className("prod-img"));

        Assertions.assertTrue(!bulunanUrunElementleriList.isEmpty());

        ReusableMethods.bekle(5);


    }
}
