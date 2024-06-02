package day13_seleniumWaits_coockies;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class C02_Seleniumwaits {

    @Test
    public void implisitlywaitTesti(){
        //Webdreiveri bu methodda olusturup ayarlarini yapin
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        //1. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        //2. Remove butonuna basin.
        driver.findElement(By.xpath("//*[text()='Remove']")).click();
        //3. “It’s gone!” mesajinin goruntulendigini dogrulayin.
        WebElement sonucMesajElementi=driver.findElement(By.xpath("//*[@id='message']"));

        String expectedsonucyazisi="It’s gone!";
        String actualSonucyazisi=sonucMesajElementi.getText();
        Assertions.assertEquals(expectedsonucyazisi,actualSonucyazisi);
        //4. Add buttonuna basin
        driver.findElement(By.xpath("//*[text()='Add']")).click();
        //5. It’s back mesajinin gorundugunu test edin
        expectedsonucyazisi="It's back";
        actualSonucyazisi=sonucMesajElementi.getText();
        Assertions.assertEquals(expectedsonucyazisi,actualSonucyazisi);
        driver.quit();

    }
    @Test
    public void explisitlywaitTesti(){
        //Webdreiveri bu methodda olusturup ayarlarini yapin
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
       // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //1. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        //2. Remove butonuna basin.
        driver.findElement(By.xpath("//*[text()='Remove']")).click();
        //3. “It’s gone!” mesajinin goruntulendigini dogrulayin.
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));

        WebElement itsGoneElementi=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        Assertions.assertTrue(itsGoneElementi.isDisplayed());


        //4. Add buttonuna basin
        driver.findElement(By.xpath("//*[text()='Add']")).click();

        //5. It’s back mesajinin gorundugunu test edin
        WebElement itsbackElementi=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        Assertions.assertTrue(itsbackElementi.isDisplayed());
        driver.quit();



    }
}
