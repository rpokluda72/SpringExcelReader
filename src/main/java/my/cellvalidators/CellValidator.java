package my.cellvalidators;

import org.apache.poi.ss.usermodel.Cell;

public interface CellValidator {
    boolean isValid(Cell cell);
}
