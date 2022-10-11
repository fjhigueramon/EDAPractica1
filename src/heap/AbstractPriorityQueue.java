package heap;

import utils.Pair;

import java.util.Comparator;

public abstract class AbstractPriorityQueue<K,V> implements PriorityQueue<K,V> {

    private Comparator<K> comp;

    protected AbstractPriorityQueue(Comparator<K> c) { comp = c; }

    protected AbstractPriorityQueue() { this(new DefaultComparator<K>()); }

    protected int compare(Pair<K,V> a, Pair<K,V> b) {
        return comp.compare(a.getFirst(), b.getFirst());
    }

    protected boolean checkKey(K key) throws IllegalArgumentException {
        try {
            return (comp.compare(key,key) == 0);
        } catch (ClassCastException e) {
            throw new IllegalArgumentException("Incompatible key");
        }
    }

    public boolean isEmpty() {
        return size() == 0;
    }

}
