package Core_Java.Collections.LRUCacheExp;
import java.util.HashMap;

public class LRUCacheExp {
    class Node{
       int key;
       int value;
       Node prev;
       Node next;
        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    private final int capacity;
    private final Node head;
    private final Node tail;
    private  final HashMap<Integer,Node> cache=new HashMap<>();

    public LRUCacheExp(int capacity){
        this.capacity = capacity;
        this.head = new Node(-1,-1);
        this.tail = new Node(-1,-1);

        head.next = tail;
        tail.prev = head;
    }

    public int getKey(int key){
        if(cache.containsKey(key)){
            Node node = cache.get(key);
            // Move the accessed node to the front of the list
            moveToHead(node);
            return node.value;
        }
        return -1;
    }
    public void putKey(int key,int value){
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.value = value;

            // Move the updated node to the front of the list
            moveToHead(node);
        } else {
            Node newNode = new Node(key, value);

            if (cache.size() >= capacity) {
                // Remove the least recently used node from the linked list and the hashmap
                Node lruNode = removeTail();
                cache.remove(lruNode.key);
            }

            // Add the new node to the hashmap and the front of the linked list
            cache.put(key, newNode);
            addToHead(newNode);
        }
    }
    private void moveToHead(Node node) {
        // Remove the node from its current position
        removeNode(node);

        // Add the node to the front of the list
        addToHead(node);
    }
    private Node removeTail() {
        Node node = tail.prev;
        removeNode(node);
        return node;
    }
    private void addToHead(Node node) {
        node.prev = head;
        node.next = head.next;

        head.next.prev = node;
        head.next = node;
    }
    private void removeNode(Node node) {
        Node prevNode = node.prev;
        Node nextNode = node.next;

        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }


    public static void main(String[] args) {
        LRUCacheExp cache = new LRUCacheExp(2);

        cache.putKey(1, 1);
        cache.putKey(2, 2);
        System.out.println(cache.getKey(1)); // returns 1

        cache.putKey(3, 3);                  // evicts key 2
        System.out.println(cache.getKey(2)); // returns -1 (not found)

        cache.putKey(4, 4);                  // evicts key 1
        System.out.println(cache.getKey(1)); // returns -1 (not found)
        System.out.println(cache.getKey(3)); // returns 3
        System.out.println(cache.getKey(4)); // returns 4
    }


}
