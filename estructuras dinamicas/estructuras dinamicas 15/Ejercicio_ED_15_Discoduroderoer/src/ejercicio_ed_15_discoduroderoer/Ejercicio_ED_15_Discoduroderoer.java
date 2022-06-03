package ejercicio_ed_15_discoduroderoer;

import lista_dinamica.ListaDinamica;

public class Ejercicio_ED_15_Discoduroderoer {

    public static void main(String[] args) {
        BinarySearchTree<Integer> arbol = new BinarySearchTree<>();

        arbol.add(8); // root

        //Añadir
        NodoArbolBinario<Integer> t4 = arbol.add(4);
        arbol.add(arbol.getRoot(), 10);
        arbol.add(arbol.getRoot(), 12);
        arbol.add(1);
        arbol.add(0);
        arbol.add(2);
        NodoArbolBinario<Integer> t = arbol.add(9);
        arbol.add(20);
        arbol.add(30);
        NodoArbolBinario<Integer> t2 = arbol.add(14);
        arbol.add(16);
        arbol.add(15);
        NodoArbolBinario<Integer> t3 = arbol.add(13);

        arbol.mostrar(arbol.getRoot());
    }

}
