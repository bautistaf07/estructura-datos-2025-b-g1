// Fecha: 2025-09-08 | Versión: 2.0 | Autor: Francisco Bautista Vanegas
public class Ejercicio5 {
    public static void main(String[] args) {
        ListaCircular lc = new ListaCircular();
        lc.insertarFinal(10);
        lc.insertarFinal(20);
        lc.insertarFinal(30);
        lc.mostrar();
        lc.eliminarValor(20);
        lc.mostrar();
    }
}
