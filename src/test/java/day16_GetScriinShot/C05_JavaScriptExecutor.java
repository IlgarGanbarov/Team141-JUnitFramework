package day16_GetScriinShot;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import test.utilities.ReusableMethods;
import test.utilities.TestBase;

public class C05_JavaScriptExecutor extends TestBase {
    @Test
    public void test01(){

        // Testotomasyonu ana sayfaya gidin
        driver.get("https://www.testotomasyonu.com");
        ReusableMethods.bekle(2);


        //Best Sport Shoes ismine kadar ashagi enin
        WebElement bestSportShoesElementi=driver.findElement(By.xpath("(//*[@class='blog-heading'])[2]"));
        System.out.println(bestSportShoesElementi.getText());

        Actions actions=new Actions(driver);
        actions.moveToElement(bestSportShoesElementi).perform();
        ReusableMethods.bekle(5);
        bestSportShoesElementi.click();
        ReusableMethods.bekle(10);
        driver.get("https://www.wisequarter.com");



        ReusableMethods.bekle(10);

        WebElement whyChoosAsLinki=driver.findElement(By.xpath("//*[text()='Why '] "));

        JavascriptExecutor javascriptExecutor= (JavascriptExecutor) driver;
        javascriptExecutor.executeAsyncScript("arguments[0].scrollIntoView({block: 'center'}); ",whyChoosAsLinki);
        ReusableMethods.bekle(5);

        System.out.println(whyChoosAsLinki.getText());
        ReusableMethods.bekle(5);
        whyChoosAsLinki.click();
        ReusableMethods.bekle(5);

    }
}
