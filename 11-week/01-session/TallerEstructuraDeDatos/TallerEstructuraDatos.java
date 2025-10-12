import java.util.ArrayList;
import java.util.Scanner;

public class TallerEstructuraDatos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<String> productos = new ArrayList<>();
        String[] categorias = {"Tecnología", "Hogar", "Aseo", "Bebidas", "Snacks"};

        int opcion;
        do {
            System.out.println("\n--- MENÚ DE TECHMARKET ---");
            System.out.println("1. Agregar producto");
            System.out.println("2. Listar productos");
            System.out.println("3. Eliminar producto");
            System.out.println("4. Mostrar categorías");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            while (!sc.hasNextInt()) { // controla entradas inválidas
                System.out.print("Opción inválida. Intente de nuevo: ");
                sc.next(); // descarta entrada
            }
            opcion = sc.nextInt();
            sc.nextLine(); // limpia salto de línea

            switch (opcion) {
                case 1 -> {
                    System.out.print("Ingrese nombre del producto: ");
                    String p = sc.nextLine().trim();
                    if (!p.isEmpty()) {
                        productos.add(p);
                        System.out.println("Producto agregado correctamente.");
                    } else {
                        System.out.println("El nombre no puede estar vacío.");
                    }
                }
                case 2 -> {
                    System.out.println("\nProductos registrados:");
                    if (productos.isEmpty()) {
                        System.out.println("No hay productos registrados.");
                    } else {
                        for (String prod : productos) {
                            System.out.println("- " + prod);
                        }
                    }
                }
                case 3 -> {
                    System.out.print("Ingrese el nombre del producto a eliminar: ");
                    String eliminar = sc.nextLine().trim();
                    if (eliminar.isEmpty()) {
                        System.out.println("El nombre no puede estar vacío.");
                    } else if (productos.remove(eliminar)) {
                        System.out.println("Producto eliminado con éxito.");
                    } else {
                        System.out.println("El producto no existe en la lista.");
                    }
                }
                case 4 -> {
                    System.out.println("Categorías disponibles:");
                    for (String cat : categorias) {
                        System.out.println("* " + cat);
                    }
                }
                case 0 -> System.out.println("Saliendo del sistema...");
                default -> System.out.println("Opción no válida, intente de nuevo.");
            }
        } while (opcion != 0);

        sc.close();
    }
}