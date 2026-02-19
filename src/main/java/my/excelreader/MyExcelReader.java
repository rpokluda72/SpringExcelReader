package my.excelreader;

import my.cellvalidators.CellValidatorFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * // excel reader type argument not set - used default "pn"
 * java -jar SpringExcelReader-1.0.0.jar l-TestData.xlsx cf-1 ct-1 rf-1 rt-9
 * args=[l-TestData.xlsx, cf-1, ct-1, rf-1, rt-9]
 * readerArgs=ReaderArguments{location='TestData.xlsx', columnFrom=1, columnTo=1, rowFrom=1, rowTo=9, excelReaderType=pn}
 * MyExcelReader-ExcelPrimeNumericReader : values=[3, 13]
 * values=[3, 13]
 *
 * // er-n - ExcelNumericReader
 * java -jar SpringExcelReader-1.0.0.jar l-TestData.xlsx cf-1 ct-1 rf-1 rt-9 er-n
 * args=[l-TestData.xlsx, cf-1, ct-1, rf-1, rt-9, er-n]
 * readerArgs=ReaderArguments{location='TestData.xlsx', columnFrom=1, columnTo=1, rowFrom=1, rowTo=9, excelReaderType=n}
 * MyExcelReader-ExcelNumericReader : values=[154.14, 3, -122, 22, -7, 13]
 * values=[154.14, 3, -122, 22, -7, 13]
 *
 * // er-pn - ExcelPrimeNumericReader
 * java -jar SpringExcelReader-1.0.0.jar l-TestData.xlsx cf-1 ct-1 rf-1 rt-9 er-pn
 * args=[l-TestData.xlsx, cf-1, ct-1, rf-1, rt-9, er-pn]
 * readerArgs=ReaderArguments{location='TestData.xlsx', columnFrom=1, columnTo=1, rowFrom=1, rowTo=9, excelReaderType=pn}
 * MyExcelReader-ExcelPrimeNumericReader : values=[3, 13]
 * values=[3, 13]
 *
 * // er-s - ExcelStringReader
 * java -jar SpringExcelReader-1.0.0.jar l-TestData.xlsx cf-1 ct-1 rf-1 rt-9 er-s
 * args=[l-TestData.xlsx, cf-1, ct-1, rf-1, rt-9, er-s]
 * readerArgs=ReaderArguments{location='TestData.xlsx', columnFrom=1, columnTo=1, rowFrom=1, rowTo=9, excelReaderType=s}
 * MyExcelReader-ExcelStringReader : values=[text B9]
 * values=[text B9]
 *
 * // er-b - ExcelBooleanReader
 * java -jar SpringExcelReader-1.0.0.jar l-TestData.xlsx cf-1 ct-1 rf-1 rt-9 er-b
 * args=[l-TestData.xlsx, cf-1, ct-1, rf-1, rt-9, er-b]
 * readerArgs=ReaderArguments{location='TestData.xlsx', columnFrom=1, columnTo=1, rowFrom=1, rowTo=9, excelReaderType=b}
 * MyExcelReader-ExcelBooleanReader : values=[true]
 * values=[true]
 *
 * // er-f - ExcelFormulaReader
 * java -jar SpringExcelReader-1.0.0.jar l-TestData.xlsx cf-1 ct-1 rf-1 rt-9 er-f
 * args=[l-TestData.xlsx, cf-1, ct-1, rf-1, rt-9, er-f]
 * readerArgs=ReaderArguments{location='TestData.xlsx', columnFrom=1, columnTo=1, rowFrom=1, rowTo=9, excelReaderType=f}
 * MyExcelReader-ExcelFormulaReader : values=[B6+B7]
 * values=[B6+B7]
 *
 * // er-a - used all excel reader types
 * java -jar SpringExcelReader-1.0.0.jar l-TestData.xlsx cf-1 ct-1 rf-1 rt-9 er-a
 * args=[l-TestData.xlsx, cf-1, ct-1, rf-1, rt-9, er-a]
 * readerArgs=ReaderArguments{location='TestData.xlsx', columnFrom=1, columnTo=1, rowFrom=1, rowTo=9, excelReaderType=a}
 * MyExcelReader-ExcelNumericReader : values=[154.14, 3, -122, 22, -7, 13]
 * MyExcelReader-ExcelPrimeNumericReader : values=[3, 13]
 * MyExcelReader-ExcelStringReader : values=[text B9]
 * MyExcelReader-ExcelBooleanReader : values=[true]
 * MyExcelReader-ExcelFormulaReader : values=[B6+B7]
 * values=[154.14, 3, -122, 22, -7, 13, 3, 13, text B9, true, B6+B7]
 *
 * // arguments not set - all sheet cells checked, used default excel reader type "pn"
 *
 * java -jar SpringExcelReader-1.0.0.jar l-TestData.xlsx
 * args=[l-TestData.xlsx]
 * readerArgs=ReaderArguments{location='TestData.xlsx', columnFrom=0, columnTo=-1, rowFrom=0, rowTo=-1, excelReaderType=pn}
 * MyExcelReader-ExcelPrimeNumericReader : values=[13, 3, 17, 7, 11, 13, 47, 11]
 * values=[13, 3, 17, 7, 11, 13, 47, 11]
 */
public class MyExcelReader {

    Logger logger = Logger.getLogger(MyExcelReader.class.getName());

    ArrayList<String> allValues = new ArrayList<>();

    public void read(String[] args) {
        log(Level.INFO, "args=" + Arrays.toString(args));
        ArgumentsReader readerArgs = new ArgumentsReader(args);
//        log(Level.INFO, "readerArgs=" + readerArgs);
        if (readerArgs.getExcelReaderType().equals(ExcelReaderType.NUMERIC_READER.getType())) {
            runExcelNumericReader(args);
        } else if (readerArgs.getExcelReaderType().equals(ExcelReaderType.PRIME_NUMERIC_READER.getType())) {
            runExcelPrimeNumericReader(args);
        } else if (readerArgs.getExcelReaderType().equals(ExcelReaderType.STRING_READER.getType())) {
            runExcelStringReader(args);
        } else if (readerArgs.getExcelReaderType().equals(ExcelReaderType.BOOLEAN_READER.getType())) {
            runExcelBooleanReader(args);
        } else if (readerArgs.getExcelReaderType().equals(ExcelReaderType.FORMULA_READER.getType())) {
            runExcelFormulaReader(args);
        } else if (readerArgs.getExcelReaderType().equals(ExcelReaderType.INFO_READER.getType()) || readerArgs.getExcelReaderType().equals(ExcelReaderType.TABLE_READER.getType())) {
            runExcelInfoReader(args);
        } else if (readerArgs.getExcelReaderType().equals(ExcelReaderType.ALL_TYPES_READER.getType())) {
            runExcelNumericReader(args);
            runExcelPrimeNumericReader(args);
            runExcelStringReader(args);
            runExcelBooleanReader(args);
            runExcelFormulaReader(args);
        }
    }

    private void runExcelNumericReader(String[] args) {
        ExcelNumericReader reader = new ExcelNumericReader();
        ArrayList<String> values = reader.getCellValues(args);
        allValues.addAll(values);
        log(Level.INFO, "MyExcelReader-ExcelNumericReader : values=" + values);
    }

    private void runExcelPrimeNumericReader(String[] args) {
        ExcelPrimeNumericReader reader = new ExcelPrimeNumericReader();
        ArrayList<String> values = reader.getCellValues(args);
        allValues.addAll(values);
        log(Level.INFO, "MyExcelReader-ExcelPrimeNumericReader : values=" + values);
    }

    private void runExcelStringReader(String[] args) {
        ExcelStringReader reader = new ExcelStringReader();
        ArrayList<String> values = reader.getCellValues(args);
        allValues.addAll(values);
        log(Level.INFO, "MyExcelReader-ExcelStringReader : values=" + values);
    }

    private void runExcelBooleanReader(String[] args) {
        ExcelBooleanReader reader = new ExcelBooleanReader();
        ArrayList<String> values = reader.getCellValues(args);
        allValues.addAll(values);
        log(Level.INFO, "MyExcelReader-ExcelBooleanReader : values=" + values);
    }

    private void runExcelFormulaReader(String[] args) {
        ExcelFormulaReader reader = new ExcelFormulaReader();
        ArrayList<String> values = reader.getCellValues(args);
        allValues.addAll(values);
        log(Level.INFO, "MyExcelReader-ExcelFormulaReader : values=" + values);
    }


    private void runExcelInfoReader(String[] args) {
        ExcelInfoReader reader = new ExcelInfoReader();
        ArgumentsReader readerArgs = new ArgumentsReader(args);
        ExcellSheetInfo info = reader.getInfo(args);
        if (readerArgs.getExcelReaderType().equals(ExcelReaderType.INFO_READER.getType())) {
            for (ExcellCellInfo cell : info.getCells()) {
                allValues.add(cell.toString());
            }
        } else if (readerArgs.getExcelReaderType().equals(ExcelReaderType.TABLE_READER.getType())) {
            allValues.add(info.print());
        }
        log(Level.INFO, "MyExcelReader-ExcelInfoReader \n" + allValues);
    }

    public ArrayList<String> getAllValues() {
        return allValues;
    }

    public void setAllValues(ArrayList<String> allValues) {
        this.allValues = allValues;
    }

    public void log(Level level, String textToLog) {
//        logger.log(level, textToLog);
         System.out.println(textToLog);
    }
}
