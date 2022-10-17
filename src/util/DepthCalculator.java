package util;

import tree.Tree;
import utils.Position;

import java.util.ArrayList;

/**
 * 
 * @author jvelez
 */
public class DepthCalculator {

    private int queNivel(Tree<?> t, Position p) {
        int contador = 1;
        while (!t.isRoot(p)) {
            contador += 1;
            p = t.parent(p);
        }
        return contador;
    }

    public int calculate(Tree <?> t) {
        if (t.isEmpty()) {
            return 0;
        } else {
            ArrayList<Position> lista = new ArrayList<>();
            for (Position p : t) {
                if (t.isLeaf(p)) {
                    lista.add(p);
                }
            }

            int max = -99;
            int n = 0;
            for (Position p : lista) {
                n = queNivel(t, p);
                if (n > max) {
                    max = n;
                }
            }
            return max;
        }
    }
}