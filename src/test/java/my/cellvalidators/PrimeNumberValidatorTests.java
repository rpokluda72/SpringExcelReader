package my.cellvalidators;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class PrimeNumberValidatorTests {

	PrimeNumberValidator validator = new PrimeNumberValidator();
	Cell cell = mock(Cell.class);

	@Test
	void isValid() {
		String errMsg = "PrimeNumberValidator failed";

		when(cell.getCellType()).thenReturn(CellType.NUMERIC);
		when(cell.getNumericCellValue()).thenReturn((double) 11);
		Assert.isTrue(validator.isValid(cell), errMsg);

		when(cell.getNumericCellValue()).thenReturn((double) -11);
		Assert.isTrue(!validator.isValid(cell), errMsg);

		when(cell.getNumericCellValue()).thenReturn((double) 14);
		Assert.isTrue(!validator.isValid(cell), errMsg);

		when(cell.getNumericCellValue()).thenReturn(11.1);
		Assert.isTrue(!validator.isValid(cell), errMsg);

		when(cell.getNumericCellValue()).thenReturn(14.1);
		Assert.isTrue(!validator.isValid(cell), errMsg);

		when(cell.getCellType()).thenReturn(CellType.STRING);
		Assert.isTrue(!validator.isValid(cell), errMsg);
	}
}
