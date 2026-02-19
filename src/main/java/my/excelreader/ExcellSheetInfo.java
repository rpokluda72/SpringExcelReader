package my.excelreader;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;

import java.util.ArrayList;
import java.util.Arrays;

public class ExcellSheetInfo {

    String[] colHeaders = {"A", "B", "C", "D"};
    private ArrayList<ExcellCellInfo> cells = new ArrayList<>();

    public ArrayList<ExcellCellInfo> getCells() {
        return cells;
    }

    public void setCells(ArrayList<ExcellCellInfo> cells) {
        this.cells = cells;
    }

    public void addCell(ExcellCellInfo cell) {
        this.cells.add(cell);
    }

    public ExcellCellInfo getCell(int rowIndex, int columnIndex) {
        for (ExcellCellInfo cell : cells) {
            if (cell.getRowIndex() == rowIndex && cell.getColumnIndex() == columnIndex) {
                return cell;
            }
        }
        return null;
    }

    public ArrayList<ExcellCellInfo> getRow(int rowIndex) {
        ArrayList<ExcellCellInfo> sel = new ArrayList<>();
        for (ExcellCellInfo cell : cells) {
            if (cell.getRowIndex() == rowIndex) {
                sel.add(cell);
            }
        }
        return sel;
    }

    public ArrayList<ExcellCellInfo> getColumn(int columnIndex) {
        ArrayList<ExcellCellInfo> sel = new ArrayList<>();
        for (ExcellCellInfo cell : cells) {
            if (cell.getColumnIndex() == columnIndex) {
                sel.add(cell);
            }
        }
        return sel;
    }

    public int getMaxColumnIndex(int rowIndex) {
        int max = -1;
        for (ExcellCellInfo cell : getRow(rowIndex)) {
            if (cell.getColumnIndex() > max) {
                max = cell.getColumnIndex();
            }
        }
        return max;
    }

    public int getMinColumnIndex() {
        int min = cells.get(0).getColumnIndex();
        for (ExcellCellInfo cell : cells) {
            if (cell.getColumnIndex() < min) {
                min = cell.getColumnIndex();
            }
        }
        return min;
    }

    public int getMaxColumnIndex() {
        int max = -1;
        for (ExcellCellInfo cell : cells) {
            if (cell.getColumnIndex() > max) {
                max = cell.getColumnIndex();
            }
        }
        return max;
    }

    public int getMinRowIndex() {
        int min = cells.get(0).getRowIndex();
        for (ExcellCellInfo cell : cells) {
            if (cell.getRowIndex() < min) {
                min = cell.getRowIndex();
            }
        }
        return min;
    }

    public int getMaxRowIndex() {
        int max = -1;
        for (ExcellCellInfo cell : cells) {
            if (cell.getRowIndex() > max) {
                max = cell.getRowIndex();
            }
        }
        return max;
    }

    @Override
    public String toString() {
        StringBuilder info = new StringBuilder("- - - Info - - - \n");;
        for (ExcellCellInfo cell : cells) {
            info.append(cell.toString() + "\n");
        }
        return info.toString();
    }

    public String print() {
        int minRowIndex = getMinRowIndex();
        int maxRowIndex = getMaxRowIndex();
        int minColumnIndex = getMinColumnIndex();
        int maxColumnIndex = getMaxColumnIndex();
        int maxCellSize = getMaxCellSize();
        System.out.println("print : minRowIndex=" + minRowIndex + ", maxRowIndex=" + maxRowIndex + ", minColumnIndex=" + minColumnIndex + ", maxColumnIndex=" + maxColumnIndex + ", maxCellSize=" + maxCellSize);

        StringBuilder info = new StringBuilder("- - - Table - - - \n");
        info.append(printHeaderRow(minColumnIndex, maxColumnIndex, maxCellSize));
        for (int i = minRowIndex; i <= maxRowIndex; i++) {
            info.append(printRow(i, maxCellSize)).append("\n");
        }
        return info.toString();
    }

    private String printRow(int rowIndex, int maxCellSize) {
        ArrayList<ExcellCellInfo> row = getRow(rowIndex);
        StringBuilder info = new StringBuilder(rowIndex + " | ");;
        for (ExcellCellInfo column : row) {
            info.append(getCellForPrint(column.getValue(), maxCellSize)).append(" | ");
        }
        return info.toString();
    }

    private String printHeaderRow(int minColumnIndex, int maxColumnIndex, int maxCellSize) {
        StringBuilder header = new StringBuilder("  | ");
        for (int i = minColumnIndex; i <= maxColumnIndex; i++) {
            header.append(getCellForPrint(colHeaders[i], maxCellSize)).append(" | ");
        }
        int length = header.toString().length();
        header.append("\n");
        header.append(StringUtils.repeat("-", length - 1)).append("\n");
        return header.toString();
    }

    private String getCellForPrint(String value, int maxCellSize) {
        int length = value.length();
        int space = maxCellSize - length;
        int halfSpace = space / 2;
        // System.out.println("getCellForPrint : value=" + value + ", maxCellSize=" + maxCellSize + ", length=" + length + ", =" + space + ", =" + space + ", halfSpace=" + halfSpace);
        return StringUtils.repeat(" ", halfSpace) + value + StringUtils.repeat(" ", space - halfSpace);
    }

    private int getMaxCellSize() {
        int max = -1;
        for (ExcellCellInfo cell : cells) {
            if (cell.getValue().length() > max) {
                max = cell.getValue().length();
            }
        }
        return max;
    }
}
