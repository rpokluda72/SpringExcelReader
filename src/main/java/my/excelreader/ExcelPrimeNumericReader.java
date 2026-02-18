package my.excelreader;

import my.cellvalidators.PrimeNumberValidator;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ExcelPrimeNumericReader extends ExcelNumericReader {

    Logger logger = Logger.getLogger(ExcelPrimeNumericReader.class.getName());

    public ArrayList<String> getCellValues(String[] args) {
        super.factory.addValidator(new PrimeNumberValidator());
        return super.getCellValues(args);
    }

    public void log(Level level, String textToLog) {
        logger.log(level, textToLog);
        // System.out.println(textToLog);
    }
}
