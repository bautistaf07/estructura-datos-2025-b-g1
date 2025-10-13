import java.util.Scanner;

public class Ejercicio1 {
    public static void main(String[] args) {
        HashTable<String, String> roles = new HashTable<String, String>();
        Scanner sc = new Scanner(System.in);
        int op = -1;

        do {
            System.out.println("\n--- Diccionario usuario → rol ---");
            System.out.println("1. Agregar / Actualizar usuario");
            System.out.println("2. Consultar rol");
            System.out.println("3. Eliminar usuario");
            System.out.println("4. Ver tamaño / ¿Vacío?");
            System.out.println("0. Salir");
            System.out.print("Opción: ");

            while (!sc.hasNextInt()) { sc.next(); System.out.print("Ingrese número: "); }
            op = sc.nextInt(); sc.nextLine();

            switch (op) {
                case 1:
                    System.out.print("Usuario: ");
                    String u = sc.nextLine().trim();
                    System.out.print("Rol: ");
                    String r = sc.nextLine().trim();
                    String prev = roles.put(u, r);
                    if (prev == null) System.out.println("Guardado.");
                    else System.out.println("Actualizado (antes: " + prev + ").");
                    break;
                case 2:
                    System.out.print("Usuario: ");
                    String c = sc.nextLine().trim();
                    String rol = roles.get(c);
                    System.out.println(rol == null ? "No existe." : "Rol: " + rol);
                    break;
                case 3:
                    System.out.print("Usuario: ");
                    String d = sc.nextLine().trim();
                    String out = roles.remove(d);
                    System.out.println(out == null ? "No existía." : "Eliminado rol=" + out);
                    break;
                case 4:
                    System.out.println("size=" + roles.size() + " | isEmpty=" + roles.isEmpty());
                    break;
                case 0:
                    System.out.println("Fin.");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (op != 0);

        sc.close();
    }
}
