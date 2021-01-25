import org.junit.Test;

public class JobScheduleMinDifficultyTest {
    @Test
    public void runTest() {
        int[] jobDiff = new int[] {7,1,7,1,7};

        int minDiff = JobScheduleMinDifficulty.minDifficulty(jobDiff, 3);
    }
}
