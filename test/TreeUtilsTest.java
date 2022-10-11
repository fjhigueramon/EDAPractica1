import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tree.binarytree.BinaryTree;
import tree.binarytree.InorderBinaryTreeIterator;
import tree.binarytree.LinkedBinaryTree;
import tree.narytree.LinkedTree;
import utils.Position;
import util.DegreeCalculator;
import util.DepthCalculator;
import util.FrontierIterator;

/**
 *
 * @author Abraham Duarte
 */
public class TreeUtilsTest {

	@Test
	public void testFront() {
		LinkedTree<String> arbol = new LinkedTree<>();
		Position<String> raiz = arbol.addRoot("A");
		Position<String> nodo1 = arbol.add("B", raiz);
		Position<String> nodo2 = arbol.add("C", raiz);
		Position<String> nodo3 = arbol.add("D", nodo1);
		Position<String> nodo4 = arbol.add("E", nodo2);
		Position<String> nodo5 = arbol.add("F", nodo2);
		Position<String> nodo6 = arbol.add("G", nodo2);
		Position<String> nodo7 = arbol.add("H", nodo5);
		Position<String> nodo8 = arbol.add("I", nodo5);
                                
		List<Position<String>> leafnodes = new ArrayList<>();
		leafnodes.add(nodo3);
		leafnodes.add(nodo4);
		leafnodes.add(nodo7);
		leafnodes.add(nodo8);
		leafnodes.add(nodo6);
                
		FrontierIterator<String> fi = new FrontierIterator<>(arbol);
		while (fi.hasNext()) {
				Position<String> leaf = fi.next();
				Assertions.assertTrue(leafnodes.contains(leaf));
		}
		Assertions.assertFalse(leafnodes.contains(nodo1));
		Assertions.assertFalse(leafnodes.contains(nodo2));
		Assertions.assertFalse(leafnodes.contains(nodo5));
		Assertions.assertFalse(leafnodes.contains(raiz));
	}

	@Test
	public void testDepth() {
		LinkedTree<String> arbol = new LinkedTree<>();
		DepthCalculator dp = new DepthCalculator();

		Assertions.assertEquals(dp.calculate(arbol), 0);
		Position<String> raiz = arbol.addRoot("A");
		Assertions.assertEquals(dp.calculate(arbol), 1);
		Position<String> nodo1 = arbol.add("B", raiz);
		Assertions.assertEquals(dp.calculate(arbol), 2);
		Position<String> nodo2 = arbol.add("C", raiz);
		Assertions.assertEquals(dp.calculate(arbol), 2);
		Position<String> nodo3 = arbol.add("D", nodo1);
		Assertions.assertEquals(dp.calculate(arbol), 3);
		Position<String> nodo4 = arbol.add("E", nodo2);
		Assertions.assertEquals(dp.calculate(arbol), 3);
		Position<String> nodo5 = arbol.add("F", nodo2);
		Assertions.assertEquals(dp.calculate(arbol), 3);
		Position<String> nodo6 = arbol.add("G", nodo2);
		Assertions.assertEquals(dp.calculate(arbol), 3);
		Position<String> nodo7 = arbol.add("H", nodo5);
		Assertions.assertEquals(dp.calculate(arbol), 4);
		Position<String> nodo8 = arbol.add("I", nodo5);
		Assertions.assertEquals(dp.calculate(arbol), 4);
		arbol.remove(nodo5);
		Assertions.assertEquals(dp.calculate(arbol), 3);
	}

	@Test
	public void testDegree() {
		DegreeCalculator dg = new DegreeCalculator();
            
		LinkedTree<String> arbol = new LinkedTree<String>();
		Assertions.assertEquals(dg.calculate(arbol), 0);
		Position<String> raiz = arbol.addRoot("A");
		Assertions.assertEquals(dg.calculate(arbol), 1);
		Position<String> nodo1 = arbol.add("B", raiz);
		Assertions.assertEquals(dg.calculate(arbol), 1);
		Position<String> nodo2 = arbol.add("C", raiz);
		Assertions.assertEquals(dg.calculate(arbol), 2);
		Position<String> nodo3 = arbol.add("D", nodo1);
		Assertions.assertEquals(dg.calculate(arbol), 2);
		Position<String> nodo4 = arbol.add("E", nodo2);
		Assertions.assertEquals(dg.calculate(arbol), 2);
		Position<String> nodo5 = arbol.add("F", nodo2);
		Assertions.assertEquals(dg.calculate(arbol), 2);
		Position<String> nodo6 = arbol.add("G", nodo2);
		Assertions.assertEquals(dg.calculate(arbol), 3);
		Position<String> nodo7 = arbol.add("H", nodo5);
		Assertions.assertEquals(dg.calculate(arbol), 3);
		Position<String> nodo8 = arbol.add("I", nodo5);
		Assertions.assertEquals(dg.calculate(arbol), 3);
		arbol.remove(nodo5);
		Assertions.assertEquals(dg.calculate(arbol), 2);
		arbol.remove(nodo2);
		Assertions.assertEquals(dg.calculate(arbol), 1);
	}
}