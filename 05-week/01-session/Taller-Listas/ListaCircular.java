// Fecha: 2025-09-08 | Versión: 3.1 | Autor: Francisco Bautista Vanegas
class ListaCircular {
    private Nodo ultimo; // apunta al último; ultimo.siguiente es la cabeza

    public void insertarFinal(int v) {
        Nodo n = new Nodo(v);
        if (ultimo == null) {
            ultimo = n;
            ultimo.siguiente = ultimo; // se apunta a sí misma
            return;
        }
        n.siguiente = ultimo.siguiente;
        ultimo.siguiente = n;
        ultimo = n;
    }

    // elimina el primer nodo con ese valor; devuelve true si elimina
    public boolean eliminarValor(int v) {
        if (ultimo == null) return false;
        Nodo act = ultimo.siguiente, ant = ultimo;
        do {
            if (act.dato == v) {
                if (act == ant) { // un solo nodo
                    ultimo = null;
                } else {
                    ant.siguiente = act.siguiente;
                    if (act == ultimo) ultimo = ant;
                }
                return true;
            }
            ant = act; act = act.siguiente;
        } while (act != ultimo.siguiente);
        return false;
    }

    public void mostrar() {
        if (ultimo == null) { System.out.println("Lista vacía"); return; }
        Nodo a = ultimo.siguiente;
        do {
            System.out.print(a.dato);
            a = a.siguiente;
            if (a != ultimo.siguiente) System.out.print(" -> ");
        } while (a != ultimo.siguiente);
        System.out.println(" (circular)");
    }
}
