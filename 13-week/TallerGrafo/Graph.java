import java.util.*;

public class Graph {
    private final Map<String, List<String>> adj = new HashMap<>();

    public void addVertex(String v) {
        adj.putIfAbsent(v, new ArrayList<>());
    }

    public void addEdge(String v1, String v2) {
        addVertex(v1);
        addVertex(v2);
        adj.get(v1).add(v2);
        adj.get(v2).add(v1); // grafo no dirigido
    }

    public List<String> bfs(String start) {
        List<String> order = new ArrayList<>();
        if (!adj.containsKey(start)) return order;

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new ArrayDeque<>();

        visited.add(start);
        queue.add(start);

        while (!queue.isEmpty()) {
            String u = queue.poll();
            order.add(u);

            for (String v : adj.get(u)) {
                if (!visited.contains(v)) {
                    visited.add(v);
                    queue.add(v);
                }
            }
        }
        return order;
    }

    // Para DFS en Ejercicio4
    public List<String> getNeighbors(String v) {
        return adj.getOrDefault(v, Collections.emptyList());
    }
}
