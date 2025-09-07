/*
 Clase Catalogo:
 Maneja el catálogo de libros con:
 - Array unidimensional de objetos Libro (estructura lineal, tamaño fijo).
 - Matriz 2D de enteros para disponibilidad por sucursal.

 Explicación de estructuras:
 - Array lineal: acceso directo O(1) por índice.
 - Inserción/búsqueda: O(n) en el peor caso.
 - Recorrido: O(n).
*/

public class Catalogo {
    int MAX_LIBROS;
    Libro[] libros;         // array de libros
    int[][] disponibilidad; // matriz: filas=libros, columnas=sucursales

    // Constructor
    public Catalogo(int maxLibros, int numSucursales) {
        MAX_LIBROS = maxLibros;
        libros = new Libro[MAX_LIBROS];
        disponibilidad = new int[MAX_LIBROS][numSucursales];
    }

    // Alta de libro (si hay espacio y no está duplicado)
    // Complejidad: O(n)
    public boolean cargarLibro(Libro nuevo, int[] dist) {
        // Verificar duplicado
        for (int i = 0; i < MAX_LIBROS; i++) {
            if (libros[i] != null && libros[i].activo && libros[i].codigo == nuevo.codigo) {
                System.out.println("Error: código duplicado.");
                return false;
            }
        }
        // Buscar espacio
        for (int i = 0; i < MAX_LIBROS; i++) {
            if (libros[i] == null || !libros[i].activo) {
                libros[i] = nuevo;
                try {
                    for (int j = 0; j < dist.length; j++) {
                        disponibilidad[i][j] = dist[j];
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Error: cantidad de sucursales no coincide.");
                }
                return true;
            }
        }
        System.out.println("Error: catálogo lleno.");
        return false;
    }

    // Baja lógica por código
    // Complejidad: O(n)
    public boolean eliminarLibro(int codigo) {
        for (int i = 0; i < MAX_LIBROS; i++) {
            if (libros[i] != null && libros[i].activo && libros[i].codigo == codigo) {
                libros[i].activo = false;
                return true;
            }
        }
        return false;
    }

    // Buscar libro por título (lineal)
    // Complejidad: O(n)
    public Libro buscarLibroPorTitulo(String titulo) {
        for (int i = 0; i < MAX_LIBROS; i++) {
            if (libros[i] != null && libros[i].activo &&
                    libros[i].titulo.equalsIgnoreCase(titulo)) {
                return libros[i];
            }
        }
        return null;
    }

    // Buscar libro por código
    // Complejidad: O(n)
    public Libro buscarLibroPorCodigo(int codigo) {
        for (int i = 0; i < MAX_LIBROS; i++) {
            if (libros[i] != null && libros[i].activo &&
                    libros[i].codigo == codigo) {
                return libros[i];
            }
        }
        return null;
    }

    // Actualizar stock de un libro
    // Complejidad: O(n) porque busca por código
    public boolean actualizarStock(int codigo, int cambio) {
        Libro l = buscarLibroPorCodigo(codigo);
        if (l != null) {
            int nuevo = l.stock + cambio;
            if (nuevo >= 0) {
                l.stock = nuevo;
                return true;
            } else {
                System.out.println("Error: stock no puede ser negativo.");
            }
        }
        return false;
    }

    // Listar catálogo
    // Complejidad: O(n)
    public void listarCatalogo() {
        System.out.println("\n=== Catálogo ===");
        for (int i = 0; i < MAX_LIBROS; i++) {
            if (libros[i] != null && libros[i].activo) {
                System.out.println(libros[i]);
                System.out.print(" Disponibilidad: ");
                for (int j = 0; j < disponibilidad[i].length; j++) {
                    System.out.print(disponibilidad[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
