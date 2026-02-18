package my.utils;

import org.apache.poi.ss.usermodel.*;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

import org.springframework.util.Assert;

class CellUtilsTests {

	Cell cell = mock(Cell.class);

	@Test
	void isValidCell() {
		String errMsg = "CellUtils.isValidCell failed";
		when(cell.getCellType()).thenReturn(CellType.NUMERIC);
		Assert.isTrue(CellUtils.isValidCell(cell, CellType.NUMERIC), errMsg);

		when(cell.getCellType()).thenReturn(CellType.STRING);
		Assert.isTrue(!CellUtils.isValidCell(cell, CellType.NUMERIC), errMsg);

		when(cell.getCellType()).thenReturn(CellType.FORMULA);
		Assert.isTrue(CellUtils.isValidCell(cell, CellType.FORMULA), errMsg);

		when(cell.getCellType()).thenReturn(CellType.FORMULA);
		Assert.isTrue(!CellUtils.isValidCell(cell, CellType.NUMERIC), errMsg);
	}

	@Test
	void getCellValue() {
		String errMsg = "CellUtils.getCellValue failed";
		when(cell.getCellType()).thenReturn(CellType.NUMERIC);
		when(cell.getNumericCellValue()).thenReturn(14.0);
		Assert.isTrue(CellUtils.getCellValue(cell).equals("14"), errMsg);

		when(cell.getCellType()).thenReturn(CellType.NUMERIC);
		when(cell.getNumericCellValue()).thenReturn(14.1);
		Assert.isTrue(CellUtils.getCellValue(cell).equals("14.1"), errMsg);

		when(cell.getCellType()).thenReturn(CellType.BOOLEAN);
		when(cell.getBooleanCellValue()).thenReturn(true);
		Assert.isTrue(CellUtils.getCellValue(cell).equals("true"), errMsg);

		when(cell.getCellType()).thenReturn(CellType.BOOLEAN);
		when(cell.getBooleanCellValue()).thenReturn(false);
		Assert.isTrue(CellUtils.getCellValue(cell).equals("false"), errMsg);
	}
}
