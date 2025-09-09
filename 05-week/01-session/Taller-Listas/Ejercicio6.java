// Fecha: 2025-09-08 | Versión: 2.0 | Autor: Francisco Bautista Vanegas
// Simula una lista de espera (cola simple): encolar = insertarFinal, atender = eliminarEnPosicion(0)
public class Ejercicio6 {
    public static void main(String[] args) {
        ListaSimple cola = new ListaSimple();
        cola.insertarFinal(101); // paciente 101
        cola.insertarFinal(102);
        cola.insertarFinal(103);
        cola.mostrar();
        cola.eliminarEnPosicion(0); // atiende al primero
        cola.mostrar();
    }
}
