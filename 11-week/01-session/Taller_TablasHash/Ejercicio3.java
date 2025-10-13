public class Ejercicio3 {
    // Clave con hash malo: todos comparten el mismo hashCode
    static final class BadKey {
        final String s;
        BadKey(String s) { this.s = s; }
        @Override public int hashCode() { return 42; } // constante → misma cubeta
        @Override public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof BadKey)) return false;
            BadKey other = (BadKey) o;
            return s.equals(other.s);
        }
        @Override public String toString() { return s; }
    }

    public static void main(String[] args) {
        HashTable<BadKey, Integer> ht = new HashTable<BadKey, Integer>();
        for (int i = 1; i <= 5; i++) {
            ht.put(new BadKey("k" + i), i);
        }
        System.out.println("get(k3) = " + ht.get(new BadKey("k3"))); // 3
        System.out.println("size = " + ht.size());                   // 5
        System.out.println("remove(k2) = " + ht.remove(new BadKey("k2"))); // 2
        System.out.println("size = " + ht.size());                   // 4
    }
}
