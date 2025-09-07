/*
 Clase Libro:
 Representa un libro dentro del catálogo.
*/
public class Libro {
    public static void main(String[] args){}
    int codigo;
    String titulo;
    String autor;
    int stock;
    boolean activo; // sirve para baja lógica

    // Constructor: inicializa los atributos
    public Libro(int c, String t, String a, int s) {
        codigo = c;
        titulo = t;
        autor = a;
        stock = s;
        activo = true; // siempre se inicia activo
    }

    // Se usa para mostrar la información del libro
    public String toString() {
        return "Código: " + codigo +
                " | Título: " + titulo +
                " | Autor: " + autor +
                " | Stock: " + stock +
                " | Activo: " + activo;
    }
}
