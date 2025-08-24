//Ejercicio 5: Agregación de tiempos de ejecución
public class Ejercicio5_Tiempos {
    public static void main(String[] args) {

        String[] tiempos = {"00:05:33", "00:12:17", "00:03:50"};

        long[] segundos = new long[tiempos.length];
        long total = 0;
        //Paso 1 y 2, parsear cada string HH:MM:SS a segundos -> h*3600 + m*60 + s
        //Ir sumando el total (usar long si la lista puede ser grande)
        for (int i = 0; i < tiempos.length; i++) {
            String[] partes = tiempos[i].split(":");
            int h = Integer.parseInt(partes[0]);
            int m = Integer.parseInt(partes[1]);
            int s = Integer.parseInt(partes[2]);

            segundos[i] = h * 3600 + m * 60 + s;
            total += segundos[i];
        }
        //Pas 3, Promedio = total / n  (usar double si luego habrá porcentajes)
        double promedio = (double) total / tiempos.length;

        //Paso 4, mantener el máximo y su índice
        long max = segundos[0];
        int indiceMax = 0;
        for (int i = 1; i < segundos.length; i++) {
            if (segundos[i] > max) {
                max = segundos[i];
                indiceMax = i;
            }
        }

        // Paso 5, convertir segundos de vuelta a HH:MM:SS (usamos función formatear)
        System.out.println("Tiempo total: " + formatear(total));
        System.out.println("Promedio: " + formatear((long) promedio));
        System.out.println("Tramo más largo: " + tiempos[indiceMax]);

        // Paso 6: Calcular porcentajes = (segmento / total) * 100
        // Controlar el caso total == 0 para evitar división por cero
        System.out.println("\nPorcentaje de cada tramo respecto al total:");
        for (int i = 0; i < segundos.length; i++) {
            double porcentaje = (segundos[i] * 100.0) / total;
            System.out.printf("%s -> %.2f%%\n", tiempos[i], porcentaje);
        }
    }
//Se hace de nuevo el paso 5, conversión de segundos a HH:MM:SS usando divisiones y módulos
    private static String formatear(long segundos) {
        long h = segundos / 3600;
        long m = (segundos % 3600) / 60;
        long s = segundos % 60;
        return String.format("%02d:%02d:%02d", h, m, s);
    }
}
//Fin del Ejercicio5