package my.utils;

import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

class NumericUtilsTests {

	@Test
	void isInteger() {
		Assert.isTrue(!NumericUtils.isInteger(14.2), "NumericUtils.isInteger(14.2) failed");
		Assert.isTrue(NumericUtils.isInteger(14), "NumericUtils.isInteger(14) failed");
		Assert.isTrue(NumericUtils.isInteger(-7), "NumericUtils.isInteger(-7) failed");
		Assert.isTrue(NumericUtils.isInteger(7), "NumericUtils.isInteger(7) failed");
	}

	@Test
	void isPrime() {
		Assert.isTrue(!NumericUtils.isPrime(14), "NumericUtils.isPrime(14) failed");
		Assert.isTrue(!NumericUtils.isPrime((int) -14), "NumericUtils.isPrime(-14) failed");
		Assert.isTrue(NumericUtils.isPrime(11), "NumericUtils.isPrime(11) failed");
		Assert.isTrue(!NumericUtils.isPrime(-11), "NumericUtils.isPrime(-11) failed");
	}

}
