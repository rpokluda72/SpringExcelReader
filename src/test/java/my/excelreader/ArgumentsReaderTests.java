package my.excelreader;

import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

class ArgumentsReaderTests {

	@Test
	void constructorWithArgs() {
		String errMsg = "constructorWithArgs failed";
		String[] args = { "l-TestData.xlsx", "cf-1", "ct-1", "rf-1", "rt-9"};
		ArgumentsReader argumentsReader = new ArgumentsReader(args);
		Assert.isTrue(argumentsReader.getLocation().equals("TestData.xlsx"), errMsg);
		Assert.isTrue(argumentsReader.getColumnFrom() == 1, errMsg);
		Assert.isTrue(argumentsReader.getColumnTo() == 1, errMsg);
		Assert.isTrue(argumentsReader.getRowFrom() == 1, errMsg);
		Assert.isTrue(argumentsReader.getRowTo() == 9, errMsg);

		Assert.isTrue(!argumentsReader.isLocationDefault(), errMsg);
		Assert.isTrue(!argumentsReader.isColumnDefault(), errMsg);
		Assert.isTrue(!argumentsReader.isRowDefault(), errMsg);
	}

	@Test
	void constructorWithoutArgs() {
		String errMsg = "constructorWithArgs failed";
		String[] args = { ""};
		ArgumentsReader argumentsReader = new ArgumentsReader(args);
		Assert.isTrue(argumentsReader.getLocation().equals("MyData.xlsx"), errMsg);
		Assert.isTrue(argumentsReader.getColumnFrom() == 0, errMsg);
		Assert.isTrue(argumentsReader.getColumnTo() == -1, errMsg);
		Assert.isTrue(argumentsReader.getRowFrom() == 0, errMsg);
		Assert.isTrue(argumentsReader.getRowTo() == -1, errMsg);

		Assert.isTrue(argumentsReader.isLocationDefault(), errMsg);
		Assert.isTrue(argumentsReader.isColumnDefault(), errMsg);
		Assert.isTrue(argumentsReader.isRowDefault(), errMsg);
	}
}
