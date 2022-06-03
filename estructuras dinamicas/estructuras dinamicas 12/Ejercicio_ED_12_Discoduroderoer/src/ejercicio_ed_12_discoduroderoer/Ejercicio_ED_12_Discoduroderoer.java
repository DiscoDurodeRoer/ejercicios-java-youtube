package ejercicio_ed_12_discoduroderoer;

public class Ejercicio_ED_12_Discoduroderoer {

    public static void main(String[] args) {

        BinarySearchTree<Integer> arbol = new BinarySearchTree<>();

        arbol.add(8);

        arbol.add(4);
        NodoArbolBinario<Integer> t = arbol.add(arbol.getRoot(), 10);
        NodoArbolBinario<Integer> t2 = arbol.add(arbol.getRoot(), 12);
        arbol.add(1);
        
        System.out.println("La altura del arbol desde el root es "+arbol.height(arbol.getRoot()));
        
        System.out.println("La altura del arbol desde el nodo 10 es "+arbol.height(t));

        System.out.println("La profundidad del nodo 12 es "+arbol.depth(t2));
        
    }

}
