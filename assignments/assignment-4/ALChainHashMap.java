/**
 * @author Robby Renz Abeysinghe
 * Student Number: 3073208
 * Answer of Part B of Assignment 4
 */

import java.util.ArrayList;

public class ALChainHashMap<K,V> extends AbstractHashMap<K,V> {
    // a fixed capacity array of UnsortedTableMap that serves as buckets
    private UnsortedTableMap<K,V>[] table; // initialized within createTable

    // private field that keeps track of the number of collisions that occurred in the hash map
    private int collisions = 0;

    public ALChainHashMap() {
        super();
    }
    public ALChainHashMap(int cap) {
        super(cap);
    }
    public ALChainHashMap(int cap, int p) {
        super(cap, p);
    }
    // creates an empty table having length equal to current capacity
    protected void createTable() {
        table = (UnsortedTableMap<K,V>[]) new UnsortedTableMap[capacity];
    }
    // returns value associated with key k in bucket with hash value h, or else null
    protected V bucketGet(int h, K k) {
        ArrayList<MapEntry<K,V>> bucket = table[h];
        if (bucket == null)
            return null;
        return bucket.get(h);
    }
    // associates key k with value v in bucket with hash value h; returns old value
    protected V bucketPut(int h, K k, V v) {
        ArrayList<MapEntry<K,V>> bucket = (ArrayList) table[h];
        MapEntry<K,V> foo = new MapEntry(k, v);
        if (bucket == null)
            bucket = table[h] = new ArrayList<>();
        V answer = bucket.add(h, foo);
        if (bucket.contains(foo))
            collisions++;
    }
    // removes entry having key k from bucket with hash value h (if any)
    protected V bucketRemove(int h, K k) {
        ArrayList<MapEntry<K,V>> bucket = table[h];
        if (bucket == null)
            return null;
        V answer = bucket.remove(k);
        return answer;
    }
    // returns an iterable collection of all key-value entries of the map
    public Iterable<Entry<K,V>> entrySet() {
        ArrayList<Entry<K,V>> buffer = new ArrayList<>();
        for (int h = 0; h < capacity; h++)
        if (table[h] != null)
            for (Entry<K,V> entry: table[h].entrySet())
                buffer.add(entry);
        return buffer;
    }

    // returns the number of collisions that occurred in the hash map
    public int numCollisions() {
        return collisions;
    }
}
