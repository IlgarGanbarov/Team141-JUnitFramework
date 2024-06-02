package day16_GetScriinShot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class C06_UnitTest {

    public boolean teksayiKontrolu(int kontrolEdilecekSayi){

        boolean sonuc=kontrolEdilecekSayi%2==0?false:true;
        return sonuc;




    }
    @Test
    public void unitTestTekSayi(){

        Random random=new Random();
        int testsayisi=random.nextInt(1000000);

        if (testsayisi %2==0){
            Assertions.assertFalse(teksayiKontrolu(testsayisi));
        }else {
            Assertions.assertTrue(teksayiKontrolu(testsayisi));
        }




    }
}
