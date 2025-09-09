// Fecha: 2025-09-08 | Versión: 1.0 | Autor: Francisco Bautista Vanegas
public class Ejercicio3 {
    public static void main(String[] args) {
        ListaSimple lista = new ListaSimple();
        for (int v : new int[]{1,2,3,4}) lista.insertarFinal(v);
        lista.mostrar();
        System.out.println("Elimina pos 2: " + lista.eliminarEnPosicion(2));
        System.out.println("Elimina pos 10 (invalida): " + lista.eliminarEnPosicion(10));
        lista.mostrar();
    }
}
