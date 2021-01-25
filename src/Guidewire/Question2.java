package Guidewire;

import org.junit.Test;

import java.util.*;

public class Question2 {

    public int solution(int[] A, int K, int L) {
        // write your code in Java SE 8

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int[] kArray = new int[A.length - K + 1];
        int[] lArray = new int[A.length - L + 1];

        for (int i = 0; i < A.length; i++) {

            int sumK = 0;
            int maxKIndex = i + K - 1;

            if (maxKIndex < A.length) {

                sumK = kArray[i];
                if (sumK == 0) {

                    int count = 0;
                    while (count != K) {
                        int index = i + count;
                        sumK += A[index];
                        count++;
                    }

                    kArray[i] = sumK;
                }

            }

            for (int j = 0; j < A.length; j++) {

                if (maxKIndex < j || maxKIndex < i) {

                    int maxLIndex = j + L - 1;

                    if (maxLIndex < A.length) {

                        int sumL = lArray[j];

                        if (sumL == 0) {

                            int count = 0;
                            while (count != L) {
                                int index = j + count;
                                sumL += A[index];
                                count++;
                            }

                            lArray[j] = sumL;
                        }

                        int sum = sumK + sumL;
                        pq.add(sum);
                    }

                }


            }

        }

        return pq.isEmpty() ? -1 : pq.peek();
    }

    @Test
    public void test() {
        int result = solution(new int[]{6,1,4,6,3,2,7,4}, 3, 2);

        int r2 = solution(new int[]{1,2,3,4,5,6,7,8}, 3, 2);
    }
}
