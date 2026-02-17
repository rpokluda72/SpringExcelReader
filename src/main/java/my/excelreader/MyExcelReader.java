package my.excelreader;


import my.cellvalidators.CellValidatorFactory;
import my.cellvalidators.PrimeNumberValidator;
import my.filereaders.ExcelReader;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MyExcelReader {

    Logger logger = Logger.getLogger(MyExcelReader.class.getName());

    public ArrayList<Integer> getSheetPrimeNumbers(String[] args) {
        log(Level.INFO, "args=" + Arrays.toString(args));
        ArgumentsReader readerArgs = new ArgumentsReader(args);
        return getSheetPrimeNumbers(readerArgs);
    }

    private ArrayList<Integer> getSheetPrimeNumbers(ArgumentsReader readerArgs) {
        ExcelReader excelReader = new ExcelReader();
        Sheet sheet = excelReader.getSheet(readerArgs.getLocation(), 0);
        return getPrimeNumbersFromSheet(readerArgs, sheet);
    }

    private ArrayList<Integer> getPrimeNumbersFromSheet(ArgumentsReader readerArgs, Sheet sheet) {
        ArrayList<Integer> primeNumbers = new ArrayList<>();
        if (sheet == null) {
            return primeNumbers;
        }
        CellValidatorFactory factory = new CellValidatorFactory();
        factory.setValidatorsFromArguments(readerArgs);
        factory.addValidator(new PrimeNumberValidator());

        for (Row row : sheet) {
            for (Cell cell : row) {
                if (factory.isValid(cell)) {
                    primeNumbers.add((int) cell.getNumericCellValue());
                }
            }
        }
        log(Level.INFO,"primeNumbers=" + primeNumbers);
        return primeNumbers;
    }

    public void log(Level level, String textToLog) {
        logger.log(level, textToLog);
        // System.out.println(textToLog);
    }
}
