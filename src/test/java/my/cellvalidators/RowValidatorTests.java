package my.cellvalidators;

import org.apache.poi.ss.usermodel.Cell;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class RowValidatorTests {

	int rowFrom = 2;
	int rowTo = 8;
	RowValidator validator = new RowValidator(rowFrom, rowTo);
	Cell cell = mock(Cell.class);

	@Test
	void isValid() {
		String errMsg = "RowValidator failed";

		when(cell.getRowIndex()).thenReturn(1);
		Assert.isTrue(!validator.isValid(cell), errMsg);

		when(cell.getRowIndex()).thenReturn(2);
		Assert.isTrue(validator.isValid(cell), errMsg);

		when(cell.getRowIndex()).thenReturn(3);
		Assert.isTrue(validator.isValid(cell), errMsg);

		when(cell.getRowIndex()).thenReturn(8);
		Assert.isTrue(validator.isValid(cell), errMsg);

		when(cell.getRowIndex()).thenReturn(9);
		Assert.isTrue(!validator.isValid(cell), errMsg);
	}
}
