package my.excelreader;

import org.apache.poi.ss.usermodel.CellType;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.logging.Level;

class ExcelInfoReaderTests {

	boolean printToConsole = false;

	@Test
	void readA() {
		String errMsg = "readA failed";
		String[] args = { "l-TestData.xlsx", "cf-2", "ct-2", "rf-1", "rt-9", "er-i"};

		ExcelInfoReader reader = new ExcelInfoReader();
		ExcellSheetInfo info = reader.getInfo(args);
		ArrayList<ExcellCellInfo> cells = info.getCells();
		print(info);

		Assert.isTrue(cells.size() == 9, errMsg);

		Assert.isTrue(cells.get(0).getType().equals(CellType.NUMERIC), errMsg);
		Assert.isTrue(cells.get(0).getRowIndex() == 1, errMsg);
		Assert.isTrue(cells.get(0).getColumnIndex() == 2, errMsg);
		Assert.isTrue(cells.get(0).getValue().equals("-4"), errMsg);

		Assert.isTrue(cells.get(1).getType().equals(CellType.NUMERIC), errMsg);
		Assert.isTrue(cells.get(1).getRowIndex() == 2, errMsg);
		Assert.isTrue(cells.get(1).getColumnIndex() == 2, errMsg);
		Assert.isTrue(cells.get(1).getValue().equals("21.14"), errMsg);

		Assert.isTrue(cells.get(2).getType().equals(CellType.NUMERIC), errMsg);
		Assert.isTrue(cells.get(2).getRowIndex() == 3, errMsg);
		Assert.isTrue(cells.get(2).getColumnIndex() == 2, errMsg);
		Assert.isTrue(cells.get(2).getValue().equals("17"), errMsg);
	}

	@Test
	void readB() {
		String errMsg = "readA failed";
		String[] args = { "l-TestData.xlsx", "er-i"};

		ExcelInfoReader reader = new ExcelInfoReader();
		ExcellSheetInfo info = reader.getInfo(args);
		ArrayList<ExcellCellInfo> cells = info.getCells();
		print(info);

		Assert.isTrue(cells.size() == 33, errMsg);
	}

	private void print(ExcellSheetInfo info) {
		if (printToConsole) {
			System.out.println("info.getCells().size()=" + info.getCells().size());
			System.out.println(info);
		}
	}

}
