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

        SpringApplication.run(ExcelReaderApplication.class, args);
    }

}
