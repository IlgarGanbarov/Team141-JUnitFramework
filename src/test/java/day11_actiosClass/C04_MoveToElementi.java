package day11_actiosClass;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import test.utilities.ReusableMethods;
import test.utilities.TestBase;

public class C04_MoveToElementi extends TestBase {
    @Test
    public void test01(){

        //1- https://www.testotomasyonu.com/ adresine gidin
        driver.get("https://www.testotomasyonu.com/ ");
        ReusableMethods.bekle(10);
        //2- “Kids Wear” menusunun acilmasi icin mouse’u bu menunun ustune getirin
        Actions actions=new Actions(driver);
        WebElement kidsWearYaziElementi=driver.findElement(By.xpath("(//*[@class='has-sub'])[7]"));
        actions.moveToElement(kidsWearYaziElementi).perform();
        ReusableMethods.bekle(10);

        //3- “Boys” linkine basin
       driver.findElement(By.linkText("Boys")).click();
        ReusableMethods.bekle(10);
        //4- Acilan sayfadaki ilk urunu tiklayin
        driver.findElement(By.xpath("(//*[@class='prod-img'])[1]")).click();
        ReusableMethods.bekle(2);
        //4- Acilan sayfada urun isminin “Boys Shirt White Color” oldugunu test edin
        String expectedurunIsmi="Boys Shirt White Color";
       String actualurunIsmi=driver.findElement(By.xpath("//div[@class=' heading-sm mb-4']")).getText();
        Assertions.assertEquals(expectedurunIsmi,actualurunIsmi);
        ReusableMethods.bekle(5);
    }
}
