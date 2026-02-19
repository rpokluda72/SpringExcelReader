package my.excelreader;

import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.util.ArrayList;

class MyExcelReaderTests {

	@Test
	void readDefaultExcelReaderType() {
		String errMsg = "readDefaultExcelReaderType failed";
		String[] args = { "l-TestData.xlsx", "cf-2", "ct-2", "rf-1", "rt-9"};

		MyExcelReader reader = new MyExcelReader();
		reader.read(args);
		ArrayList<String> values = reader.getAllValues();
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
		reader.read(args);
		ArrayList<String> values = reader.getAllValues();
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
		reader.read(args);
		ArrayList<String> values = reader.getAllValues();
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
		reader.read(args);
		ArrayList<String> values = reader.getAllValues();
		Assert.isTrue(values.size() == 1, errMsg);
		Assert.isTrue(values.get(0).equals("text A5"), errMsg);
	}

	@Test
	void readExcelBooleanReader() {
		String errMsg = "readExcelBooleanReader failed";
		String[] args = { "l-TestData.xlsx", "cf-2", "ct-2", "rf-1", "rt-9", "er-b"};

		MyExcelReader reader = new MyExcelReader();
		reader.read(args);
		ArrayList<String> values = reader.getAllValues();
		Assert.isTrue(values.size() == 2, errMsg);
		Assert.isTrue(values.get(0).equals("true"), errMsg);
		Assert.isTrue(values.get(1).equals("false"), errMsg);
	}

	@Test
	void readExcelFormulaReader() {
		String errMsg = "readExcelFormulaReader failed";
		String[] args = { "l-TestData.xlsx", "cf-1", "ct-1", "rf-1", "rt-9", "er-f"};

		MyExcelReader reader = new MyExcelReader();
		reader.read(args);
		ArrayList<String> values = reader.getAllValues();
		Assert.isTrue(values.size() == 1, errMsg);
		Assert.isTrue(values.get(0).equals("B6+B7"), errMsg);
	}


	@Test
	void readAllTypesReader() {
		String errMsg = "readAllTypesReader failed";
		String[] args = { "l-TestData.xlsx", "cf-1", "ct-1", "rf-1", "rt-9", "er-a"};

		MyExcelReader reader = new MyExcelReader();
		reader.read(args);
		ArrayList<String> values = reader.getAllValues();
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

	@Test
	void readExcelInfoReaderInfo() {
		String errMsg = "readExcelInfoReaderInfo failed";
		String[] args = { "l-TestData.xlsx", "cf-1", "ct-1", "rf-1", "rt-9", "er-i"};

		MyExcelReader reader = new MyExcelReader();
		reader.read(args);
		ArrayList<String> values = reader.getAllValues();
		Assert.isTrue(values.size() == 9, errMsg);

		Assert.isTrue(values.get(0).contains("{type=NUMERIC, rowIndex=1, columnIndex=1, value='154.14'}"), errMsg);

	}

	@Test
	void readExcelInfoReaderTable() {
		String errMsg = "readExcelInfoReaderTable failed";
		String[] args = { "l-TestData.xlsx", "cf-1", "ct-1", "rf-3", "rt-7", "er-t"};

		MyExcelReader reader = new MyExcelReader();
		reader.read(args);
		ArrayList<String> values = reader.getAllValues();
		String[] rows = values.get(0).split("\n");
		// System.out.println("readExcelInfoReaderTable : rows.length=" + rows.length);
		Assert.isTrue(rows.length == 8, errMsg);
		Assert.isTrue(rows[0].contains("- - - Table - - -"), errMsg);
		Assert.isTrue(rows[1].contains("  |   B   |"), errMsg);
		Assert.isTrue(rows[2].contains("-----------"), errMsg);
		Assert.isTrue(rows[3].contains("3 | true  |"), errMsg);
		Assert.isTrue(rows[4].contains("4 | -122  |"), errMsg);
		Assert.isTrue(rows[5].contains("5 |  22   |"), errMsg);
		Assert.isTrue(rows[6].contains("6 |  -7   |"), errMsg);
		Assert.isTrue(rows[7].contains("7 | B6+B7 |"), errMsg);

	}
}
