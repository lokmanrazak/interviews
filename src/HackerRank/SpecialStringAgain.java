package HackerRank;

import org.junit.Test;

import java.util.*;

// Correct solution but bad complexity
public class SpecialStringAgain {

    static long substrCount(int n, String s) {

        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        int total = 0;

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {

                if (isSpecialPalindrome(s.substring(i, j))) {
                    total++;
                }

            }
        }

        return total;
    }

    private static boolean isSpecialPalindrome(String s) {
        if (s.length() == 1) {
            return true;
        }

        String newS = s;

        if (s.length() % 2 != 0) {

            StringBuffer sb = new StringBuffer(s);
            newS = sb.deleteCharAt((s.length() - 1) / 2).toString();

        }

        Set<Character> charSet = new HashSet<>();
        for (char c : newS.toCharArray()) {
            charSet.add(c);
        }

        return charSet.size() == 1;
    }

    @Test
    public void test() {
        long result = substrCount(7, "abcbaba");
    }
}
