public class Ejercicio1 {
    public static void main(String[] args) {
        Graph red = new Graph();

        red.addEdge("Ana", "Luis");
        red.addEdge("Ana", "Marta");
        red.addEdge("Luis", "Pedro");
        red.addEdge("Marta", "Sofia");
        red.addEdge("Pedro", "Diego");

        System.out.println("BFS en red social desde Ana:");
        System.out.println(red.bfs("Ana"));
    }
}
