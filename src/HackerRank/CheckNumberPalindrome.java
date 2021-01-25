package HackerRank;

import org.junit.Test;

public class CheckNumberPalindrome {

    public boolean isNumberPalindrome(int number) {
        int remainder = 0;
        int reverse = 0;
        int value = number;

        while (value > 0) {
            remainder = value % 10;

            reverse = (reverse * 10) + remainder;
            value = value/10;
        }

        return reverse == number;
    }

    @Test
    public void test() {
        boolean result = isNumberPalindrome(121);
    }
}
