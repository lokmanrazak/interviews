package HackerRank;

import org.junit.Test;

import java.util.*;
import java.util.stream.Stream;

public class StringsMakingAnagrams {

    // Complete the makeAnagram function below.
    static int makeAnagram(String a, String b) {

        Map<Character, Integer> charMap = new HashMap<>();

        // Add new char and increment existing
        for (char ch: a.toCharArray()) {
            if (charMap.containsKey(ch)) {
                int count = charMap.get(ch);
                charMap.put(ch, count + 1);
            } else {
                charMap.put(ch, 1);
            }
        }

        // Add new char and decrement existing char
        for (char ch : b.toCharArray()) {
            if (charMap.containsKey(ch)) {
                int count = charMap.get(ch);
                charMap.put(ch, count - 1);
            } else {
                charMap.put(ch, -1);
            }
        }

        List<Integer> values = new ArrayList<>(charMap.values());
        int total = 0;
        for (int v : values) {
            total += Math.abs(v);
        }

        return total;
    }

    @Test
    public void test() {
        int result = makeAnagram("fcrxzwscanmligyxyvym", "jxwtrhvujlmrpdoqbisbwhmgpmeoke");
    }
}
