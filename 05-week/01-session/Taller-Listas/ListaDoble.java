// Fecha: 2025-09-08 | Versión: 3.0 | Autor: Francisco Bautista Vanegas
class ListaDoble {
    static class NodoD {
        int dato;
        NodoD ant, sig;
        NodoD(int d) { dato = d; }
    }

    private NodoD cabeza, cola;

    public void insertarInicio(int v) {
        NodoD n = new NodoD(v);
        n.sig = cabeza;
        if (cabeza != null) cabeza.ant = n;
        cabeza = n;
        if (cola == null) cola = n;
    }

    public void insertarFinal(int v) {
        NodoD n = new NodoD(v);
        n.ant = cola;
        if (cola != null) cola.sig = n;
        cola = n;
        if (cabeza == null) cabeza = n;
    }

    public void mostrarAdelante() {
        NodoD a = cabeza;
        if (a == null) { System.out.println("Lista vacía"); return; }
        while (a != null) {
            System.out.print(a.dato);
            if (a.sig != null) System.out.print(" <-> ");
            a = a.sig;
        }
        System.out.println();
    }

    public void eliminarInicio() {
        if (cabeza == null) return;
        cabeza = cabeza.sig;
        if (cabeza != null) cabeza.ant = null; else cola = null;
    }

    public void eliminarFinal() {
        if (cola == null) return;
        cola = cola.ant;
        if (cola != null) cola.sig = null; else cabeza = null;
    }
}
