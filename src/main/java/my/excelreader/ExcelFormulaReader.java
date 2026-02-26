package my.excelreader;

import my.cellvalidators.CellTypeValidator;
import org.apache.poi.ss.usermodel.CellType;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ExcelFormulaReader extends ExcelReader {

    Logger logger = Logger.getLogger(ExcelFormulaReader.class.getName());

    public ExcelFormulaReader(String[] args) {
        super(args);
        super.factory.addValidator(new CellTypeValidator(CellType.FORMULA));
    }

    public ArrayList<String> getCellValues(String[] args) {
//        super.factory.addValidator(new CellTypeValidator(CellType.FORMULA));
        return super.getCellValues(args);
    }

    public void log(Level level, String textToLog) {
        logger.log(level, textToLog);
        // System.out.println(textToLog);
    }
}
