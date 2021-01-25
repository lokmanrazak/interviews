public class JobScheduleMinDifficulty {
    public static int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;

        // 2d array containing start index and end index for splitting tasks by
        int[][] dp = new int[d][n];

        // assign first job diff to dp
        dp[0][0] = jobDifficulty[0];

        // populate day 1 first using the start index as 0 and end index increment
        for (int index = 1; index < n; index++) {
            dp[0][index] = Math.max(dp[0][index - 1], jobDifficulty[index]);
        }

        // assign no result value to array
        for (int day = 1; day < d; day++) {
            dp[day][0] = -1;
        }

        for (int day = 1; day < d; day++) {
            for (int index = 1; index < n; index++) {
                dp[day][index] = -1;
                if (dp[day - 1][index - 1] != -1) {
                    dp[day][index] = dp[day - 1][index - 1] + jobDifficulty[index];
                    int max = jobDifficulty[index];
                    for (int prev = index - 2; prev >= 0; prev--) {
                        max = Math.max(max, jobDifficulty[prev + 1]);
                        if (dp[day - 1][prev] != -1)
                            dp[day][index] = Math.min(dp[day][index], dp[day - 1][prev] + max);
                    }
                }
            }
        }

        return dp[d - 1][n - 1];
    }
}
