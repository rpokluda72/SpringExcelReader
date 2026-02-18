package my.excelreader;

import my.cellvalidators.CellTypeValidator;
import my.cellvalidators.CellValidatorFactory;
import my.cellvalidators.PrimeNumberValidator;
import my.filereaders.FileExcelReader;
import my.utils.CellUtils;
import org.apache.poi.ss.formula.functions.T;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ExcelReader implements IExcelReader {

    Logger logger = Logger.getLogger(ExcelReader.class.getName());

    CellValidatorFactory factory = new CellValidatorFactory();

    @Override
    public ArrayList<String> getCellValues(String[] args) {
        // log(Level.INFO, "args=" + Arrays.toString(args));
        ArgumentsReader readerArgs = new ArgumentsReader(args);
        return getCellValues(readerArgs);
    }

    private ArrayList<String> getCellValues(ArgumentsReader readerArgs) {
        factory.setValidatorsFromArguments(readerArgs);
        FileExcelReader fileExcelReader = new FileExcelReader();
        Sheet sheet;
        if (readerArgs.getLocation().startsWith("C:")) {
            sheet = fileExcelReader.getSheetByFilePath(readerArgs.getLocation(), 0);
        } else {
            sheet = fileExcelReader.getSheet(readerArgs.getLocation(), 0);
        }
        return getCellValuesFromSheet(readerArgs, sheet);
    }

    private ArrayList<String> getCellValuesFromSheet(ArgumentsReader readerArgs, Sheet sheet) {
        ArrayList<String> values = new ArrayList<>();
        if (sheet == null) {
            return values;
        }

        for (Row row : sheet) {
            for (Cell cell : row) {
                // CellUtils.printCell(cell);
                if (factory.isValid(cell)) {
                    values.add(CellUtils.getCellValue(cell));
                }
            }
        }
        return values;
    }

    public CellValidatorFactory getFactory() {
        return factory;
    }

    public void setFactory(CellValidatorFactory factory) {
        this.factory = factory;
    }

    public void log(Level level, String textToLog) {
        logger.log(level, textToLog);
        // System.out.println(textToLog);
    }
}
