package my.excelreader;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

@SpringBootApplication
public class ExcelReaderApplication {

    public static void main(String[] args) {

        MyExcelReader myExcelReader = new MyExcelReader();
        ArrayList<Integer> primeNumbers = myExcelReader.getSheetPrimeNumbers(args);

        // myExcelReader.log(Level.INFO, "primeNumbers=" + primeNumbers);
        // PS C:\Users\roman\Work\pohovor\projects\java\excelReader\SpringExcelReader\target> java -jar SpringExcelReader-1.0.0.jar l-TestData.xlsx cf-2 ct-2 rf-1 rt-9
        // úno 17, 2026 12:51:12 ODP. my.excelreader.MyExcelReader log
        // INFO: args=[l-TestData.xlsx, cf-2, ct-2, rf-1, rt-9]
        // ReaderArguments{location='TestData.xlsx', columnFrom=2, columnTo=2, rowFrom=1, rowTo=9}
        // úno 17, 2026 12:51:13 ODP. my.excelreader.MyExcelReader log
        // INFO: primeNumbers=[17, 7, 11]

        // PS C:\Users\roman\Work\pohovor\projects\java\excelReader\SpringExcelReader\target> java -jar SpringExcelReader-1.0.0.jar l-TestData.xlsx cf-1 ct-1 rf-1 rt-9
        // úno 17, 2026 12:52:55 ODP. my.excelreader.MyExcelReader log
        // INFO: args=[l-TestData.xlsx, cf-1, ct-1, rf-1, rt-9]
        // ReaderArguments{location='TestData.xlsx', columnFrom=1, columnTo=1, rowFrom=1, rowTo=9}
        // úno 17, 2026 12:52:56 ODP. my.excelreader.MyExcelReader log
        // INFO: primeNumbers=[3, 11]

        // PS C:\Users\roman\Work\pohovor\projects\java\excelReader\SpringExcelReader\target> java -jar SpringExcelReader-1.0.0.jar l-C:\Users\roman\Work\pohovor\projects\java\excelReader\SpringExcelReader\src\main\resources\TestData.xlsx
        //úno 17, 2026 3:32:00 ODP. my.excelreader.MyExcelReader log
        //INFO: args=[l-C:\Users\roman\Work\pohovor\projects\java\excelReader\SpringExcelReader\src\main\resources\TestData.xlsx]
        //ReaderArguments{location='C:\Users\roman\Work\pohovor\projects\java\excelReader\SpringExcelReader\src\main\resources\TestData.xlsx', columnFrom=0, columnTo=-1, rowFrom=0, rowTo=-1}
        //úno 17, 2026 3:32:01 ODP. my.excelreader.MyExcelReader log
        //INFO: primeNumbers=[13, 3, 17, 7, 7, 11, 11, 11]

        //PS C:\Users\roman\Work\pohovor\projects\java\excelReader\SpringExcelReader\target> java -jar SpringExcelReader-1.0.0.jar l-C:\Users\roman\Work\pohovor\projects\java\excelReader\SpringExcelReader\src\main\resources\TestData.xlsx  cf-2 ct-2 rf-1 rt-9
        //úno 17, 2026 3:33:22 ODP. my.excelreader.MyExcelReader log
        //INFO: args=[l-C:\Users\roman\Work\pohovor\projects\java\excelReader\SpringExcelReader\src\main\resources\TestData.xlsx, cf-2, ct-2, rf-1, rt-9]
        //ReaderArguments{location='C:\Users\roman\Work\pohovor\projects\java\excelReader\SpringExcelReader\src\main\resources\TestData.xlsx', columnFrom=2, columnTo=2, rowFrom=1, rowTo=9}
        //úno 17, 2026 3:33:23 ODP. my.excelreader.MyExcelReader log
        //INFO: primeNumbers=[17, 7, 11]

        SpringApplication.run(ExcelReaderApplication.class, args);
    }

}
