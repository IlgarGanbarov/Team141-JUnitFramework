package day10_switchingWind;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import test.utilities.ReusableMethods;
import test.utilities.TestBase;

import java.util.Set;

public class C02_KontrolsuzAcilanYeniWindowaGecis extends TestBase {
    @Test
    public void test01(){

        //● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
        String ilksayfaWHD=driver.getWindowHandle();
        //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        String expectedYazi = "Opening a new window";
        String actualyazi = driver.findElement(By.tagName("h3"))
                .getText();

        Assertions.assertEquals(expectedYazi,actualyazi);

        //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.

        String expectedTitle = "The Internet";
        String actualTitle = driver.getTitle();

        Assertions.assertEquals(expectedTitle,actualTitle);

        System.out.println("click yapmadan once driver whd : " + driver.getWindowHandle());
        System.out.println("click yapmadan acik olan tum window'larin WHD'leri : " + driver.getWindowHandles());

        //● Click Here butonuna basın.

        driver.findElement(By.xpath("//*[text()='Click Here']"))
                .click();
        // bu linki tikladigimizda KONTROLSUZ yeni bir window aciliyor
        // driver, kontrolsuz acilan window'u BILMEZ ve otomatik olarak ILK WINDOW'da kalir
        // testimiz icin driver'i yeni window'a gecirmemiz gerekiyorsa
        // bunu BIZ YAPMALIYIZ
        // driver.switchTo().window(yeniAcilanWindowWHD)

        System.out.println("=====================================");
        System.out.println("click yaptiktan sonra driver whd : " + driver.getWindowHandle());
        System.out.println("click yaptiktan sonra olan tum window'larin WHD'leri : " + driver.getWindowHandles());

        Set<String>ikiSayfaninWHDLeri=driver.getWindowHandles();
        String ikinciWindowWHD="";

        for (String eachWHD:ikiSayfaninWHDLeri){
            if (!eachWHD.equals(ilksayfaWHD)){
                ikinciWindowWHD=eachWHD;
            }

        }
        driver.switchTo().window(ilksayfaWHD);



        //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu test edin
        System.out.println(driver.getTitle());
        expectedTitle="New Window";
        actualTitle=driver.getTitle();
        Assertions.assertEquals(expectedTitle,actualTitle);
        //● Sayfadaki textin “New Window” olduğunu doğrulayın.
        String expectedText="New Window";
        String actualText=driver.findElement(By.tagName("h3")).getText();
        Assertions.assertEquals(expectedText,actualText);
        //● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu test edin
        driver.switchTo().window(ilksayfaWHD);
        expectedTitle="The Internet";
        actualTitle=driver.getTitle();
        Assertions.assertEquals(expectedTitle,actualTitle);

        ReusableMethods.bekle(15);

    }
}
