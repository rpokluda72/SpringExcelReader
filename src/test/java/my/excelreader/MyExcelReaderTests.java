package my.excelreader;

import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.logging.Level;

class MyExcelReaderTests {

	/**
	 * TestData.xlsx
	 * 		A		B		C
	 * 1	13		154		154
	 * 2	-4		3		-4
	 * 3	154,14	154,14	154,14
	 * 4	adad	adad	adad
	 * 5	22		22		17
	 * 6	7		-7		7
	 * 7	54		54		54
	 * 8	fghfh	fghfh	fghfh
	 * 9	11		11		11
	 */
	@Test
	void readA() {
		String errMsg = "readA failed";
		String[] args = { "l-TestData.xlsx", "cf-2", "ct-2", "rf-1", "rt-9"};

		MyExcelReader myExcelReader = new MyExcelReader();
		ArrayList<Integer> primeNumbers = myExcelReader.getSheetPrimeNumbers(args);
		myExcelReader.log(Level.INFO, "primeNumbers=" + primeNumbers);

		Assert.isTrue(primeNumbers.size() == 3, errMsg);
		Assert.isTrue(primeNumbers.get(0) == 17, errMsg);
		Assert.isTrue(primeNumbers.get(1) == 7, errMsg);
		Assert.isTrue(primeNumbers.get(2) == 11, errMsg);
	}

	@Test
	void readB() {
		String errMsg = "readB failed";
		String[] args = { "l-TestData.xlsx", "cf-1", "ct-1", "rf-1", "rt-9"};

		MyExcelReader myExcelReader = new MyExcelReader();
		ArrayList<Integer> primeNumbers = myExcelReader.getSheetPrimeNumbers(args);
		myExcelReader.log(Level.INFO, "primeNumbers=" + primeNumbers);

		Assert.isTrue(primeNumbers.size() == 2, errMsg);
		Assert.isTrue(primeNumbers.get(0) == 3, errMsg);
		Assert.isTrue(primeNumbers.get(1) == 11, errMsg);
	}

	@Test
	void readC() {
		String errMsg = "readC failed";
		String[] args = { "l-TestData.xlsx", "cf-2", "ct-2", "rf-2", "rt-7"};

		MyExcelReader myExcelReader = new MyExcelReader();
		ArrayList<Integer> primeNumbers = myExcelReader.getSheetPrimeNumbers(args);
		myExcelReader.log(Level.INFO, "primeNumbers=" + primeNumbers);

		Assert.isTrue(primeNumbers.size() == 2, errMsg);
		Assert.isTrue(primeNumbers.get(0) == 17, errMsg);
		Assert.isTrue(primeNumbers.get(1) == 7, errMsg);
	}
}
