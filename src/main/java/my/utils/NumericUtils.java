package my.utils;

public class NumericUtils {

    public static boolean isInteger(double n) {
        return (n % 1) == 0;
    }

    public static boolean isPrime(int n) {
        // Corner case
        if (n <= 1)
            return false;

        // Check from 2 to n-1
        for (int i = 2; i < n; i++)
            if (n % i == 0)
                return false;

        return true;
    }

}
