import java.util.*;

public class Ejercicio4 {

    public static List<String> dfs(Graph g, String start) {
        List<String> order = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        Deque<String> stack = new ArrayDeque<>();

        stack.push(start);

        while (!stack.isEmpty()) {
            String u = stack.pop();

            if (visited.contains(u)) {
                continue;
            }

            visited.add(u);
            order.add(u);

            // Añadimos vecinos en orden inverso para que se vea la diferencia con BFS
            List<String> neighbors = new ArrayList<>(g.getNeighbors(u));
            Collections.reverse(neighbors);
            for (String v : neighbors) {
                if (!visited.contains(v)) {
                    stack.push(v);
                }
            }
        }
        return order;
    }

    public static void main(String[] args) {
        Graph g = new Graph();

        g.addEdge("A", "B");
        g.addEdge("A", "C");
        g.addEdge("B", "D");
        g.addEdge("C", "D");
        g.addEdge("D", "E");

        System.out.println("BFS desde A: " + g.bfs("A"));
        System.out.println("DFS desde A: " + dfs(g, "A"));
    }
}
