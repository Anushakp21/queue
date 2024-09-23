package queue;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

class LRUCache {
    private final int capacity;
    private Queue<Integer> cache;
    private HashSet<Integer> hashSet;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new LinkedList<>();
        this.hashSet = new HashSet<>();
    }

    public void refer(int key) {
        if (!hashSet.contains(key)) {
            if (cache.size() == capacity) {
                int removed = cache.poll(); // remove the least recently used item
                hashSet.remove(removed);    // also remove it from the set
            }
        } else {
            cache.remove(key); // Remove the key from its current position
        }

        cache.offer(key);  // Add the key to the end (most recently used)
        hashSet.add(key);  // Add the key to the set
    }

    public void display() {
        for (int key : cache) {
            System.out.print(key + " ");
        }
        System.out.println();
    }
}

public class LRUCacheDemo {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(4);

        cache.refer(1);
        cache.refer(2);
        cache.refer(3);
        cache.refer(1);  // Access 1 again (most recently used now)
        cache.refer(4);
        cache.refer(5);  // This should remove the least recently used element (2)

        System.out.println("Current cache state:");
        cache.display();
    }
}
