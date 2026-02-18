package my.cellvalidators;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;

public class CellTypeValidator implements CellValidator {

    CellType type;

    public CellTypeValidator(CellType type) {
        this.type = type;
    }

    @Override
    public boolean isValid(Cell cell) {
        return cell.getCellType().equals(type);
    }
}
