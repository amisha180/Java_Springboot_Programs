package Core_Java.Collections.Map;

public class HashMap<K,V> {
    private static final int CAPACITY = 16;
    private HashNode<K,V>[] bucket;
    private int size;
    public HashMap(){
      this(CAPACITY);
    }
    public HashMap(int capacity){
        bucket = (HashNode<K, V>[]) new HashNode[capacity];
       size=0;
    }
    public V put(K key,V value){
        int index = getIndex(key);
        V prevValue=null;
        while (bucket[index]!=null && !bucket[index].key.equals(key)){
            index = (index+1)% bucket.length;
        }
        if(bucket[index] ==null){
            bucket[index] = new HashNode<K,V>(key,value);
            size++;
        }
        else{
            prevValue = bucket[index].value;
            bucket[index].value = value;
        }

        return prevValue;
    }
    public V get(K key){
        int index = getIndex(key);
        while(bucket[index]!=null){
            if(bucket[index].key.equals(key)){
                return bucket[index].value;
            }
            index = (index +1) % bucket.length;
        }
        return null;
    }
    public int size(){
        return size;
    }
    private int getIndex(K key){
        return Math.abs( key.hashCode() % bucket.length);
    }
    private static class HashNode<K,V>{
        K key;
        V value;
        HashNode(K key,V value){
            this.key = key;
            this.value =value;
        }
    }
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);

        System.out.println("Value of 'one': " + map.get("one"));
        System.out.println("Value of 'two': " + map.get("two"));
        System.out.println("Value of 'four': " + map.get("four"));
        System.out.println("Size of map: " + map.size());
    }
}
