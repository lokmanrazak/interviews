package HackerRank;

import org.junit.Test;

import java.util.*;

// Dijsktra
public class BfsShortestReachInAGraph {

    static int[] getDistances(int totalNodes, int[][] adjacencyMatrix, int startNodeIndex) {

        int[] result = dijkstraMatrix(adjacencyMatrix, startNodeIndex);

        int[] dist = new int[totalNodes - 1];

        for (int i = 0; i < totalNodes; i++) {
            if (result[i] != 0) {
                if (i < startNodeIndex) {
                    dist[i] = result[i];
                } else {
                    dist[i - 1] = result[i];
                }
            }
        }

        return dist;
    }

    static int[] getDistances(int totalNodes, int startNodeIndex) {
        DPQ dpq = new DPQ(6);
        dpq.addEdges(0, 4, 6);
        dpq.addEdges(0, 1, 6);
        dpq.addEdges(1, 2, 6);
        dpq.addEdges(2, 3, 6);

        dpq.dijkstra(startNodeIndex);

        int[] result = new int[totalNodes - 1];

        for (int i = 0; i < dpq.distances.length; i++) {
            if (dpq.distances[i] != 0) {
                if (i < startNodeIndex) {
                    result[i] = dpq.distances[i];
                } else {
                    result[i - 1] = dpq.distances[i];
                }
            }
        }

        return result;
    }

        static int minDistance(int dist[], boolean[] sptSet) {

        int min = Integer.MAX_VALUE;
        int min_index = -1;

        for (int i = 0; i < dist.length; i++) {
            if (sptSet[i] == false && dist[i] <= min) {
                min = dist[i];
                min_index = i;
            }
        }

        return min_index;
    }

    static int[] dijkstraMatrix(int[][] graph, int src) {

        int totalNodes = graph.length;

        int[] dist = new int[totalNodes];

        boolean[] sptSet = new boolean[totalNodes];

        for (int i = 0; i < totalNodes; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        dist[src] = 0;

        for (int i = 0; i < totalNodes - 1; i++) {

            int u = minDistance(dist, sptSet);

            sptSet[u] = true;

            for (int v = 0; v < totalNodes; v++) {
                if (!sptSet[v] &&
                    graph[u][v] != 0 &&
                    dist[u] != Integer.MAX_VALUE &&
                    dist[u] + graph[u][v] < dist[v]) {

                    dist[v] = dist[u] + graph[u][v];

                }
            }
        }

        return dist;
    }

    // from geeksforgeeks
    // contained bugs but now fixed
    // https://www.geeksforgeeks.org/dijkstras-shortest-path-algorithm-in-java-using-priorityqueue/
    static class DPQ {
        private int totalNodes;
        private int[] distances;
        private Set<Integer> settled;
        private PriorityQueue<Node> queue;
        private List<List<Node>> adjacencyList;

        DPQ(int totalNodes) {
            this.totalNodes = totalNodes;
            distances = new int[totalNodes];
            settled = new HashSet<>();
            queue = new PriorityQueue<>(totalNodes, new Node());
            adjacencyList = new ArrayList<>(totalNodes);
            for (int i = 0; i < totalNodes; i++) {
                adjacencyList.add(i, new ArrayList<>());
            }
        }

        void addEdges(int u, int v, int cost) {
            adjacencyList.get(u).add(new Node(v, cost));
            adjacencyList.get(v).add(new Node(u, cost));
        }

        void dijkstra(int src) {
            for (int i = 0; i < totalNodes; i++) {
                distances[i] = Integer.MAX_VALUE;
            }

            queue.add(new Node(src, 0));

            distances[src] = 0;

            while (queue.size() != 0) {

                int node = queue.remove().node;

                settled.add(node);

                processNeighbours(node);
            }
        }

        private void processNeighbours(int node) {
            int edgeDistance = -1;
            int newDistance = -1;

            List<Node> neighbours = adjacencyList.get(node);

            for (int i = 0; i < neighbours.size(); i++) {
                Node v = neighbours.get(i);

                if (!settled.contains(v.node)) {
                    edgeDistance = v.cost;
                    newDistance = distances[node] + edgeDistance;

                    if (newDistance < distances[v.node]) {
                        distances[v.node] = newDistance;

                        queue.add(new Node(v.node, distances[v.node]));
                    }
                }
            }
        }
    }

    static class Node implements Comparator<Node> {
        public int node;
        public int cost;

        Node(){}

        Node(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }

        @Override
        public int compare(Node node1, Node node2) {
            if (node1.cost < node2.cost) {
                return -1;
            }
            if (node1.cost > node2.cost) {
                return 1;
            }
            return 0;
        }
    }

//    static class Graph {
//        private int totalNodes;
//        private LinkedList<Integer>[] adjacentList;
//
//        Graph(int totalNodes) {
//            this.totalNodes = totalNodes;
//            adjacentList = new LinkedList[totalNodes];
//
//            for (int i = 0; i < totalNodes; i++) {
//                adjacentList[i] = new LinkedList<>();
//            }
//        }
//
//        void addEdges(int u, int v) {
//            adjacentList[u - 1].add(v);
//            adjacentList[v - 1].add(u);
//        }
//
//        int[] bfs(int node) {
//            boolean[] visited = new boolean[totalNodes];
//            Queue<Integer> queue = new LinkedList<>();
//            int distance = 0;
//            int[] distanceArray = new int[totalNodes - 1];
//
//            visited[node - 1] = true;
//            queue.add(node);
//
//            while (!queue.isEmpty()) {
//                int currentNode = queue.remove();
//                LinkedList<Integer> adjacentNodes = adjacentList[currentNode];
//                distance++;
//
//                for (int adjNode : adjacentNodes) {
//                    if (!visited[adjNode - 1]) {
//                        visited[adjNode - 1] = true;
//                        queue.add(adjNode);
//
//                        if (adjNode > node) {
//                            distanceArray[adjNode - 2] = distance;
//                        } else {
//                            distanceArray[adjNode - 1] = distance;
//                        }
//                    }
//                }
//            }
//
//            for (int i = 0; i < distanceArray.length; i++) {
//                if (distanceArray[i] == 0) {
//                    distanceArray[i] = -1;
//                } else {
//                    distanceArray[i] = distanceArray[i] * 6;
//                }
//            }
//
//            return distanceArray;
//        }
//    }

    @Test
    public void test() {
        int[] result = getDistances(
                6,
                new int[][] {
                        {0,6,0,0,6,0},
                        {6,0,6,0,0,0},
                        {0,6,0,6,0,0},
                        {0,0,6,0,0,0},
                        {6,0,0,0,0,0},
                        {0,0,0,0,0,0}
                },
                1
                );
    }

    @Test
    public void test1() {
        int[] result = getDistances(6, 1);



    }
}
