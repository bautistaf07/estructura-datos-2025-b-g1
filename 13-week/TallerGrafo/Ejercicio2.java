public class Ejercicio2 {
    public static void main(String[] args) {
        Graph mapa = new Graph();

        mapa.addEdge("Bogota", "Medellin");
        mapa.addEdge("Bogota", "Cali");
        mapa.addEdge("Medellin", "Barranquilla");
        mapa.addEdge("Cali", "Cartagena");
        mapa.addEdge("Barranquilla", "Bucaramanga");

        System.out.println("BFS en mapa desde Bogota:");
        System.out.println(mapa.bfs("Bogota"));
    }
}
