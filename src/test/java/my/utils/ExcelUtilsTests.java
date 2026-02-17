package my.utils;

import org.apache.poi.ss.usermodel.*;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

import org.springframework.util.Assert;

class ExcelUtilsTests {

	Cell cell = mock(Cell.class);

	@Test
	void isInteger() {
		when(cell.getCellType()).thenReturn(CellType.NUMERIC);
		Assert.isTrue(ExcelUtils.isValidCell(cell, CellType.NUMERIC), "ExcelUtils.isValidCellfailed");

		when(cell.getCellType()).thenReturn(CellType.STRING);
		Assert.isTrue(!ExcelUtils.isValidCell(cell, CellType.NUMERIC), "ExcelUtils.isValidCellfailed");
	}
}
