package excelUtils;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class GettingDataFromExcel {

    public static String getDataFromExcel() throws IOException {
        FileInputStream fis = new FileInputStream("\"C:\\Users\\ponnu\\IdeaProjects\\RestAssuredTestMonday\\src\\test\\java\\resources\\TestDataGetRequest.xlsx\"");
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet("Sheet1");
             Row row = sheet.getRow(1);
           return  row.getCell(0).getStringCellValue();
    }

}
