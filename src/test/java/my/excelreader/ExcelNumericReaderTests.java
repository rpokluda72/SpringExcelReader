package my.excelreader;

import org.apache.poi.ss.formula.functions.T;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.logging.Level;

class ExcelNumericReaderTests {

	/**
	 * TestData.xlsx
	 * 		A			B			C
	 * 1	13			154			=C2+C4
	 * 2	-4			154,14		-4
	 * 3	154,14		3			21,14
	 * 4	text A4		TRUE		17
	 * 5	22			-122		text A5
	 * 6	7			22			TRUE
	 * 7	TRUE		-7			11
	 * 8	=A5+A6		=B6+B7		FALSE
	 * 9	FALSE		text B9		54
	 * 10	text A10	13			47
	 * 11	11			FALSE		text C11
	 */
	@Test
	void readA() {
		String errMsg = "readA failed";
		String[] args = { "l-TestData.xlsx", "cf-2", "ct-2", "rf-1", "rt-9"};

		ExcelNumericReader reader = new ExcelNumericReader();
		ArrayList<String> values = reader.getCellValues(args);
		reader.log(Level.INFO, "values=" + values);

		Assert.isTrue(values.size() == 6, errMsg);
		Assert.isTrue(values.get(0).equals("-4"), errMsg);
		Assert.isTrue(values.get(1).equals("21.14"), errMsg);
		Assert.isTrue(values.get(2).equals("17"), errMsg);
		Assert.isTrue(values.get(3).equals("11"), errMsg);
		Assert.isTrue(values.get(4).equals("54"), errMsg);
		Assert.isTrue(values.get(5).equals("47"), errMsg);
	}

	@Test
	void readB() {
		String errMsg = "readB failed";
		String[] args = { "l-TestData.xlsx", "cf-1", "ct-1", "rf-1", "rt-9"};

		ExcelNumericReader reader = new ExcelNumericReader();
		ArrayList<String> values = reader.getCellValues(args);
		reader.log(Level.INFO, "values=" + values);

		Assert.isTrue(values.size() == 6, errMsg);
		Assert.isTrue(values.get(0).equals("154.14"), errMsg);
		Assert.isTrue(values.get(1).equals("3"), errMsg);
		Assert.isTrue(values.get(2).equals("-122"), errMsg);
		Assert.isTrue(values.get(3).equals("22"), errMsg);
		Assert.isTrue(values.get(4).equals("-7"), errMsg);
		Assert.isTrue(values.get(5).equals("13"), errMsg);
	}

	@Test
	void readC() {
		String errMsg = "readC failed";
		String[] args = { "l-TestData.xlsx", "cf-2", "ct-2", "rf-2", "rt-7"};

		ExcelNumericReader reader = new ExcelNumericReader();
		ArrayList<String> values = reader.getCellValues(args);
		reader.log(Level.INFO, "values=" + values);

		Assert.isTrue(values.size() == 3, errMsg);
		Assert.isTrue(values.get(0).equals("21.14"), errMsg);
		Assert.isTrue(values.get(1).equals("17"), errMsg);
		Assert.isTrue(values.get(2).equals("11"), errMsg);
	}


	@Test
	void readD() {
		String errMsg = "readC failed";
		String[] args = { "l-C:\\Users\\roman\\Work\\pohovor\\projects\\java\\excelReader\\SpringExcelReader\\src\\main\\resources\\TestData.xlsx", "cf-2", "ct-2", "rf-2", "rt-7"};

		ExcelNumericReader reader = new ExcelNumericReader();
		ArrayList<String> values = reader.getCellValues(args);
		reader.log(Level.INFO, "values=" + values);

		Assert.isTrue(values.size() == 3, errMsg);
		Assert.isTrue(values.get(0).equals("21.14"), errMsg);
		Assert.isTrue(values.get(1).equals("17"), errMsg);
		Assert.isTrue(values.get(2).equals("11"), errMsg);
	}
}
