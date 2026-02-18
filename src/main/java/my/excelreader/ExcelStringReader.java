package my.excelreader;

import my.cellvalidators.CellTypeValidator;
import org.apache.poi.ss.usermodel.CellType;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ExcelStringReader extends ExcelReader  {

    Logger logger = Logger.getLogger(ExcelStringReader.class.getName());

    public ArrayList<String> getCellValues(String[] args) {
        super.factory.addValidator(new CellTypeValidator(CellType.STRING));
        return super.getCellValues(args);
    }

    public void log(Level level, String textToLog) {
        logger.log(level, textToLog);
        // System.out.println(textToLog);
    }
}
