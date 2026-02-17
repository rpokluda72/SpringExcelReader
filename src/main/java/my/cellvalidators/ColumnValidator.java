package my.cellvalidators;

import org.apache.poi.ss.usermodel.Cell;

public class ColumnValidator implements CellValidator {

    int columnFrom;
    int columnTo;

    public ColumnValidator(int columnFrom, int columnTo) {
        this.columnFrom = columnFrom;
        this.columnTo = columnTo;
    }

    @Override
    public boolean isValid(Cell cell) {
        return cell.getColumnIndex() >= columnFrom && cell.getColumnIndex() <= columnTo;
    }
}
