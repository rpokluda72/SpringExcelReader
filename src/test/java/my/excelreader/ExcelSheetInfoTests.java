package my.excelreader;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ExcelSheetInfoTests {

	ExcellSheetInfo info = new ExcellSheetInfo();

	@BeforeEach
	public void setInfo() {
		info.addCell(getNumericCell(0,0, (double) 12.5));
		info.addCell(getFormulaCell(0,1, "B3-C2"));
		info.addCell(getStringCell(0,2, "Cell 0-2"));
		info.addCell(getNumericCell(1,0, (double) 11));
		info.addCell(getFormulaCell(1,1, "A1+A2"));
		info.addCell(getBooleanCell(1,2, true));
		info.addCell(getStringCell(2,0, "Cell 2-0"));
		info.addCell(getBooleanCell(2,1, false));
		info.addCell(getStringCell(2,2, "Cell 2-2"));

		System.out.println("setInfo : info.getCells().size()=" + info.getCells().size());
	}

	@Test
	void getCell() {
		String errMsg = "getCell failed";
		ExcellCellInfo cell = info.getCell(1,1);
		System.out.println("getCell : cell=" + cell);

		Assert.isTrue(cell.getType().equals(CellType.FORMULA), errMsg);
		Assert.isTrue(cell.getRowIndex() == 1, errMsg);
		Assert.isTrue(cell.getColumnIndex() == 1, errMsg);
		Assert.isTrue(cell.getValue().equals("A1+A2"), errMsg);
	}

	@Test
	void getRow() {
		String errMsg = "getRow failed";
		ArrayList<ExcellCellInfo> row = info.getRow(1);
		System.out.println("getRow : row=" + row);

		Assert.isTrue(row.size() == 3, errMsg);

		Assert.isTrue(row.get(0).getType().equals(CellType.NUMERIC), errMsg);
		Assert.isTrue(row.get(0).getRowIndex() == 1, errMsg);
		Assert.isTrue(row.get(0).getColumnIndex() == 0, errMsg);
		Assert.isTrue(row.get(0).getValue().equals("11"), errMsg);

		Assert.isTrue(row.get(1).getType().equals(CellType.FORMULA), errMsg);
		Assert.isTrue(row.get(1).getRowIndex() == 1, errMsg);
		Assert.isTrue(row.get(1).getColumnIndex() == 1, errMsg);
		Assert.isTrue(row.get(1).getValue().equals("A1+A2"), errMsg);

		Assert.isTrue(row.get(2).getType().equals(CellType.BOOLEAN), errMsg);
		Assert.isTrue(row.get(2).getRowIndex() == 1, errMsg);
		Assert.isTrue(row.get(2).getColumnIndex() == 2, errMsg);
		Assert.isTrue(row.get(2).getValue().equals("true"), errMsg);
	}

	@Test
	void getColumn() {
		String errMsg = "getColumn failed";
		ArrayList<ExcellCellInfo> column = info.getColumn(1);
		System.out.println("getColumn : column=" + column);

		Assert.isTrue(column.size() == 3, errMsg);

		Assert.isTrue(column.get(0).getType().equals(CellType.FORMULA), errMsg);
		Assert.isTrue(column.get(0).getRowIndex() == 0, errMsg);
		Assert.isTrue(column.get(0).getColumnIndex() == 1, errMsg);
		Assert.isTrue(column.get(0).getValue().equals("B3-C2"), errMsg);

		Assert.isTrue(column.get(1).getType().equals(CellType.FORMULA), errMsg);
		Assert.isTrue(column.get(1).getRowIndex() == 1, errMsg);
		Assert.isTrue(column.get(1).getColumnIndex() == 1, errMsg);
		Assert.isTrue(column.get(1).getValue().equals("A1+A2"), errMsg);


		Assert.isTrue(column.get(2).getType().equals(CellType.BOOLEAN), errMsg);
		Assert.isTrue(column.get(2).getRowIndex() == 2, errMsg);
		Assert.isTrue(column.get(2).getColumnIndex() == 1, errMsg);
		Assert.isTrue(column.get(2).getValue().equals("false"), errMsg);
	}

	@Test
	void print() {
		String errMsg = "print failed";
		String print = info.print();
		String[] rows = print.split("\n");

		System.out.println(print);

		Assert.isTrue(rows.length == 6, errMsg);
		Assert.isTrue(rows[0].contains("- - - Table - - -"), errMsg);
		Assert.isTrue(rows[1].contains("  |    A     |    B     |    C     |"), errMsg);
		Assert.isTrue(rows[2].contains("------------------------------------"), errMsg);
		Assert.isTrue(rows[3].contains("0 |   12.5   |  B3-C2   | Cell 0-2 |"), errMsg);
		Assert.isTrue(rows[4].contains("1 |    11    |  A1+A2   |   true   |"), errMsg);
		Assert.isTrue(rows[5].contains("2 | Cell 2-0 |  false   | Cell 2-2 |"), errMsg);
	}

	@Test
	void print2() {
		info.getCells().clear();
		setInfo2();

		String errMsg = "print failed";
		String print = info.print();
		String[] rows = print.split("\n");

		// System.out.println(print);

		Assert.isTrue(rows.length == 5, errMsg);
		Assert.isTrue(rows[0].contains("- - - Table - - -"), errMsg);
		Assert.isTrue(rows[1].contains("  |    B     |    C     |    D     |"), errMsg);
		Assert.isTrue(rows[2].contains("------------------------------------"), errMsg);
		Assert.isTrue(rows[3].contains("1 |    11    |  A1+A2   |   true   |"), errMsg);
		Assert.isTrue(rows[4].contains("2 | Cell 0-2 |  false   | Cell 0-2 |"), errMsg);
	}

	private ExcellCellInfo getNumericCell(int rowIndex, int columnIndex, double value) {
		Cell cell = mock(Cell.class);
		when(cell.getCellType()).thenReturn(CellType.NUMERIC);
		when(cell.getNumericCellValue()).thenReturn(value);
		when(cell.getRowIndex()).thenReturn(rowIndex);
		when(cell.getColumnIndex()).thenReturn(columnIndex);
		return new ExcellCellInfo(cell);
	}

	private ExcellCellInfo getStringCell(int rowIndex, int columnIndex, String value) {
		Cell cell = mock(Cell.class);
		when(cell.getCellType()).thenReturn(CellType.STRING);
		when(cell.getStringCellValue()).thenReturn(value);
		when(cell.getRowIndex()).thenReturn(rowIndex);
		when(cell.getColumnIndex()).thenReturn(columnIndex);
		return new ExcellCellInfo(cell);
	}

	private ExcellCellInfo getBooleanCell(int rowIndex, int columnIndex, boolean value) {
		Cell cell = mock(Cell.class);
		when(cell.getCellType()).thenReturn(CellType.BOOLEAN);
		when(cell.getBooleanCellValue()).thenReturn(value);
		when(cell.getRowIndex()).thenReturn(rowIndex);
		when(cell.getColumnIndex()).thenReturn(columnIndex);
		return new ExcellCellInfo(cell);
	}

	private ExcellCellInfo getFormulaCell(int rowIndex, int columnIndex, String value) {
		Cell cell = mock(Cell.class);
		when(cell.getCellType()).thenReturn(CellType.FORMULA);
		when(cell.getCellFormula()).thenReturn(value);
		when(cell.getRowIndex()).thenReturn(rowIndex);
		when(cell.getColumnIndex()).thenReturn(columnIndex);
		return new ExcellCellInfo(cell);
	}

	private void setInfo2() {
		info.addCell(getNumericCell(1,1, (double) 11));
		info.addCell(getFormulaCell(1,2, "A1+A2"));
		info.addCell(getBooleanCell(1,3, true));
		info.addCell(getStringCell(2,1, "Cell 0-2"));
		info.addCell(getBooleanCell(2,2, false));
		info.addCell(getStringCell(2,3, "Cell 0-2"));

		System.out.println("setInfo : info.getCells().size()=" + info.getCells().size());
	}

//	private Cell getCell(CellType type, int rowIndex, int columnIndex, String value) {
//		Cell cell = mock(Cell.class);
//		when(cell.getColumnIndex()).thenReturn(1);
//		info.addCell(new);
//	}
}
