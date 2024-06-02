package day11_actiosClass;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import test.utilities.ReusableMethods;
import test.utilities.TestBase;

public class C06_FormDoldurma extends TestBase {
    @Test
    public void test01(){

        //1- https://www.testotomasyonu.com adresine gidelim
        driver.get("https://www.testotomasyonu.com");

        //2- Account linkine tiklayin
        driver.findElement(By.xpath("//*[text()='Account']")).click();

        //3- Sign Up linkine basalim
        driver.findElement(By.xpath("//*[text()=' Sign Up']")).click();

        //4- Ad, soyad, mail ve sifre kutularina deger yazalim ve Sign Up butonuna basalim
        WebElement firstNamekutusu=driver.findElement(By.id("firstName"));
        Actions actions=new Actions(driver);
        actions.click(firstNamekutusu).sendKeys("Ilgar").sendKeys(Keys.TAB).sendKeys("Avluk")
                .sendKeys("abc@gmail.com").sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB).sendKeys("12345")
                .sendKeys(Keys.TAB).sendKeys("12345").perform();
        driver.findElement(By.id("btn-submit-form")).click();
        ReusableMethods.bekle(10);
        //5- Kaydin olusturuldugunu test edin
        WebElement emailAdresKutusu=driver.findElement(By.id("email"));
        actions.click(emailAdresKutusu).sendKeys("abc@gmail.com").sendKeys(Keys.TAB).sendKeys("12345").perform();
        driver.findElement(By.id("submitlogin")).click();
        ReusableMethods.bekle(5);
    }
}
