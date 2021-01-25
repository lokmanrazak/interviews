import java.util.ArrayDeque;
import java.util.Deque;

public class JobScheduleMinDifficulty1 {
    public int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;
        if (n < d) return -1;

        int[] dp = new int[n]; // dp[i] stores the min difficulty of a schedule that ends at job i

        // set up dp for the first day
        dp[0] = jobDifficulty[0];
        for(int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i-1], jobDifficulty[i]);
        }

        // second day and more ...
        for(int k = 1; k < d; k++) {
            // for every element in the stack, idx, dp[idx] is the min difficulty of the schedule
            // that ends at job idx and the last day's max difficulty is jobDifficulty[idx]
            // if an index is not in the stack, its schedule min difficulty must be the same as
            // the nearest one in front of it that is in the stack.
            Deque<Integer> stack = new ArrayDeque<>();
            int[] dp2 = new int[n];
            for(int i = k; i < n; i++) {
                dp2[i] = dp[i - 1] + jobDifficulty[i];
                while(!stack.isEmpty() && jobDifficulty[stack.peek()] <= jobDifficulty[i]){
                    int idx = stack.pop();
                    // try to absorb [idx..i] into the same last day
                    // see if we can make any improvement
                    dp2[i] = Math.min(dp2[i], dp2[idx] - jobDifficulty[idx] + jobDifficulty[i]);
                }

                if(!stack.isEmpty() && dp2[i] > dp2[stack.peek()]){
                    // in this case, we shall merge [stack.peek() .. i] into the same day
                    dp2[i] = dp2[stack.peek()];
                    // since the max difficulty of day i is not jobDifficulty[i],
                    // we will not add i to the stack
                } else {
                    // dp2[i] is the min difficulty of the schedule that ends at job i
                    // and the max difficulty of the last day is jobDifficulty[i]
                    stack.push(i);
                }
            }
            dp = dp2;
        }

        return dp[n-1];
    }
}
