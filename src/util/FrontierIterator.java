package util;

import utils.Position;
import tree.Tree;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author jvelez
 * @param <E>
 */
public class FrontierIterator <E> implements Iterator <Position<E>> {

    ArrayList<Position<E>> lista = new ArrayList<Position<E>>();

    private void meterLista(ArrayList<Position<E>> lista, Tree<E> tree, Position<E> p) {
        if (tree.isLeaf(p)){
            lista.add(p);
        } else {
            for (Position<E> hijo: tree.children(p)) {
                meterLista(lista, tree, hijo);
            }
        }
    }

    public FrontierIterator(Tree <E> tree) {
        if (!tree.isEmpty()) {
            meterLista(lista, tree, tree.root());
        }
    }

    @Override
    public boolean hasNext() {
         return (!lista.isEmpty());
    }

    @Override
    public Position<E> next() {
         return lista.remove(0);
    }
    
    
}
