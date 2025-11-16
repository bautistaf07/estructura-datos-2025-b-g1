    public class BFSExample {
    public static void main(String[] args) {
        Graph g = new Graph();

        g.addEdge("A", "B");
        g.addEdge("A", "C");
        g.addEdge("B", "D");

        System.out.println("Recorrido BFS desde A:");
        System.out.println(g.bfs("A")); // [A, B, C, D]
    }
}
