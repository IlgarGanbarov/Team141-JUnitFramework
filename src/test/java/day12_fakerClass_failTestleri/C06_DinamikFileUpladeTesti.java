package day12_fakerClass_failTestleri;

import org.junit.jupiter.api.Test;
import test.utilities.TestBase;

public class C06_DinamikFileUpladeTesti extends TestBase {
    @Test
    public void test01(){

        //1.https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");
//2.chooseFile butonuna basalim dosyayolu
        String dosyayolu="C:\\Users\\qenbe\\Desktop\\team1414_JUnit\\src\\main\\java\\test\\day12_fakerClass_failTestleri\\upload.png";
//3.day12 altindaki upload.png dosyasini dinamik olarak secelim.
//4.Upload butonuna basalim.
//5."File Uploaded!" textinin goruntulendigini test edelim.
    }

}
