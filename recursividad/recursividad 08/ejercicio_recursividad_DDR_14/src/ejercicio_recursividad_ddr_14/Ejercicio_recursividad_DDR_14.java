package ejercicio_recursividad_ddr_14;

import arbol.BinarySearchTree;
import arbol.NodoArbolBinario;
import lista_dinamica.ListaDinamica;

public class Ejercicio_recursividad_DDR_14 {

    public static void main(String[] args) {

        BinarySearchTree<Integer> arbol = new BinarySearchTree();

        arbol.add(8);
        arbol.add(4);
        arbol.add(10);
        arbol.add(12);
        arbol.add(1);
        arbol.add(0);
        arbol.add(2);
        arbol.add(9);
        arbol.add(20);
        arbol.add(30);
        arbol.add(14);
        arbol.add(16);
        arbol.add(15);
        arbol.add(13);

        ListaDinamica<Integer> l = new ListaDinamica<>();
        rellenaElementos(arbol.getRoot(), l, 5, 15);
        
        for (Integer i:l) {
            System.out.println(i);
        }
        
        
        
    }

    public static void rellenaElementos(NodoArbolBinario<Integer> nodo,
                                        ListaDinamica<Integer> lista,
                                        int min, int max) {

        if (nodo.getElement() >= min && nodo.getElement() <= max) {
            lista.addFirst(nodo.getElement());
        }

        if (nodo.getLeft() != null) {
            rellenaElementos(nodo.getLeft(), lista, min, max);
        }

        if (nodo.getRight() != null) {
            rellenaElementos(nodo.getRight(), lista, min, max);
        }

    }

}
