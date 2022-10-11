package heap;

import utils.Pair;

import java.util.ArrayList;
import java.util.Comparator;

public class HeapPriorityQueue<K,V> extends AbstractPriorityQueue<K,V>{
    protected ArrayList<Pair<K,V>> heap = new ArrayList<>();

    public HeapPriorityQueue() {
        super();
    }

    public HeapPriorityQueue(Comparator<K> comp) {
        super(comp);
    }

    protected int parent(int j) {
        return (j - 1) / 2;
    }

    protected int left(int j) {
        return 2*j + 1;
    }

    protected int right(int j) {
        return 2*j + 2;
    }

    protected boolean hasLeft(int j) {
        return left(j) < heap.size();
    }

    protected boolean hasRight(int j) {
        return right(j) < heap.size();
    }

    protected void swap(int i, int j) {
        Pair<K,V> temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    /**
     * Given an index j, this method performs an upward swapping process (up-heap bubbling)
     * to relocate the node present at index j such that the heap structure respects the heap-order property.
     * @param j index of a node
     */
    protected void upHeap(int j) {
        // TODO
    }

    /**
     * Given an index j, this method performs a downward swapping process (down-heap bubbling)
     * to relocate the node present at index j such that the heap structure respects the heap-order property.
     * @param j index of a node
     */
    protected void downHeap(int j) {
        // TODO
    }

    public int size() { return heap.size(); }

    public Pair<K,V> min() {
        if (heap.isEmpty()) return null;
        return heap.get(0);
    }

    /**
     * Places a new node at a position p just beyond the rightmost node at the bottom level of the tree
     * or as the leftmost position of a new level, if the bottom level is already full.
     * This is to maintain the binary tree as a complete binary tree.
     * However, we might have violated the heap-order property, so an upHeap process is then performed.
     * @param key priority of the value
     * @param value element to be stored
     * @return the Pair inserted
     * @throws IllegalArgumentException if an invalid key is provided
     */
    public Pair<K,V> insert(K key, V value) throws IllegalArgumentException {
        checkKey(key);
        Pair<K,V> newest = new Pair<>(key, value);
        heap.add(newest);
        upHeap(heap.size() - 1);
        return newest;
    }


    /**
     * Removes the root node of the tree and returns it. Fixes the tree accordingly performing a downHeap process.
     * @return the pair at the top of the heap
     */
    public Pair<K,V> removeMin() {
        if (heap.isEmpty()) return null;
        Pair<K,V> answer = heap.get(0);
        swap(0, heap.size() - 1);
        heap.remove(heap.size() - 1);
        downHeap(0);
        return answer;
    }

}
