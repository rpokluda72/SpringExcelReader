package my.utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;

public class CellUtils {

    public static boolean isValidCell(Cell cell, CellType type) {
        return cell.getCellType().equals(type);
    }

    public static String getCellValue(Cell cell) {
        return switch (cell.getCellType()) {
            case STRING -> cell.getStringCellValue();
            case NUMERIC -> String.valueOf(cell.getNumericCellValue());
            case BOOLEAN -> String.valueOf(cell.getBooleanCellValue());
            default -> null;
        };
    }

    // for development only
    public static void printCell(Cell cell) {
        System.out.println("printCell : getCellType=" + cell.getCellType() + ", value=" + getCellValue(cell) + ", getRowIndex=" + cell.getRowIndex() + ", getColumnIndex=" + cell.getColumnIndex());
    }
}
