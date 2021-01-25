package HackerRank;

public class AlternatingCharacters {

    // Complete the alternatingCharacters function below.
    static int alternatingCharacters(String s) {

        int startIndex = 0;
        int deletion = 0;

        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(startIndex) == s.charAt(i + 1)) {
                deletion++;
            } else {
                startIndex = i + 1;
            }
        }

        return deletion;
    }

}
