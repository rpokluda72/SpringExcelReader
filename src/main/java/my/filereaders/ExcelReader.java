package my.filereaders;

import my.excelreader.MyExcelReader;
import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ExcelReader {

    Logger logger = Logger.getLogger(ExcelReader.class.getName());

    public Workbook getWorkbook(String fileLocation) {
        try (InputStream inputStream = ExcelReader.class.getClassLoader().getResourceAsStream(fileLocation)) {
            if (inputStream == null) {
                log(Level.INFO,"File " + fileLocation + " not found!");
                return null;
            }
            return WorkbookFactory.create(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Workbook getWorkbookByFilePath(String filePath) {
        try (InputStream inp = new FileInputStream(filePath)) {
            return WorkbookFactory.create(inp);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Sheet getSheet(String fileLocation, String sheetName) {
        Workbook workbook = getWorkbook(fileLocation);
        return workbook.getSheet(sheetName);
    }

    public Sheet getSheet(String fileLocation, int sheetIndex) {
        Workbook workbook = getWorkbook(fileLocation);
        if (workbook != null) {
            return workbook.getSheetAt(sheetIndex);
        }
        return null;
    }

    public Sheet getSheetByFilePath(String filePath, int sheetIndex) {
        Workbook workbook = getWorkbookByFilePath(filePath);
        if (workbook != null) {
            return workbook.getSheetAt(sheetIndex);
        }
        return null;
    }

    public Sheet getSheet(Workbook workbook, String sheetName) {
        return workbook.getSheet(sheetName);
    }

    public Sheet getSheet(Workbook workbook, int sheetIndex) {
        return workbook.getSheetAt(sheetIndex);
    }

    private void log(Level level, String textToLog) {
        logger.log(level, textToLog);
//        System.out.println(textToLog);
    }
}
