package day16_GetScriinShot;

import org.apache.poi.hssf.usermodel.HSSFWorkbookFactory;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class C01_WriteExcel {

    @Test
    public void  test01() throws IOException {

        //1) Yeni bir Class olusturalim WriteExcel
        //2) Yeni bir test method olusturalim writeExcelTest()
        //3) Adimlari takip ederek Sayfa1’ kadar gidelim
        String dosyayolu="src/test/java/day15_excelOtomasyonu/ulkeler.xlsx";
        FileInputStream fileInputStream = new FileInputStream(dosyayolu);
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet sayfa1 = workbook.getSheet("Sayfa1");

        //4) 1.satir 5.hucreye yeni bir cell olusturalim
        sayfa1.getRow(0).createCell(4);
        //5) Olusturdugumuz hucreye “Nufus” yazdiralim
        sayfa1.getRow(0).getCell(4).setCellValue("Nufus");
        //6) 2.satir nufus kolonuna 1500000 yazdiralim
        sayfa1.getRow(1).createCell(4).setCellValue(2500000);

        //7) 10.satir nufus kolonuna 250000 yazdiralim
        sayfa1.getRow(9).createCell(4).setCellValue(250000);
        //8) 15.satir nufus kolonuna 54000 yazdiralim
        sayfa1.getRow(14).createCell(4).setCellValue(54000);
        //9) Dosyayi kaydedelim
        // workbook uzerinde yaptigimiz degisiklikleri excel'e kaydetmek istedigimizde
        //  excel dosyasinin acik olmadigindan emin olup
        //  olusturacagimiz FileOutputStream objesi ile bilgileri excel'e kaydedebiliriz

        FileOutputStream fileOutputStream = new FileOutputStream(dosyayolu);
        workbook.write(fileOutputStream);
        //10)Dosyayi kapatalim

        fileInputStream.close();
        fileOutputStream.close();
        workbook.close();
    }
}
