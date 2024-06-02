package day13_seleniumWaits_coockies;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;
import test.utilities.ReusableMethods;
import test.utilities.TestBase;

import java.util.Set;

public class C03_Coocies extends TestBase {

    @Test
    public void cookiesTesti(){

        //1- amazon anasayfaya gidin
        driver.get("https://www.amazon.com");
        ReusableMethods.bekle(20);


        //2- tum cookie’leri listeleyin
        //System.out.println(driver.manage().getCookies());
        Set<Cookie>tumCookiieSeti=driver.manage().getCookies();
        int siraNo=1;
        for (Cookie eachCookie  :tumCookiieSeti ) {

            System.out.println(siraNo+"Cookie"+eachCookie);
            siraNo++;
        }

        //3- Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
        Assertions.assertTrue(tumCookiieSeti.size()>5);
        String expCookieDegeri="USD";
        String actCookieSeti=driver.manage().getCookieNamed("i18n-prefs").getValue();
        Assertions.assertEquals(expCookieDegeri,actCookieSeti);
        //4- ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
        //5- ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie olusturun ve sayfaya ekleyin
        Cookie cookie=new Cookie("en sevdigim cookie","cikolatali");
        driver.manage().addCookie(cookie);
        //6- eklediginiz cookie’nin sayfaya eklendigini test edin
        boolean cikolatalicookievarmi=false;


        for (Cookie eachCookie  :tumCookiieSeti ) {

           if (eachCookie.getName().equals("en sevdigim cookie")){
               cikolatalicookievarmi=true;
           }

        }
        Assertions.assertFalse(cikolatalicookievarmi);
        //7- ismi skin olan cookie’yi silin ve silindigini test edin
        driver.manage().deleteCookieNamed("skin");
        tumCookiieSeti=driver.manage().getCookies();
        boolean skincookievarmi=false;
        for (Cookie eachCookie  :tumCookiieSeti ) {

            if (eachCookie.getName().equals("skin")){
               skincookievarmi=true;
            }

        }
        Assertions.assertFalse(skincookievarmi);

        //8- tum cookie’leri silin ve silindigini test edin
        driver.manage().deleteAllCookies();
        tumCookiieSeti=driver.manage().getCookies();
        Assertions.assertTrue(tumCookiieSeti.size()==0);
    }
}
