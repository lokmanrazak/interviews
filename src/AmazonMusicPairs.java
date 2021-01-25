import java.util.*;

public class AmazonMusicPairs {
    public static long getSongPairCount(Integer[] songs) {

//        Map<Integer, Integer> pairs = new HashMap<>();
//
//        for (int i = 0; i < songs.length; i++) {
//            if (songs[i] <= 60) {
//                if (pairs.containsKey(songs[i])) {
//
//                } else {
//                    pairs.put(songs[i], 0);
//                }
//            }
//        }

//        Map<Integer, Integer> map = new HashMap<>();
//        int res = 0;
//        for(int n : songs) {
//            n = n%60;
//            if(map.containsKey(60 - n == 60 ? 0 : 60 - n))
//                res += map.get(60 - n == 60 ? 0 : 60 - n);
//            map.put(n, map.getOrDefault(n, 0) + 1);
//        }
//        return res;

        int k = 60;
        int n = songs.length;
        int ans = 0;

        // sort the given list
        List<Integer> songList = Arrays.asList(songs);
        Collections.sort(songList);

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++)
            {
                if (((songList.get(i) + songList.get(j)) % k) == 0) {
                    ans++;
                }
            }
        }

        return ans;
    }
}
