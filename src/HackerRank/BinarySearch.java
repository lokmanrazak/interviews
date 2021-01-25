package HackerRank;

import org.junit.Test;

// Iterative
// Time O(log n)
// Space O(1)
public class BinarySearch {
    public int isMatched(int[] sorted, int target) {
        int start = 0;
        int end = sorted.length - 1;

        while (end > start) {

            int mid = start + ((end - start) / 2);

            if (sorted[mid] == target) {
                return mid;
            }

            if (sorted[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1;
    }

    @Test
    public void test() {
        int[] array = new int[]{1,2,3,4,5,6,7,8,9};
        int result = isMatched(array, 8);
    }
}
