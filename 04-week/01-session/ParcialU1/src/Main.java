import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Catalogo catalogo = new Catalogo(5, 3);  // máx 5 libros, 3 sucursales
        ListaPrestamos prestamos = new ListaPrestamos(); // lista simple
        Historial historial = new Historial();   // lista doble

        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- MENÚ ---");
            System.out.println("1. Alta de libro");
            System.out.println("2. Baja de libro");
            System.out.println("3. Buscar libro por título");
            System.out.println("4. Actualizar stock");
            System.out.println("5. Listar catálogo");
            System.out.println("6. Prestar libro");
            System.out.println("7. Devolver libro");
            System.out.println("8. Ver historial adelante");
            System.out.println("9. Ver historial atrás");
            System.out.println("10. Salir");
            System.out.print("Opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1: // Alta de libro
                    System.out.print("Código: ");
                    int cod = sc.nextInt(); sc.nextLine();
                    System.out.print("Título: ");
                    String tit = sc.nextLine();
                    System.out.print("Autor: ");
                    String aut = sc.nextLine();
                    System.out.print("Stock: ");
                    int stk = sc.nextInt();

                    Libro nuevo = new Libro(cod, tit, aut, stk);
                    int[] dist = new int[3];
                    for (int i = 0; i < dist.length; i++) {
                        System.out.print("Disponibilidad sucursal " + (i + 1) + ": ");
                        dist[i] = sc.nextInt();
                    }

                    if (catalogo.cargarLibro(nuevo, dist)) {
                        System.out.println("Libro agregado.");
                        historial.registrar("ALTA", "Libro " + cod + " - " + tit);
                    } else {
                        System.out.println("No se pudo agregar.");
                    }
                    break;

                case 2: // Baja de libro
                    System.out.print("Código de libro a eliminar: ");
                    int codBaja = sc.nextInt();
                    if (catalogo.eliminarLibro(codBaja)) {
                        System.out.println("Libro dado de baja.");
                        historial.registrar("BAJA", "Libro " + codBaja);
                    } else {
                        System.out.println("No encontrado.");
                    }
                    break;

                case 3: // Buscar libro
                    System.out.print("Título a buscar: ");
                    String buscar = sc.nextLine();
                    Libro res = catalogo.buscarLibroPorTitulo(buscar);
                    if (res != null) {
                        System.out.println(res);
                    } else {
                        System.out.println("No encontrado.");
                    }
                    break;

                case 4: // Actualizar stock
                    System.out.print("Código: ");
                    int codStock = sc.nextInt();
                    System.out.print("Nueva cantidad de stock: ");
                    int nuevoStock = sc.nextInt();
                    if (catalogo.actualizarStock(codStock, nuevoStock - catalogo.buscarLibroPorCodigo(codStock).stock)) {
                        System.out.println("Stock actualizado.");
                        historial.registrar("STOCK", "Libro " + codStock + " nuevo stock=" + nuevoStock);
                    } else {
                        System.out.println("Error al actualizar.");
                    }
                    break;

                case 5: // Listar catálogo
                    catalogo.listarCatalogo();
                    break;

                case 6: // Prestar libro
                    System.out.print("Código libro: ");
                    int codPrestamo = sc.nextInt(); sc.nextLine();
                    System.out.print("Usuario: ");
                    String usuario = sc.nextLine();

                    Libro libroPrestamo = catalogo.buscarLibroPorCodigo(codPrestamo);
                    if (libroPrestamo != null && libroPrestamo.activo && libroPrestamo.stock > 0) {
                        libroPrestamo.stock--;
                        prestamos.insertarFinal(codPrestamo, usuario);
                        System.out.println("Préstamo registrado.");
                        historial.registrar("PRESTAMO", "Libro " + codPrestamo + " a " + usuario);
                    } else {
                        System.out.println("No disponible.");
                    }
                    break;

                case 7: // Devolver libro
                    System.out.print("Código libro: ");
                    int codDev = sc.nextInt(); sc.nextLine();
                    System.out.print("Usuario: ");
                    String userDev = sc.nextLine();

                    if (prestamos.devolverLibro(codDev, userDev)) {
                        Libro libroDev = catalogo.buscarLibroPorCodigo(codDev);
                        if (libroDev != null) {
                            libroDev.stock++;
                        }
                        System.out.println("Devolución exitosa.");
                        historial.registrar("DEVOLUCION", "Libro " + codDev + " de " + userDev);
                    } else {
                        System.out.println("Préstamo no encontrado.");
                    }
                    break;

                case 8: // Historial adelante
                    historial.listarAdelante();
                    break;

                case 9: // Historial atrás
                    historial.listarAtras();
                    break;

                case 10:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 10);

        sc.close();
    }
}
