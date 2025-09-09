// Fecha: 2025-09-08 | Versión: 2.0 | Autor: Francisco Bautista Vanegas
public class Ejercicio4 {
    public static void main(String[] args) {
        ListaDoble ld = new ListaDoble();
        ld.insertarInicio(2);
        ld.insertarFinal(3);
        ld.insertarInicio(1);
        ld.mostrarAdelante(); // 1 <-> 2 <-> 3
        ld.eliminarInicio();
        ld.eliminarFinal();
        ld.mostrarAdelante(); // 2
    }
}
