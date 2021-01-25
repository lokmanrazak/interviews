package HackerRank;

import org.junit.Test;

public class CheckPalindrome {

    public boolean isPalindrome(String text) {
        String trimmedText = text.replaceAll("[\\s+\\W]", "").toLowerCase();
        char[] array = trimmedText.toCharArray();

        int start = 0;
        int end = array.length - 1;

        while (start < end) {
            if (array[start] != array[end]) {
                return false;
            }

            start++;
            end--;
        }

        return true;
    }

    public boolean isPalindrome_StringBuilder(String text) {
        String clean = text.replaceAll(" ", "").toLowerCase();
        StringBuilder forward = new StringBuilder(clean);
        StringBuilder backward = forward.reverse();

        return backward.toString().equals(clean);
    }

    @Test
    public void test() {
        boolean result = isPalindrome("Was it a car or a cat I saw?");
    }
}
