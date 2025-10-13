public class Ejercicio4 {
    public static void main(String[] args) {
        HashTable<Integer, String> t = new HashTable<Integer, String>();
        int n = 1000;
        for (int i = 0; i < n; i++) t.put(i, "v" + i);
        System.out.println("Insertados: " + n);
        System.out.println("size() reporta: " + t.size());
        System.out.println("isEmpty(): " + t.isEmpty());
        System.out.println("get(123) = " + t.get(123));
        System.out.println("remove(123) = " + t.remove(123));
        System.out.println("size() tras remove: " + t.size());
    }
}
