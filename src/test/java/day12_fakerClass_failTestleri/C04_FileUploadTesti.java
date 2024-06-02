package day12_fakerClass_failTestleri;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import test.utilities.ReusableMethods;
import test.utilities.TestBase;

public class C04_FileUploadTesti extends TestBase {

    @Test
    public void test(){

        //1.https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");
        ReusableMethods.bekle(10);
        //2.chooseFile butonuna basalim
        String dosyayolu="C:\\Users\\qenbe\\Desktop\\team1414_JUnit\\src\\main\\java\\test\\day12_fakerClass_failTestleri\\upload.png";
        WebElement choseFeilButonu=driver.findElement(By.id("file-upload"));
        choseFeilButonu.sendKeys(dosyayolu);
        ReusableMethods.bekle(10);

        //3.Upload.png dosyayi secelim.
        driver.findElement(By.id("file-submit"));
        //4.Upload butonuna basalim.
        //5.“File Uploaded!” textinin goruntulendigini test edelim.
        String expectedYazi="File Uploaded";
        String actualYazi=driver.findElement(By.xpath("file-submit")).getText();
        Assertions.assertTrue(actualYazi.contains(expectedYazi));
        ReusableMethods.bekle(10);
    }
}
