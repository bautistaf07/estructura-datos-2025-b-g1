//Ejercicio 4: Conversor de bases y control de overflow
import java.math.BigInteger;
public class Ejercicio4_ConversorBases {
    public static void main(String[] args) {
        String numero = "7FFFFFFFFFFFFFFF";
        int baseOrigen = 16;

        //Primero se normaliza el string (por ejemplo, hex en mayúsculas)
        numero = numero.trim().toUpperCase();

        //Se valida que los caracteres sean válidos para la base indicada (Paso 2)
        boolean usoBigInt = false;
        BigInteger valor;

        try {
            //Paso 3, se intenta parsear a long si cabe
            long val = Long.parseLong(numero, baseOrigen);
            //Si falla o se desborda, se usa BigInteger
            valor = BigInteger.valueOf(val);
        } catch (Exception e) {

            valor = new BigInteger(numero, baseOrigen);
            usoBigInt = true;
        }
        //En el paso 4, se convierte a binario y hex con toString(2) y toString(16)
        String binario = valor.toString(2);
        String decimal = valor.toString(10);
        String hexadecimal = valor.toString(16).toUpperCase();

        //Se reporta si hubo uso de BigInteger (bandera boolean)
        System.out.println("Número original: " + numero + " (base " + baseOrigen + ")");
        System.out.println("En binario: " + binario);
        System.out.println("En decimal: " + decimal);
        System.out.println("En hexadecimal: " + hexadecimal);
        System.out.println("¿Se usó BigInteger?: " + usoBigInt);
    }
}
//Fin del Ejercicio4