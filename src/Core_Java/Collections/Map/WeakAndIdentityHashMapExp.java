package Core_Java.Collections.Map;

import java.util.IdentityHashMap;
import java.util.WeakHashMap;

public class WeakAndIdentityHashMapExp {
    public static void main(String[] args) {
        WeakHashMap<String,String> weakmap = new WeakHashMap<String,String>();
        IdentityHashMap<String,String> identitymap = new IdentityHashMap<String,String>();
        HashMap<String,String> map = new HashMap<>();
//Identity HashMap
        String a = new String("amisha");
        String b = new String("amisha");


        identitymap.put(a,"first");
        identitymap.put(b,"second");

//        map.put(a,"first");
//        map.put(b,"second");

//        System.out.println("map");
//        System.out.println(map.size());
//        System.out.println(map.get(a));
//        System.out.println(map.get(b));
//
//        System.out.println("Identity map");
//        System.out.println(identitymap.size());
//        System.out.println(identitymap.get(a));
//        System.out.println(identitymap.get(b));
//Weak HashMap
        String key1 = new String("key1");
        String key2 = new String("key2");

        weakmap.put(key1, "value1");
        weakmap.put(key2, "value2");

        map.put("x", "value1");
        map.put("y", "value2");

        // Keys are strongly referenced here
        System.out.println("Before GC: " + weakmap.toString()); // Output: {key1=value1, key2=value2}
        System.out.println("Before GC: " + map.size()); // Output: {key1=value1, key2=value2}

        // Remove strong references
        key1 = null;
        key2 = null;

        // Request garbage collection
        System.gc();

        // Wait for a moment to allow GC to happen
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // After GC, the entries for key1 and key2 may have been removed
        System.out.println("After GC: " + weakmap.toString()); // Output: {}
        System.out.println("After GC: " + map.size()); // Output: {}

    }
}
