import java.util.Objects;

public class HashTable<K, V> {
    private static final int DEFAULT_CAPACITY = 16;     // potencia de 2
    private static final float LOAD_FACTOR = 0.75f;

    private Entry<K, V>[] buckets;
    private int size;          // número de pares K,V
    private int threshold;     // umbral para redimensionar

    @SuppressWarnings("unchecked")
    public HashTable() {
        buckets = (Entry<K, V>[]) new Entry[DEFAULT_CAPACITY];
        threshold = (int) (DEFAULT_CAPACITY * LOAD_FACTOR);
    }

    private int indexFor(Object key, int length) {
        int h = (key == null) ? 0 : key.hashCode();
        h ^= (h >>> 16);                 // mezcla bits altos/bajos
        return h & (length - 1);         // length es potencia de 2
    }

    public int size() { return size; }

    public boolean isEmpty() { return size == 0; }

    // containsKey correcto aunque el valor almacenado sea null
    public boolean containsKey(K key) {
        int idx = indexFor(key, buckets.length);
        Entry<K, V> e = buckets[idx];
        while (e != null) {
            if (Objects.equals(e.key, key)) return true;
            e = e.next;
        }
        return false;
    }

    public V get(K key) {
        int idx = indexFor(key, buckets.length);
        Entry<K, V> e = buckets[idx];
        while (e != null) {
            if (Objects.equals(e.key, key)) return e.value;
            e = e.next;
        }
        return null;
    }

    public V put(K key, V value) {
        if (size + 1 > threshold) resize();
        int idx = indexFor(key, buckets.length);
        Entry<K, V> e = buckets[idx];
        while (e != null) {
            if (Objects.equals(e.key, key)) {
                V old = e.value;
                e.value = value;
                return old;              // actualización
            }
            e = e.next;
        }
        // insertar al inicio (encadenamiento)
        buckets[idx] = new Entry<K, V>(key, value, buckets[idx]);
        size++;
        return null;                      // nueva inserción
    }

    public V remove(K key) {
        int idx = indexFor(key, buckets.length);
        Entry<K, V> prev = null;
        Entry<K, V> e = buckets[idx];
        while (e != null) {
            if (Objects.equals(e.key, key)) {
                if (prev == null) buckets[idx] = e.next;
                else prev.next = e.next;
                size--;
                return e.value;
            }
            prev = e;
            e = e.next;
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    private void resize() {
        int newCap = buckets.length << 1;
        Entry<K, V>[] newBuckets = (Entry<K, V>[]) new Entry[newCap];
        for (int i = 0; i < buckets.length; i++) {
            Entry<K, V> e = buckets[i];
            while (e != null) {
                Entry<K, V> next = e.next;
                int idx = indexFor(e.key, newCap);
                e.next = newBuckets[idx];
                newBuckets[idx] = e;
                e = next;
            }
        }
        buckets = newBuckets;
        threshold = (int) (newCap * LOAD_FACTOR);
    }
}
