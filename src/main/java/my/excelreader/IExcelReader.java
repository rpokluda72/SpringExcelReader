package my.excelreader;

import org.apache.poi.ss.formula.functions.T;

import java.util.ArrayList;

public interface IExcelReader {
    ArrayList<String> getCellValues(String[] args);

//    ArrayList<String> getCellValues();
//    ArrayList<T> getCellValues(ArgumentsReader readerArgs);
}
