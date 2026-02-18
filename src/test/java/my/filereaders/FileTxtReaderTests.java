package my.filereaders;

import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

class FileTxtReaderTests {

	/**
	 * mytxt.txt
	 * My text file from test/resources
	 * text row 2
	 * text row 3
	 */
	@Test
	void readTxt() {
		String errMsg = "readTxt failed";

		FileTxtReader fileTxtReader =  new FileTxtReader();
		String content = fileTxtReader.getTxtContent("mytxt.txt");

		System.out.println("content:" + content);
		Assert.isTrue(content.contains("My text file from test/resources"), errMsg);
		Assert.isTrue(content.contains("text row 2"), errMsg);
		Assert.isTrue(content.contains("text row 3"), errMsg);
	}

}
