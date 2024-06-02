package day12_fakerClass_failTestleri;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import test.utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class C03_FileExistTesti {

    @Test
    public void test01(){
        //day12 package altinda upload.png dosyasinin oldugunu test edin
        //selenium Webdriver ile calisir
        //WebDriver objesi olsn driver ile istediyimiz sayfaya gider
        //istedigimiz webelementi kullanir,istedigimiz bilgileri aliriz
        //ama driver objemiz bilgisayirimiza mudahele edemez

        String dosyaYolu="src/main/java/test/day12_fakerClass_failTestleri/upload.png";
        Assertions.assertTrue(Files.exists(Paths.get(dosyaYolu)));
    }
}
