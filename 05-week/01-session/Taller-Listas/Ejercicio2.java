// Fecha: 2025-09-08 | Versión: 1.0 | Autor: Francisco Bautista Vanegas
public class Ejercicio2 {
    public static void main(String[] args) {
        ListaSimple lista = new ListaSimple();
        lista.insertarEnPosicion(5, 0);   // inicio
        lista.insertarEnPosicion(10, 1);  // medio/fin
        lista.insertarEnPosicion(7, 1);   // en posición
        lista.mostrar(); // 5 -> 7 -> 10
    }
}
