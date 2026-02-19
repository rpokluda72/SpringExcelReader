package my.excelreader;

import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.logging.Level;

class ExcelStringReaderTests {

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

		ExcelStringReader reader = new ExcelStringReader();
		ArrayList<String> strings = reader.getCellValues(args);
		reader.log(Level.INFO, "strings=" + strings);

		Assert.isTrue(strings.size() == 1, errMsg);
		Assert.isTrue(strings.get(0).equals("text C5"), errMsg);
	}

	@Test
	void readB() {
		String errMsg = "readB failed";
		String[] args = { "l-TestData.xlsx", "cf-1", "ct-1", "rf-1", "rt-9"};

		ExcelStringReader reader = new ExcelStringReader();
		ArrayList<String> strings = reader.getCellValues(args);
		reader.log(Level.INFO, "strings=" + strings);

		Assert.isTrue(strings.size() == 1, errMsg);
		Assert.isTrue(strings.get(0).equals("text B9"), errMsg);
	}

	@Test
	void readC() {
		String errMsg = "readC failed";
		String[] args = { "l-TestData.xlsx", "cf-2", "ct-2", "rf-2", "rt-7"};

		ExcelStringReader reader = new ExcelStringReader();
		ArrayList<String> strings = reader.getCellValues(args);
		reader.log(Level.INFO, "strings=" + strings);

		Assert.isTrue(strings.size() == 1, errMsg);
		Assert.isTrue(strings.get(0).equals("text C5"), errMsg);
	}


	@Test
	void readD() {
		String errMsg = "readC failed";
		String[] args = { "l-C:\\Users\\roman\\Work\\pohovor\\projects\\java\\excelReader\\SpringExcelReader\\src\\main\\resources\\TestData.xlsx", "cf-2", "ct-2", "rf-2", "rt-7"};

		ExcelStringReader reader = new ExcelStringReader();
		ArrayList<String> strings = reader.getCellValues(args);
		reader.log(Level.INFO, "strings=" + strings);

		Assert.isTrue(strings.size() == 1, errMsg);
		Assert.isTrue(strings.get(0).equals("text C5"), errMsg);
	}
}
