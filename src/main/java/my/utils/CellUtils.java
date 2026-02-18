package my.utils;

import org.apache.poi.ss.formula.functions.T;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;

public class CellUtils {

    public static boolean isValidCell(Cell cell, CellType type) {
        return cell.getCellType().equals(type);
    }

    public static String getCellValue(Cell cell) {
        return switch (cell.getCellType()) {
            case STRING -> cell.getStringCellValue();
            case NUMERIC -> getIntegerFromDoubleIfPossible(cell.getNumericCellValue()); // String.valueOf(cell.getNumericCellValue());
            case BOOLEAN -> String.valueOf(cell.getBooleanCellValue());
            case FORMULA -> cell.getCellFormula();
            default -> null;
        };
    }

    private static String getIntegerFromDoubleIfPossible(double number) {
        if (!(Double.isNaN(number) || Double.isInfinite(number)) && (int) number == number) {
            return String.valueOf((int) number);
        }
        return String.valueOf(number);
    }

//    public static <T> T getCellValue2(Cell cell) {
//        return switch (cell.getCellType()) {
//            case STRING -> (T) cell.getStringCellValue();
//            case NUMERIC -> (T) String.valueOf(cell.getNumericCellValue());
//            case BOOLEAN -> (T) String.valueOf(cell.getBooleanCellValue());
//            default -> null;
//        };
//    }

    // for development only
    public static void printCell(Cell cell) {
        System.out.println("printCell : getCellType=" + cell.getCellType() + ", value=" + getCellValue(cell) + ", getRowIndex=" + cell.getRowIndex() + ", getColumnIndex=" + cell.getColumnIndex());
    }
}
