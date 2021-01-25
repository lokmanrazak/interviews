package HackerRank;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class MinimumSwaps2 {
    static int minimumSwaps(int[] arr) {

        // indexValueMap
        Map<Integer, Integer> indexValueMap = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            indexValueMap.put(i, arr[i]);
        }

        // valueIndexMap
        Map<Integer, Integer> valueIndexMap = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            valueIndexMap.put(arr[i], i);
        }

        int swap = 0;

        for (Integer i = 0; i < arr.length; i++) {

            int value = indexValueMap.get(i);

            if (value != i + 1) {
                Integer index = valueIndexMap.get(i + 1);

                indexValueMap.put(index, value);
                valueIndexMap.put(value, index);

                swap++;
            }
        }

        return swap;
    }

    @Test
    public void test() {
        int[] arr = {4, 3, 1, 2};

        int result = minimumSwaps(arr);
    }
}
