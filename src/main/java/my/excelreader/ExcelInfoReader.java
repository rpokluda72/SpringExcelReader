package my.excelreader;

import my.cellvalidators.CellValidatorFactory;
import my.filereaders.FileExcelReader;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ExcelInfoReader {

    Logger logger = Logger.getLogger(ExcelInfoReader.class.getName());
    CellValidatorFactory factory = new CellValidatorFactory();

    public ExcellSheetInfo getInfo(String[] args) {
        log(Level.INFO, "args=" + Arrays.toString(args));
        ArgumentsReader readerArgs = new ArgumentsReader(args);
        return getInfo(readerArgs);
    }

    private ExcellSheetInfo getInfo(ArgumentsReader readerArgs) {
        factory.setValidatorsFromArguments(readerArgs);
        FileExcelReader fileExcelReader = new FileExcelReader();
        Sheet sheet;
        if (readerArgs.getLocation().startsWith("C:")) {
            sheet = fileExcelReader.getSheetByFilePath(readerArgs.getLocation(), 0);
        } else {
            sheet = fileExcelReader.getSheet(readerArgs.getLocation(), 0);
        }
        return getInfoFromSheet(sheet);
    }

    private ExcellSheetInfo getInfoFromSheet(Sheet sheet) {
        if (sheet == null) {
            return null;
        }
        ExcellSheetInfo info = new ExcellSheetInfo();

        for (Row row : sheet) {
            for (Cell cell : row) {
                if (factory.isValid(cell)) {
                    info.addCell(new ExcellCellInfo(cell));
                }
            }
        }
//        log(Level.INFO, "info.getCells().size()=" + info.getCells().size());
        return info;
    }

    public void log(Level level, String textToLog) {
        logger.log(level, textToLog);
//         System.out.println(textToLog);
    }
}
