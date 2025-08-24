public class Ejercicio1_ISBN13 {

    public static boolean isValidISBN13(String isbn) {
        // Primero se verifica que no sea nulo, que tenga longitud 13 y que solo contenga dígitos
        if (isbn == null || isbn.length() != 13) return false;

        int suma = 0; // acumulador de la suma
        for (int i = 0; i < isbn.length(); i++) {
            char c = isbn.charAt(i);

            // Validar que cada carácter sea un dígito
            if (!Character.isDigit(c)) return false;

            // Paso 2: convertir char a número
            int d = c - '0';

            // Paso 3: multiplicar alternando 1 y 3 según la posición
            suma += d * (i % 2 == 0 ? 1 : 3);
        }

        // Paso 4: ISBN válido si la suma es múltiplo de 10
        return suma % 10 == 0;
    }

    public static void main(String[] args) {
        // Ejemplo de prueba con un ISBN válido
        String prueba = "9780306406157";
        System.out.println("ISBN válido? " + isValidISBN13(prueba));
    }
}
//Fin del Ejercicio1