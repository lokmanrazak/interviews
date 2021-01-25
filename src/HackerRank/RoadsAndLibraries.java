package HackerRank;

import org.junit.Test;

import java.util.*;

// DFS
// Undirected Graph
// Connected Components

public class RoadsAndLibraries {

    // Complete the roadsAndLibraries function below.
    static long roadsAndLibraries(int n, int c_lib, int c_road, int[][] cities) {

        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return c_lib;
        }

        // create land
        Land hackerland = new Land(n);

        for (int[] road : cities) {
            hackerland.addRoad(road[0], road[1]);
        }

        // get connected cities
        List<Set<Integer>> connectedCities = hackerland.getConnectedCities();

        // calculate cost
        int totalRoads = 0;

        for (Set<Integer> roads : connectedCities) {
            totalRoads =+ (roads.size() - 1);
        }

        if ((n * c_lib) < (totalRoads * c_road)) {
            return n * c_lib;
        }

        return (totalRoads * c_road) + (connectedCities.size() * c_lib);
    }

    static class Land {
        private int totalCities;
        private LinkedList<Integer>[] adjacentCities;

        Land(int totalCities) {
            this.totalCities = totalCities;
            adjacentCities = new LinkedList[totalCities];
            for (int i = 0; i < totalCities; i++) {
                adjacentCities[i] = new LinkedList<>();
            }
        }

        void addRoad(int city1, int city2) {
            adjacentCities[city1 - 1].add(city2);
            adjacentCities[city2 - 1].add(city1);
        }

        void dfs(int cityIndex, boolean[] visited, Set<Integer> connectedCities) {
            visited[cityIndex] = true;
            connectedCities.add(cityIndex + 1);

            for (int adjCity : adjacentCities[cityIndex]) {
                int adjCityIndex = adjCity - 1;

                if (!visited[adjCityIndex]) {
                    dfs(adjCityIndex, visited, connectedCities);
                }
            }
        }

        // get connected components from undirected graph
        List<Set<Integer>> getConnectedCities() {
            boolean[] visited = new boolean[totalCities];
            List<Set<Integer>> connectedCityList = new ArrayList<>();

            for (int i = 0; i < totalCities; i++) {
                if (!visited[i]) {
                    Set<Integer> connectedCities = new HashSet<>();

                    dfs(i, visited, connectedCities);

                    connectedCityList.add(connectedCities);
                }
            }

            return connectedCityList;
        }
    }

    @Test
    public void test() {
        long cost = roadsAndLibraries(6, 1, 1,
                new int[][]{
                        new int[] { 1, 3 },
                        new int[] { 3, 4 },
                        new int[] { 2, 4 },
                        new int[] { 1, 2 },
                        new int[] { 2, 3 },
                        new int[] { 5, 6 }
        });

        // debug statement
        System.out.println("test");
    }
}
