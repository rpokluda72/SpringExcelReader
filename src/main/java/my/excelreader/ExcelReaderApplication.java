package my.excelreader;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExcelReaderApplication {

    public static void main(String[] args) {

        MyExcelReader reader = new MyExcelReader();
        reader.read(args);

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
        //
        // * use absolute path
        //        java -jar SpringExcelReader-1.0.0.jar l-C:\Users\roman\Work\pohovor\projects\java\excelReader\SpringExcelReader\src\main\resources\TestData.xlsx  cf-2 ct-2 rf-1 rt-9
        //        args=[l-C:\Users\roman\Work\pohovor\projects\java\excelReader\SpringExcelReader\src\main\resources\TestData.xlsx, cf-2, ct-2, rf-1, rt-9]
        //        readerArgs=ReaderArguments{location='C:\Users\roman\Work\pohovor\projects\java\excelReader\SpringExcelReader\src\main\resources\TestData.xlsx', columnFrom=2, columnTo=2, rowFrom=1, rowTo=9, excelReaderType=pn}
        //        MyExcelReader-ExcelPrimeNumericReader : values=[17, 11, 47]
        //        values=[17, 11, 47]
        //
        // * use excel info reader - info
        //        java -jar SpringExcelReader-1.0.0.jar l-TestData.xlsx cf-1 ct-1 rf-1 rt-9 er-i
        //        args=[l-TestData.xlsx, cf-1, ct-1, rf-1, rt-9, er-i]
        //        readerArgs=ReaderArguments{location='TestData.xlsx', columnFrom=1, columnTo=1, rowFrom=1, rowTo=9, excelReaderType=i}
        //        MyExcelReader-ExcelInfoReader
        //        * * * Info * * *
        //        ExcellCellInfo = {type=NUMERIC, rowIndex=1, columnIndex=1, value='154.14'}
        //        ExcellCellInfo = {type=NUMERIC, rowIndex=2, columnIndex=1, value='3'}
        //        ExcellCellInfo = {type=BOOLEAN, rowIndex=3, columnIndex=1, value='true'}
        //        ExcellCellInfo = {type=NUMERIC, rowIndex=4, columnIndex=1, value='-122'}
        //        ExcellCellInfo = {type=NUMERIC, rowIndex=5, columnIndex=1, value='22'}
        //        ExcellCellInfo = {type=NUMERIC, rowIndex=6, columnIndex=1, value='-7'}
        //        ExcellCellInfo = {type=FORMULA, rowIndex=7, columnIndex=1, value='B6+B7'}
        //        ExcellCellInfo = {type=STRING, rowIndex=8, columnIndex=1, value='text B9'}
        //        ExcellCellInfo = {type=NUMERIC, rowIndex=9, columnIndex=1, value='13'}
        //
        // * use excel info reader - table
        //        java -jar SpringExcelReader-1.0.0.jar l-TestData.xlsx cf-1 ct-2 rf-3 rt-6 er-t
        //        args=[l-TestData.xlsx, cf-1, ct-2, rf-3, rt-6, er-t]
        //        MyExcelReader-ExcelInfoReader
        //        - - - Table - - -
        //          |    B    |    C    |
        //        -----------------------
        //        3 |  true   |   17    |
        //        4 |  -122   | text A5 |
        //        5 |   22    |  true   |
        //        6 |   -7    |   11    |

        SpringApplication.run(ExcelReaderApplication.class, args);
    }

}
