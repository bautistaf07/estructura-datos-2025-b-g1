public class Ejercicio3 {
    public static void main(String[] args) {
        Graph g = new Graph();

        // Componente 1
        g.addEdge("A", "B");
        g.addEdge("B", "C");

        // Componente 2
        g.addEdge("X", "Y");

        System.out.println("BFS desde A (componente 1): " + g.bfs("A"));
        System.out.println("BFS desde X (componente 2): " + g.bfs("X"));
    }
}
