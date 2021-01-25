package HackerRank;

import org.junit.Test;

import java.util.*;

public class SherlockAndTheValidString {
    // Complete the isValid function below.
    static String isValid(String s) {

        if (s.isEmpty()) {
            return "NO";
        }

        if (s.length() <= 3) {
            return "YES";
        }

        Map<Character, Integer> charCountMap = new HashMap<>();

        for (char ch : s.toCharArray()) {
            charCountMap.put(ch, charCountMap.getOrDefault(ch, 0) + 1);
        }

        Map<Integer, Integer> countFreqMap = new HashMap<>();

        for (int ct : charCountMap.values()) {
            countFreqMap.put(ct, countFreqMap.getOrDefault(ct, 0) + 1);
        }

        Set<Integer> keySet = countFreqMap.keySet();

        if (keySet.size() == 1) {
            return "YES";
        }

        if (keySet.size() > 2) {
            return "NO";
        }

        Iterator<Integer> iterator = countFreqMap.values().iterator();

        int first = iterator.next();
        int second = iterator.next();

        if (first == second && first == 1) {
            return "YES";
        }

        int min = Math.min(first, second);
        int max = Math.max(first, second);

        if (min == 1) {
            Iterator<Integer> setIterator = keySet.iterator();
            int firstCount = setIterator.next();
            int secondCount = setIterator.next();

            return "YES";
        }

        return "NO";
    }

    @Test
    public void test() {
        String result = isValid("aaaabbcc");
    }
}
