// Prestamo.java
public class Prestamo {
    int codigoLibro;
    String usuario;
    boolean devuelto;
    Prestamo siguiente;

    // Constructor simple (2 parámetros)
    public Prestamo(int c, String u) {
        codigoLibro = c;
        usuario = u;
        devuelto = false;
        siguiente = null;
    }
}
