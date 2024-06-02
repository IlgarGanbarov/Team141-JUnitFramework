package day09_JsAlerts;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import test.utilities.ReusableMethods;
import test.utilities.TestBase;

public class C04_IFrame extends TestBase {

    @Test
    public void test01(){

        ////1 ) https://the-internet.herokuapp.com/iframe adresine gidin.
        driver.get("https://the-internet.herokuapp.com/iframe");
        WebElement anIframeyaziElementi=driver.findElement(By.xpath("h3"));
        Assertions.assertTrue(anIframeyaziElementi.isEnabled());
        System.out.println(anIframeyaziElementi.getText());
        driver.findElement(By.xpath("//div[@aria-label='Close']"));
        WebElement iFrameElementi=driver.findElement(By.xpath("//iframe[@title='Rich Text Area']"));
        driver.switchTo().frame(iFrameElementi);
        ReusableMethods.bekle(20);

        WebElement textBox=driver.findElement(By.tagName("p"));
        textBox.clear();
        textBox.sendKeys("Merhaba Dunya");

        //
        //    // 2 ) Bir metod olusturun: iframeTest
        //    // - “An IFrame containing….” textinin erisilebilir oldugunu test edin ve  konsolda yazdirin.
        //    // - Text Box’a “Merhaba Dunya!” yazin.
        //    // - TextBox’in altinda bulunan “Elemental Selenium” linkinin gorunur oldugunu dogrulayin ve  yazisini konsolda yazdirin.
        ReusableMethods.bekle(5);

    }

}
