package util;

import tree.Tree;
import utils.Position;

/**
 *
 * @author jvelez
 */
public class DegreeCalculator {

    public int calculate(Tree <?> t) {
        if (t.isEmpty()) {
            return 0;
        } else {
            int max = -99;

            for (Position p: t) {
                int contador = 0;
                for(Object hijo: t.children(p)) {
                    contador++;
                }
                if (contador > max) {
                    max = contador;
                }
            }
            return max;
        }
    }
}
