// Fecha: 2025-09-08 | Versión: 3.0 | Autor: Francisco Bautista Vanegas
class ListaSimple {
    private Nodo cabeza;

    // Inserta al inicio (O(1))
    public void insertarInicio(int valor) {
        Nodo nuevo = new Nodo(valor);
        nuevo.siguiente = cabeza;
        cabeza = nuevo;
    }

    // Inserta al final (O(n))
    public void insertarFinal(int valor) {
        Nodo nuevo = new Nodo(valor);
        if (cabeza == null) { cabeza = nuevo; return; }
        Nodo actual = cabeza;
        while (actual.siguiente != null) actual = actual.siguiente;
        actual.siguiente = nuevo;
    }

    // Inserta en posición (0 = inicio). Si pos > tamaño, inserta al final.
    public void insertarEnPosicion(int valor, int pos) {
        if (pos <= 0) { insertarInicio(valor); return; }
        Nodo nuevo = new Nodo(valor);
        Nodo actual = cabeza;
        int i = 0;
        while (actual != null && i < pos - 1) { actual = actual.siguiente; i++; }
        if (actual == null) { insertarFinal(valor); return; }
        nuevo.siguiente = actual.siguiente;
        actual.siguiente = nuevo;
    }

    // Elimina en posición (0 = inicio). Devuelve true si elimina.
    public boolean eliminarEnPosicion(int pos) {
        if (cabeza == null) return false;
        if (pos <= 0) { cabeza = cabeza.siguiente; return true; }
        Nodo actual = cabeza;
        int i = 0;
        while (actual.siguiente != null && i < pos - 1) { actual = actual.siguiente; i++; }
        if (actual.siguiente == null) return false; // posición no existe
        actual.siguiente = actual.siguiente.siguiente;
        return true;
    }

    public void mostrar() {
        if (cabeza == null) { System.out.println("Lista vacía"); return; }
        Nodo a = cabeza;
        while (a != null) {
            System.out.print(a.dato);
            if (a.siguiente != null) System.out.print(" -> ");
            a = a.siguiente;
        }
        System.out.println();
    }
}
