package my.cellvalidators;

import my.excelreader.ArgumentsReader;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CellValidatorFactoryTests {
	String[] args = {"l-TestData.xlsx", "cf-1", "ct-1", "rf-1", "rt-9"};

	Cell cell = mock(Cell.class);

	@Test
	void setValidatorsFromArguments() {
		ArgumentsReader argumentsReader = new ArgumentsReader(args);
		CellValidatorFactory factory = new CellValidatorFactory();
		String errMsg = "CellValidatorFactory.setValidatorsFromArguments failed";

		factory.setValidatorsFromArguments(argumentsReader);
		Assert.isTrue(factory.getValidators().size() == 2, errMsg);

		factory.addValidator(new CellTypeValidator(CellType.NUMERIC));
		factory.addValidator(new PrimeNumberValidator());
		Assert.isTrue(factory.getValidators().size() == 4, errMsg);

	}

	@Test
	void isValid() {
		ArgumentsReader argumentsReader = new ArgumentsReader(args);
		CellValidatorFactory factory = new CellValidatorFactory();
		String errMsg = "CellValidatorFactory.isValid failed";
		factory.setValidatorsFromArguments(argumentsReader);
		factory.addValidator(new CellTypeValidator(CellType.NUMERIC));
		factory.addValidator(new PrimeNumberValidator());

		when(cell.getCellType()).thenReturn(CellType.NUMERIC);
		when(cell.getNumericCellValue()).thenReturn((double) 11);
		when(cell.getRowIndex()).thenReturn(3);
		when(cell.getColumnIndex()).thenReturn(1);
		Assert.isTrue(factory.isValid(cell), errMsg);

		when(cell.getCellType()).thenReturn(CellType.STRING);
		when(cell.getStringCellValue()).thenReturn("text");
		when(cell.getRowIndex()).thenReturn(3);
		when(cell.getColumnIndex()).thenReturn(1);
		Assert.isTrue(!factory.isValid(cell), errMsg);

		when(cell.getCellType()).thenReturn(CellType.NUMERIC);
		when(cell.getNumericCellValue()).thenReturn((double) 12);
		when(cell.getRowIndex()).thenReturn(3);
		when(cell.getColumnIndex()).thenReturn(1);
		Assert.isTrue(!factory.isValid(cell), errMsg);

		when(cell.getCellType()).thenReturn(CellType.NUMERIC);
		when(cell.getNumericCellValue()).thenReturn((double) 11);
		when(cell.getRowIndex()).thenReturn(0);
		when(cell.getColumnIndex()).thenReturn(1);
		Assert.isTrue(!factory.isValid(cell), errMsg);

		when(cell.getCellType()).thenReturn(CellType.NUMERIC);
		when(cell.getNumericCellValue()).thenReturn((double) 11);
		when(cell.getRowIndex()).thenReturn(3);
		when(cell.getColumnIndex()).thenReturn(0);
		Assert.isTrue(!factory.isValid(cell), errMsg);
	}
}
