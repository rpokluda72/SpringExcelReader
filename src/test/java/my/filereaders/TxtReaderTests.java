package my.filereaders;

import my.excelreader.MyExcelReader;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.logging.Level;

class TxtReaderTests {

	/**
	 * mytxt.txt
	 * My text file from test/resources
	 * text row 2
	 * text row 3
	 */
	@Test
	void readTxt() {
		String errMsg = "readTxt failed";

		TxtReader txtReader =  new TxtReader();
		String content = txtReader.getTxtContent("mytxt.txt");

		System.out.println("content:" + content);
		Assert.isTrue(content.contains("My text file from test/resources"), errMsg);
		Assert.isTrue(content.contains("text row 2"), errMsg);
		Assert.isTrue(content.contains("text row 3"), errMsg);
	}

}
