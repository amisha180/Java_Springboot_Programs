package Core_Java.PractiseJava;

public class HashMapEx<K,V> {
    private int size;
    private static final int CAPACITY =16;
    private HashNode<K,V>[] buckets;

    public HashMapEx(){
        this(CAPACITY);
    }
    public HashMapEx(int capacity){
        size=0;
        buckets = (HashNode<K, V>[]) new HashNode[capacity];
    }

    public V get(K key){
        int index=getIndex(key);
        while(buckets[index]!=null && buckets[index].key.equals(key)){
            index = (index+1)%buckets.length;
        }
        if (buckets[index]!=null && buckets[index].key.equals(key)){
            return buckets[index].value;
        }
        return null;
    }

    private int getIndex(K key){
        return Math.abs(key.hashCode()% buckets.length);
    }
    public int getSize(){
        return size;
    }
    private static class HashNode<K,V>{
        K key;
        V value;
        HashNode(K key, V value){
            this.key = key;
            this.value = value;
        }
    }
}
