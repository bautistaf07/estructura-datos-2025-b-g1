/*
 Clase Historial:
 Lista doblemente enlazada para guardar operaciones del sistema.

 Complejidad:
 - Insertar al final: O(1) si usamos referencia a la cola.
 - Recorrer adelante/atrás: O(n).
*/

public class Historial {
    Operacion cabeza; // primer nodo
    Operacion cola;   // último nodo

    // Insertar operación al final
    public void registrar(String tipo, String detalle) {
        Operacion nueva = new Operacion(tipo, detalle);
        if (cabeza == null) {
            cabeza = nueva;
            cola = nueva;
        } else {
            cola.siguiente = nueva;
            nueva.anterior = cola;
            cola = nueva;
        }
    }

    // Listar en orden de inserción (adelante)
    public void listarAdelante() {
        System.out.println("\n=== Historial (adelante) ===");
        Operacion temp = cabeza;
        while (temp != null) {
            System.out.println(temp);
            temp = temp.siguiente;
        }
    }

    // Listar en orden inverso (atrás)
    public void listarAtras() {
        System.out.println("\n=== Historial (atrás) ===");
        Operacion temp = cola;
        while (temp != null) {
            System.out.println(temp);
            temp = temp.anterior;
        }
    }
}
