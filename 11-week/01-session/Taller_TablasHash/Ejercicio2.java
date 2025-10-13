import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {
        HashTable<String, Integer> freq = new HashTable<String, Integer>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Texto a contar:");
        String line = sc.nextLine();

        String[] tokens = line.split("\\W+");
        for (int i = 0; i < tokens.length; i++) {
            String w = tokens[i];
            if (w.length() == 0) continue;
            String key = w.toLowerCase();
            Integer c = freq.get(key);
            freq.put(key, (c == null) ? 1 : (c + 1));
        }

        System.out.println("Total palabras distintas: " + freq.size());
        System.out.println("Consulta ejemplo (palabra='java'): " + freq.get("java"));
        sc.close();
    }
}
