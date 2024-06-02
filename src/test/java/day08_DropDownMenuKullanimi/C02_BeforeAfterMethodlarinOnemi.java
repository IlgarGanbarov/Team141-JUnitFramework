package day08_DropDownMenuKullanimi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C02_BeforeAfterMethodlarinOnemi {


    @Test
    public void aramaTesti(){

        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       driver.get("https://www.testotomasyonu.com");
       WebElement aramakutusu=driver.findElement(By.id("global-Search"));
       aramakutusu.sendKeys("phone"+ Keys.ENTER);
       List<WebElement>bulunanUrunElementleriList=driver.findElements(By.className("prod-img"));
       Assertions.assertTrue(bulunanUrunElementleriList.size()>0);

       driver.quit();



    }



}
