package my.cellvalidators;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ColumnValidatorTests {

	int columnFrom = 2;
	int columnTo = 8;
	ColumnValidator validator = new ColumnValidator(columnFrom, columnTo);
	Cell cell = mock(Cell.class);

	@Test
	void isValid() {
		String columnValidatorFailed = "ColumnValidator failed";

		when(cell.getColumnIndex()).thenReturn(1);
		Assert.isTrue(!validator.isValid(cell), columnValidatorFailed);

		when(cell.getColumnIndex()).thenReturn(2);
		Assert.isTrue(validator.isValid(cell), columnValidatorFailed);

		when(cell.getColumnIndex()).thenReturn(3);
		Assert.isTrue(validator.isValid(cell), columnValidatorFailed);

		when(cell.getColumnIndex()).thenReturn(8);
		Assert.isTrue(validator.isValid(cell), columnValidatorFailed);

		when(cell.getColumnIndex()).thenReturn(9);
		Assert.isTrue(!validator.isValid(cell), columnValidatorFailed);
	}
}
