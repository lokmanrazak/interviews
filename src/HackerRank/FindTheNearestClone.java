package HackerRank;

import org.junit.Test;

import java.util.*;

// BFS
// undirected graph
public class FindTheNearestClone {
    static int findShortest(int graphNodes, int[] graphFrom, int[] graphTo, long[] ids, int val) {

        // create graph
        Graph graph = new Graph(graphNodes);

        // add undirected edges
        for (int i = 0; i < graphFrom.length; i++) {
            graph.addEdges(graphFrom[i], graphTo[i]);
        }

        List<Integer> shortestPaths = new ArrayList<>();

        for (int i = 0; i < ids.length; i++) {
            if (ids[i] == val) {
                int shortestPath = graph.bfs(i, ids);
                if (shortestPath != -1) {
                    shortestPaths.add(shortestPath);
                }
            }
        }

        return shortestPaths.stream().sorted().findFirst().orElse(-1);
    }

    static class Graph {
        private int nodeCount;
        private LinkedList<Integer>[] adjacencyList;

        Graph(int totalNodes) {
            this.nodeCount = totalNodes;
            adjacencyList = new LinkedList[totalNodes];

            for (int i = 0; i < totalNodes; i++) {
                adjacencyList[i] = new LinkedList<>();
            }
        }

        void addEdges(int u, int v) {
            adjacencyList[u - 1].add(v);
            adjacencyList[v - 1].add(u);
        }

        int bfs(int startNodeIndex, long[] nodeColor) {
            boolean[] visited = new boolean[nodeCount];
            Queue<Integer> queue = new LinkedList<>();
            Set<Integer> edgeCountSet = new HashSet<>();
            int edgeCount = 0;

            visited[startNodeIndex] = true;
            queue.add(startNodeIndex + 1);

            while (!queue.isEmpty()) {

                int currentNode = queue.remove();
                LinkedList<Integer> adjacentNodes = adjacencyList[currentNode - 1];

                edgeCount++;

                for (int adjNode : adjacentNodes) {

                    if (!visited[adjNode - 1]) {
                        visited[adjNode - 1] = true;
                        queue.add(adjNode);

                        if (nodeColor[startNodeIndex] == nodeColor[adjNode - 1]) {
                            edgeCountSet.add(edgeCount);
                        }
                    }
                }
            }

            return edgeCountSet.stream().sorted().findFirst().orElse(-1);
        }
    }

    @Test
    public static void test() {
        int result = findShortest(
                4,
                new int[]{1,1,4},
                new int[]{2,3,2},
                new long[]{1,2,1,1},
                1
        );
    }
}
