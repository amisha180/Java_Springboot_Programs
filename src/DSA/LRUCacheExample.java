package DSA;

import java.util.LinkedHashMap;
import java.util.Map;

class LRUCache<K, V> extends LinkedHashMap<K, V> {
    private final int capacity;

    public LRUCache(int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > capacity;
    }
}

public class LRUCacheExample {
    public static void main(String[] args) {
        LRUCache<Integer, String> cache = new LRUCache<>(3);

        cache.put(1, "One");
        cache.put(2, "Two");
        cache.put(3, "Three");
        System.out.println("Cache: " + cache);

        // Access some elements
        cache.get(1);
        cache.put(4, "Four");
        System.out.println("Cache after accessing 1 and adding 4: " + cache);

        cache.get(2);
        cache.put(5, "Five");
        System.out.println("Cache after accessing 2 and adding 5: " + cache);

        cache.get(3);
        cache.put(6, "Six");
        System.out.println("Cache after accessing 3 and adding 6: " + cache);
    }
}

