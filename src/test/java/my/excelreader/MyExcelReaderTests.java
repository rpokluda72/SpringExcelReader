package my.excelreader;

import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.logging.Level;

class MyExcelReaderTests {

	@Test
	void readDefaultExcelReaderType() {
		String errMsg = "readDefaultExcelReaderType failed";
		String[] args = { "l-TestData.xlsx", "cf-2", "ct-2", "rf-1", "rt-9"};

		MyExcelReader reader = new MyExcelReader();
		ArrayList<String> values = reader.read(args);
		Assert.isTrue(values.size() == 3, errMsg);
		Assert.isTrue(values.get(0).equals("17"), errMsg);
		Assert.isTrue(values.get(1).equals("11"), errMsg);
		Assert.isTrue(values.get(2).equals("47"), errMsg);
	}

	@Test
	void readExcelNumericReader() {
		String errMsg = "readExcelNumericReader failed";
		String[] args = { "l-TestData.xlsx", "cf-2", "ct-2", "rf-1", "rt-9", "er-n"};

		MyExcelReader reader = new MyExcelReader();
		ArrayList<String> values = reader.read(args);
		Assert.isTrue(values.size() == 6, errMsg);
		Assert.isTrue(values.get(0).equals("-4"), errMsg);
		Assert.isTrue(values.get(1).equals("21.14"), errMsg);
		Assert.isTrue(values.get(2).equals("17"), errMsg);
		Assert.isTrue(values.get(3).equals("11"), errMsg);
		Assert.isTrue(values.get(4).equals("54"), errMsg);
		Assert.isTrue(values.get(5).equals("47"), errMsg);
	}

	@Test
	void readExcelPrimeNumericReader() {
		String errMsg = "readExcelPrimeNumericReader failed";
		String[] args = { "l-TestData.xlsx", "cf-2", "ct-2", "rf-1", "rt-9", "er-pn"};

		MyExcelReader reader = new MyExcelReader();
		ArrayList<String> values = reader.read(args);
		Assert.isTrue(values.size() == 3, errMsg);
		Assert.isTrue(values.get(0).equals("17"), errMsg);
		Assert.isTrue(values.get(1).equals("11"), errMsg);
		Assert.isTrue(values.get(2).equals("47"), errMsg);
	}

	@Test
	void readExcelStringReader() {
		String errMsg = "readExcelStringReader failed";
		String[] args = { "l-TestData.xlsx", "cf-2", "ct-2", "rf-1", "rt-9", "er-s"};

		MyExcelReader reader = new MyExcelReader();
		ArrayList<String> values = reader.read(args);
		Assert.isTrue(values.size() == 1, errMsg);
		Assert.isTrue(values.get(0).equals("text A5"), errMsg);
	}

	@Test
	void readExcelBooleanReader() {
		String errMsg = "readExcelBooleanReader failed";
		String[] args = { "l-TestData.xlsx", "cf-2", "ct-2", "rf-1", "rt-9", "er-b"};

		MyExcelReader reader = new MyExcelReader();
		ArrayList<String> values = reader.read(args);
		Assert.isTrue(values.size() == 2, errMsg);
		Assert.isTrue(values.get(0).equals("true"), errMsg);
		Assert.isTrue(values.get(1).equals("false"), errMsg);
	}

	@Test
	void readExcelFormulaReader() {
		String errMsg = "readExcelFormulaReader failed";
		String[] args = { "l-TestData.xlsx", "cf-1", "ct-1", "rf-1", "rt-9", "er-f"};

		MyExcelReader reader = new MyExcelReader();
		ArrayList<String> values = reader.read(args);
		Assert.isTrue(values.size() == 1, errMsg);
		Assert.isTrue(values.get(0).equals("B6+B7"), errMsg);
	}


	@Test
	void readAllTypesReader() {
		String errMsg = "readAllTypesReader failed";
		String[] args = { "l-TestData.xlsx", "cf-1", "ct-1", "rf-1", "rt-9", "er-a"};

		MyExcelReader reader = new MyExcelReader();
		ArrayList<String> values = reader.read(args);
		Assert.isTrue(values.size() == 11, errMsg);
		Assert.isTrue(values.get(0).equals("154.14"), errMsg);
		Assert.isTrue(values.get(1).equals("3"), errMsg);
		Assert.isTrue(values.get(2).equals("-122"), errMsg);
		Assert.isTrue(values.get(3).equals("22"), errMsg);
		Assert.isTrue(values.get(4).equals("-7"), errMsg);
		Assert.isTrue(values.get(5).equals("13"), errMsg);
		Assert.isTrue(values.get(6).equals("3"), errMsg);
		Assert.isTrue(values.get(7).equals("13"), errMsg);
		Assert.isTrue(values.get(8).equals("text B9"), errMsg);
		Assert.isTrue(values.get(9).equals("true"), errMsg);
		Assert.isTrue(values.get(10).equals("B6+B7"), errMsg);
	}
}
