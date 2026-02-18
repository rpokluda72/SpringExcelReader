package my.excelreader;

import org.apache.poi.ss.formula.functions.T;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.logging.Level;

@SpringBootApplication
public class ExcelReaderApplication {

    public static void main(String[] args) {

        MyExcelReader reader = new MyExcelReader();
        ArrayList<String> values = reader.read(args);
        reader.log(Level.INFO, "values=" + values);

        // *  excel reader type argument not set - used default "pn"
        //        java -jar SpringExcelReader-1.0.0.jar l-TestData.xlsx cf-1 ct-1 rf-1 rt-9
        //        args=[l-TestData.xlsx, cf-1, ct-1, rf-1, rt-9]
        //        readerArgs=ReaderArguments{location='TestData.xlsx', columnFrom=1, columnTo=1, rowFrom=1, rowTo=9, excelReaderType=pn}
        //        MyExcelReader-ExcelPrimeNumericReader : values=[3, 13]
        //        values=[3, 13]
        //
        // *  er-n - ExcelNumericReader
        //        java -jar SpringExcelReader-1.0.0.jar l-TestData.xlsx cf-1 ct-1 rf-1 rt-9 er-n
        //        args=[l-TestData.xlsx, cf-1, ct-1, rf-1, rt-9, er-n]
        //        readerArgs=ReaderArguments{location='TestData.xlsx', columnFrom=1, columnTo=1, rowFrom=1, rowTo=9, excelReaderType=n}
        //        MyExcelReader-ExcelNumericReader : values=[154.14, 3, -122, 22, -7, 13]
        //        values=[154.14, 3, -122, 22, -7, 13]
        //
        // *  er-pn - ExcelPrimeNumericReader
        //        java -jar SpringExcelReader-1.0.0.jar l-TestData.xlsx cf-1 ct-1 rf-1 rt-9 er-pn
        //        args=[l-TestData.xlsx, cf-1, ct-1, rf-1, rt-9, er-pn]
        //        readerArgs=ReaderArguments{location='TestData.xlsx', columnFrom=1, columnTo=1, rowFrom=1, rowTo=9, excelReaderType=pn}
        //        MyExcelReader-ExcelPrimeNumericReader : values=[3, 13]
        //        values=[3, 13]
        //
        // *  er-s - ExcelStringReader
        //        java -jar SpringExcelReader-1.0.0.jar l-TestData.xlsx cf-1 ct-1 rf-1 rt-9 er-s
        //        args=[l-TestData.xlsx, cf-1, ct-1, rf-1, rt-9, er-s]
        //        readerArgs=ReaderArguments{location='TestData.xlsx', columnFrom=1, columnTo=1, rowFrom=1, rowTo=9, excelReaderType=s}
        //        MyExcelReader-ExcelStringReader : values=[text B9]
        //        values=[text B9]
        //
        // *  er-b - ExcelBooleanReader
        //        java -jar SpringExcelReader-1.0.0.jar l-TestData.xlsx cf-1 ct-1 rf-1 rt-9 er-b
        //        args=[l-TestData.xlsx, cf-1, ct-1, rf-1, rt-9, er-b]
        //        readerArgs=ReaderArguments{location='TestData.xlsx', columnFrom=1, columnTo=1, rowFrom=1, rowTo=9, excelReaderType=b}
        //        MyExcelReader-ExcelBooleanReader : values=[true]
        //        values=[true]
        //
        // *  er-f - ExcelFormulaReader
        //        java -jar SpringExcelReader-1.0.0.jar l-TestData.xlsx cf-1 ct-1 rf-1 rt-9 er-f
        //        args=[l-TestData.xlsx, cf-1, ct-1, rf-1, rt-9, er-f]
        //        readerArgs=ReaderArguments{location='TestData.xlsx', columnFrom=1, columnTo=1, rowFrom=1, rowTo=9, excelReaderType=f}
        //        MyExcelReader-ExcelFormulaReader : values=[B6+B7]
        //        values=[B6+B7]
        //
        // *  er-a - used all excel reader types
        //        java -jar SpringExcelReader-1.0.0.jar l-TestData.xlsx cf-1 ct-1 rf-1 rt-9 er-a
        //        args=[l-TestData.xlsx, cf-1, ct-1, rf-1, rt-9, er-a]
        //        readerArgs=ReaderArguments{location='TestData.xlsx', columnFrom=1, columnTo=1, rowFrom=1, rowTo=9, excelReaderType=a}
        //        MyExcelReader-ExcelNumericReader : values=[154.14, 3, -122, 22, -7, 13]
        //        MyExcelReader-ExcelPrimeNumericReader : values=[3, 13]
        //        MyExcelReader-ExcelStringReader : values=[text B9]
        //        MyExcelReader-ExcelBooleanReader : values=[true]
        //        MyExcelReader-ExcelFormulaReader : values=[B6+B7]
        //        values=[154.14, 3, -122, 22, -7, 13, 3, 13, text B9, true, B6+B7]
        //
        // *  arguments not set - all sheet cells checked, used default excel reader type "pn"
        //
        //        java -jar SpringExcelReader-1.0.0.jar l-TestData.xlsx
        //        args=[l-TestData.xlsx]
        //        readerArgs=ReaderArguments{location='TestData.xlsx', columnFrom=0, columnTo=-1, rowFrom=0, rowTo=-1, excelReaderType=pn}
        //        MyExcelReader-ExcelPrimeNumericReader : values=[13, 3, 17, 7, 11, 13, 47, 11]
        //        values=[13, 3, 17, 7, 11, 13, 47, 11]

        SpringApplication.run(ExcelReaderApplication.class, args);
    }

}
