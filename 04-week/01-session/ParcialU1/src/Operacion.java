/*
 Clase Operacion:
 Nodo de la lista doblemente enlazada.
 Guarda el tipo de operación (ALTA, BAJA, PRESTAMO, DEVOLUCION, STOCK)
 y un detalle en texto.
*/
public class Operacion {
    String tipo;
    String detalle;
    Operacion siguiente;
    Operacion anterior;

    public Operacion(String t, String d) {
        tipo = t;
        detalle = d;
        siguiente = null;
        anterior = null;
    }

    public String toString() {
        return "[" + tipo + "] " + detalle;
    }
}
