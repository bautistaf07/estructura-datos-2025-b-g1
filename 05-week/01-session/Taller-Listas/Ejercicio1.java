// Fecha: 2025-09-08 | Versión: 2.0 | Autor: Francisco Bautista Vanegas
public class Ejercicio1 {
    public static void main(String[] args) {
        ListaSimple lista = new ListaSimple();
        lista.mostrar();
        lista.insertarFinal(10);
        lista.insertarFinal(20);
        lista.insertarFinal(30);
        lista.mostrar(); // 10 -> 20 -> 30
    }
}
