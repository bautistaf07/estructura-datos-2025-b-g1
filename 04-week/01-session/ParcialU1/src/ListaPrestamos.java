/*
 Clase ListaPrestamos:
 Implementa una lista enlazada simple de préstamos activos.

 Complejidad:
 - Insertar al final: O(n) (recorre hasta el último nodo).
 - Devolver libro (búsqueda + eliminación): O(n).
 - Listar préstamos: O(n).
*/

public class ListaPrestamos {
    Prestamo cabeza; // primer nodo

    // Insertar préstamo al final de la lista
    public void insertarFinal(int codigoLibro, String usuario) {
        Prestamo nuevo = new Prestamo(codigoLibro, usuario);
        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            Prestamo temp = cabeza;
            while (temp.siguiente != null) {
                temp = temp.siguiente;
            }
            temp.siguiente = nuevo;
        }
    }

    // Devolver libro (busca por código y usuario)
    public boolean devolverLibro(int codigoLibro, String usuario) {
        Prestamo temp = cabeza;
        Prestamo anterior = null;

        while (temp != null) {
            if (temp.codigoLibro == codigoLibro && temp.usuario.equals(usuario) && !temp.devuelto) {
                temp.devuelto = true; // marcar como devuelto
                // eliminar de la lista
                if (anterior == null) {
                    cabeza = temp.siguiente;
                } else {
                    anterior.siguiente = temp.siguiente;
                }
                return true;
            }
            anterior = temp;
            temp = temp.siguiente;
        }
        return false; // no encontrado
    }

    // Listar todos los préstamos activos
    public void listarPrestamos() {
        System.out.println("\n=== Préstamos activos ===");
        Prestamo temp = cabeza;
        while (temp != null) {
            if (!temp.devuelto) {
                System.out.println("Libro: " + temp.codigoLibro + " | Usuario: " + temp.usuario);
            }
            temp = temp.siguiente;
        }
    }
}
