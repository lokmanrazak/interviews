package LeetCode;

import org.junit.Test;

import java.util.Stack;

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] T) {

//        Brute force
//        int[] days = new int[T.length];
//
//        for (int i = 0; i < T.length; i++) {
//
//            int next = 1;
//
//            while (i + next < T.length) {
//
//                if (T[i] < T[i + next]) {
//                    days[i] = next;
//                    break;
//                }
//
//                next++;
//            }
//
//        }
//
//        return days;

        int[] days = new int[T.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < T.length; i++) {

            while (!stack.isEmpty() && T[stack.peek()] < T[i]) {
                int index = stack.pop();
                days[index] = i -index;
            }

            stack.push(i);

        }

        return days;
    }

    @Test
    public void test() {
        int[] result = dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
    }
}
