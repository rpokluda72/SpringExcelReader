package my.utils;

import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

class NumericUtilsTests {

	@Test
	void isInteger() {
		String errMsg = "NumericUtils.isInteger failed";
		Assert.isTrue(!NumericUtils.isInteger(14.2), errMsg);
		Assert.isTrue(NumericUtils.isInteger(14), errMsg);
		Assert.isTrue(NumericUtils.isInteger(-7), errMsg);
		Assert.isTrue(NumericUtils.isInteger(7), errMsg);
	}

	@Test
	void isPrime() {
		String errMsg = "NumericUtils.isPrime failed";
		Assert.isTrue(!NumericUtils.isPrime(14), errMsg);
		Assert.isTrue(!NumericUtils.isPrime((int) -14), errMsg);
		Assert.isTrue(NumericUtils.isPrime(11), errMsg);
		Assert.isTrue(!NumericUtils.isPrime(-11), errMsg);
	}

}
