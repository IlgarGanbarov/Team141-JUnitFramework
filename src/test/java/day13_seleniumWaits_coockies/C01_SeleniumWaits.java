package day13_seleniumWaits_coockies;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.utilities.ReusableMethods;

import java.time.Duration;

public class C01_SeleniumWaits {

    @Test
    public void implicitlywaitTesti(){
        //Webdreiveri bu methodda olusturup ayarlarini yapin
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

         //1.https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        //2. Textbox’in etkin olmadigini(enabled) dogrulayın
        WebElement textBox=driver.findElement(By.xpath("//*[@type='text']"));
        Assertions.assertFalse(textBox.isEnabled());
        ReusableMethods.bekle(20);
        //3. Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin
        driver.findElement(By.xpath("//*[text()='Enable']")).click();
        ReusableMethods.bekle(20);
        //4. Textbox’in etkin oldugunu(enabled) dogrulayın.
        Assertions.assertTrue(textBox.isEnabled());
        //5. “It’s enabled!” mesajinin goruntulendigini dogrulayın.
        String expectedSonucYazisi="It’s enabled!";
        String actualsonucyazisi=driver.findElement(By.xpath("/*[@id='message']")).getText();
        ReusableMethods.bekle(30);
        Assertions.assertEquals(expectedSonucYazisi,actualsonucyazisi);
    }
    @Test
    public void explisitlyWaitTesti(){
        //Webdreiveri bu methodda olusturup ayarlarini yapin
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //1.https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        //2. Textbox’in etkin olmadigini(enabled) dogrulayın
        WebElement textBox=driver.findElement(By.xpath("//*[@type='text']"));
        Assertions.assertFalse(textBox.isEnabled());
        ReusableMethods.bekle(20);
        //3. Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin
        driver.findElement(By.xpath("//*[text()='Enable']")).click();
        ReusableMethods.bekle(20);

        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(textBox));
        //4. Textbox’in etkin oldugunu(enabled) dogrulayın.
        Assertions.assertTrue(textBox.isEnabled());
        ReusableMethods.bekle(30);
        //5. “It’s enabled!” mesajinin goruntulendigini dogrulayın.
        String expectedSonucYazisi="It’s enabled!";
        String actualsonucyazisi=driver.findElement(By.xpath("/*[@id='message']")).getText();

        Assertions.assertEquals(expectedSonucYazisi,actualsonucyazisi);
        ReusableMethods.bekle(30);
        driver.quit();


        //5. “It’s enabled!” mesajinin goruntulendigini dogrulayın.
    }
}
