package my.excelreader;

import org.apache.poi.ss.formula.functions.T;

import java.util.ArrayList;

public interface IExcelReader {
    ArrayList<String> getCellValues(String[] args);

//    ArrayList<T> getCellValues(ArgumentsReader readerArgs);
}
