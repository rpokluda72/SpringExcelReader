package my.cellvalidators;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CellTypeValidatorTests {

	Cell cell = mock(Cell.class);

	@Test
	void isValid_NUMERIC() {
		String errMsg = "PrimeNumberValidator failed";
		CellTypeValidator validator = new CellTypeValidator(CellType.NUMERIC);

		when(cell.getCellType()).thenReturn(CellType.NUMERIC);
		Assert.isTrue(validator.isValid(cell), errMsg);

		when(cell.getCellType()).thenReturn(CellType.STRING);
		Assert.isTrue(!validator.isValid(cell), errMsg);
	}

	@Test
	void isValid_STRING() {
		String errMsg = "PrimeNumberValidator failed";
		CellTypeValidator validator = new CellTypeValidator(CellType.STRING);

		when(cell.getCellType()).thenReturn(CellType.NUMERIC);
		Assert.isTrue(!validator.isValid(cell), errMsg);

		when(cell.getCellType()).thenReturn(CellType.STRING);
		Assert.isTrue(validator.isValid(cell), errMsg);
	}
}
