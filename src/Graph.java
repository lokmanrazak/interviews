import java.util.LinkedList;
import java.util.Queue;

public class Graph {

    private int totalNodes;
    private LinkedList<Integer>[] adjacentNodes;

    public Graph(int totalNodes) {
        this.totalNodes = totalNodes;

        adjacentNodes = new LinkedList[totalNodes];
        for (int i = 0; i < totalNodes; i++) {
            adjacentNodes[i] = new LinkedList<>();
        }
    }

    public void addDirectedEdge(int start, int end) {
        adjacentNodes[start].add(end);
    }

    public void addUndirectedEdge(int a, int b) {
        adjacentNodes[a].add(b);
        adjacentNodes[b].add(a);
    }

    // will traverse from a starting node
    public void bfs(int node) {
        boolean[] visited = new boolean[totalNodes];
        Queue<Integer> queue = new LinkedList<>();

        visited[node] = true;
        queue.add(node);

        while (queue.size() > 0) {

            int currentNode = queue.remove();
            LinkedList<Integer> currentAdjNodes = adjacentNodes[currentNode];

            for (int adjacentNode : currentAdjNodes) {
                if (!visited[adjacentNode]) {
                    visited[adjacentNode] = true;
                    queue.add(adjacentNode);
                }
            }
        }
    }

    // Will traverse all nodes to discover disconnected graph
    public void dfs() {
        boolean[] visited = new boolean[totalNodes];

        for (int i = 0; i < totalNodes; i++) {
            if (!visited[i]) {
                dfsUtil(i, visited);
            }
        }
    }

    // recursive dfs
    public void dfsUtil(int node, boolean[] visited) {
        visited[node] = true;

        LinkedList<Integer> currentAdjNodes = adjacentNodes[node];

        for (int adjNode : currentAdjNodes) {
            if (!visited[adjNode]) {
                visited[adjNode] = true;
                dfsUtil(adjNode, visited);
            }
        }
    }

    // reverse/transpose a graph by reversing the direction of all the edges
    public Graph reverse() {

        Graph reversed = new Graph(totalNodes);

        for (int node = 0; node < totalNodes; node++) {
            LinkedList<Integer> oldAdjNodes = adjacentNodes[node];
            for (int oldAdjNode : oldAdjNodes) {
                reversed.addDirectedEdge(oldAdjNode, node);
            }
        }

        return reversed;
    }
}
