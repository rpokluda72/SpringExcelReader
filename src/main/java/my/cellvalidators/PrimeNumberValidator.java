package my.cellvalidators;

import my.utils.NumericUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;

public class PrimeNumberValidator implements CellValidator {

    @Override
    public boolean isValid(Cell cell) {
        try {
            if (!cell.getCellType().equals(CellType.NUMERIC)) {
                return false;
            }
            double cellValue = cell.getNumericCellValue();

            return NumericUtils.isInteger(cellValue) && NumericUtils.isPrime((int) cellValue);
        } catch (Exception e) {
            return false;
        }
    }
}
