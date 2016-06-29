package pl.zankowski.algorithm.structures;

/**
 * @author Wojciech Zankowski
 */
public class PoorHashMap<K, V> {

    public static final int CAPACITY = 16;

    private final Entry[] table;

    static class Entry<K, V> {

        private final K key;
        V value;
        Entry next;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Entry<?, ?> entry = (Entry<?, ?>) o;

            if (key != null ? !key.equals(entry.key) : entry.key != null) return false;
            if (value != null ? !value.equals(entry.value) : entry.value != null) return false;
            return next != null ? next.equals(entry.next) : entry.next == null;

        }

        @Override
        public int hashCode() {
            int result = key != null ? key.hashCode() : 0;
            result = 31 * result + (value != null ? value.hashCode() : 0);
            result = 31 * result + (next != null ? next.hashCode() : 0);
            return result;
        }

    }

    public PoorHashMap() {
        this.table = new Entry[CAPACITY];
    }

    public void put(K key, V value) {
        int hash = key.hashCode();
        int bucket = getBucket(hash);

        Entry<K, V> entry = table[bucket];

        while (entry != null) {
            if (entry.getKey().equals(key)) {
                entry.value = value;
                return;
            }
            entry = entry.next;
        }

        Entry<K, V> oldEntry = table[bucket];
        Entry<K, V> newEntry = new Entry<K, V>(key, value);
        newEntry.next = oldEntry;
        table[bucket] = newEntry;
    }

    private int getBucket(int hash) {
        return hash & (CAPACITY - 1);
    }

    public V get(K key) {
        int hash = key.hashCode();
        int bucket = getBucket(hash);

        Entry<K, V> entry = table[bucket];

        while (entry != null) {
            if (entry.getKey().equals(key)) {
                return entry.getValue();
            }
            entry = entry.next;
        }

        return null;
    }

    public V remove(K key) {
        int hash = key.hashCode();
        int bucket = getBucket(hash);

        Entry<K, V> entry = table[bucket];
        Entry<K, V> previousEntry = null;
        while (entry != null) {
            if (entry.getKey().equals(key)) {
                final V value = entry.getValue();
                if (previousEntry != null) {
                    previousEntry.next = entry.next;
                } else {
                    table[bucket] = null;
                }
                return value;
            }

            previousEntry = entry;
            entry = entry.next;
        }

        return null;
    }

}
