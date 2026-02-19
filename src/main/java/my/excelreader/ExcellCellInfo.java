package my.excelreader;

import my.utils.CellUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;

public class ExcellCellInfo {

    CellType type;
    int rowIndex;
    int columnIndex;
    String value;

    public ExcellCellInfo(CellType type, int rowIndex, int columnIndex, String value) {
        this.type = type;
        this.rowIndex = rowIndex;
        this.columnIndex = columnIndex;
        this.value = value;
    }

    public ExcellCellInfo(Cell cell) {
        this.type = cell.getCellType();
        this.rowIndex = cell.getRowIndex();
        this.columnIndex = cell.getColumnIndex();
        this.value = CellUtils.getCellValue(cell);
    }

    public CellType getType() {
        return type;
    }

    public void setType(CellType type) {
        this.type = type;
    }

    public int getRowIndex() {
        return rowIndex;
    }

    public void setRowIndex(int rowIndex) {
        this.rowIndex = rowIndex;
    }

    public int getColumnIndex() {
        return columnIndex;
    }

    public void setColumnIndex(int columnIndex) {
        this.columnIndex = columnIndex;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "ExcellCellInfo = {" +
                "type=" + type +
                ", rowIndex=" + rowIndex +
                ", columnIndex=" + columnIndex +
                ", value='" + value + '\'' +
                '}';
    }
}
