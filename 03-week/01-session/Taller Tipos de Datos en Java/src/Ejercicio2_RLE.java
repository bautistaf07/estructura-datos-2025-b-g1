//Ejercicio 2: Comprensión Run-Length(RLE)
public class Ejercicio2_RLE {

    public static void main(String[] args) {

        String texto = "aaabbcccccd";
        //Se hace el paso 3, se construye el resultado con StringBuilder
        String comprimido = comprimirRLE(texto);

// se realiza el paso 4, que calcula el ratio como double. Controla división por cero si el texto está vacío
        double ratio = (double) comprimido.length() / texto.length();


        System.out.println("Texto original: " + texto);
        System.out.println("Texto comprimido (RLE): " + comprimido);
        System.out.println("Longitud original: " + texto.length());
        System.out.println("Longitud comprimida: " + comprimido.length());
        System.out.println("Ratio de compresión: " + ratio);
    }


    public static String comprimirRLE(String input) {
        if (input == null || input.isEmpty()) {
            return "";
        }
        //Se hace el paso 3, se construye el resultado con StringBuilder
        StringBuilder resultado = new StringBuilder();

        //Lleva un contador int para repeticiones consecutivas
        int contador = 1;

        //Se hace el paso 1, usar char[] o recorrer el String con índice
        char actual = input.charAt(0);

//Paso 5, se maneja mayúsculas/minúsculas tal cual (no se normaliza)
        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) == actual) {
                contador++;
            } else {
                resultado.append(actual).append(contador);
                actual = input.charAt(i);
                contador = 1;
            }
        }
        resultado.append(actual).append(contador);

        return resultado.toString();
    }
}
//Fin del Ejercicio2