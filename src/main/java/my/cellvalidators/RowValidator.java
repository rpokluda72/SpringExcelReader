package my.cellvalidators;

import org.apache.poi.ss.usermodel.Cell;

public class RowValidator implements CellValidator {
    
    int rowFrom;
    int rowTo;

    public RowValidator(int rowFrom, int rowTo) {
        this.rowFrom = rowFrom;
        this.rowTo = rowTo;
    }

    @Override
    public boolean isValid(Cell cell) {
        return cell.getRowIndex() >= rowFrom && cell.getRowIndex() <= rowTo;
    }
}
