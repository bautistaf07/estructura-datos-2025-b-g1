//Ejercicio 3: Estadisticas de temperaturas
public class Ejercicio3_Temperaturas {
    public static void main(String[] args) {

        String datos = "23.4,21.8,22.1,24.9,20.5";
        //Primero se muestran los resultados
        String[] partes = datos.split(",");
        double[] temperaturas = new double[partes.length];

        for (int i = 0; i < partes.length; i++) {
            temperaturas[i] = Double.parseDouble(partes[i].trim());
        }
        //Se recorre para obtener min, max y sum (paso 2)
        double min = temperaturas[0];
        double max = temperaturas[0];
        double suma = 0;

        for (double t : temperaturas) {
            if (t < min) min = t;
            if (t > max) max = t;
            suma += t;
        }
        // se saca el Promedio = suma / n (Paso 3)
        double promedio = suma / temperaturas.length;

        //Varianza = promedio de (xi - avg)^2, Desviación = sqrt(var) (Paso 4)
        double varianza = 0;
        for (double t : temperaturas) {
            varianza += Math.pow(t - promedio, 2);
        }
        varianza /= temperaturas.length;
        double desviacion = Math.sqrt(varianza);
        // Considera entradas vacías o con espacios (ya manejado con trim arriba) (Paso 5)
        System.out.println("Mínimo: " + min);
        System.out.println("Máximo: " + max);
        System.out.println("Promedio: " + promedio);
        System.out.println("Desviación estándar: " + desviacion);
    }
}
//Fin del Ejercicio3