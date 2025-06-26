import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DAGPathCounter {

    static class Graph {
        int V;
        List<List<Integer>> adj;

        public Graph(int V) {
            this.V = V;
            adj = new ArrayList<>();
            for (int i = 0; i < V; i++)
                adj.add(new ArrayList<>());
        }

        void addEdge(int u, int v) {
            adj.get(u).add(v);
        }

        List<Integer> topologicalSort() {
            boolean[] visited = new boolean[V];
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < V; i++)
                if (!visited[i])
                    dfs(i, visited, stack);
            List<Integer> order = new ArrayList<>();
            while (!stack.isEmpty())
                order.add(stack.pop());
            return order;
        }

        void dfs(int u, boolean[] visited, Stack<Integer> stack) {
            visited[u] = true;
            for (int v : adj.get(u))
                if (!visited[v])
                    dfs(v, visited, stack);
            stack.push(u);
        }

        int[] countPathsToNodes() {
            List<Integer> topoOrder = topologicalSort();
            int[] paths = new int[V];
            for (int node : topoOrder)
                paths[node] = 1;

            for (int u : topoOrder) {
                for (int v : adj.get(u)) {
                    paths[v] += paths[u];
                }
            }

            return paths;
        }
    }
}
