package ejercicio_ed_9_discoduroderoer;

/**
 * Arbol binario de busqueda o BST
 *
 * @author DDR
 * @param <T>
 */
public class BinarySearchTree<T extends Comparable<T>> {

    //Nodo principal
    private NodoArbolBinario<T> root;

    /**
     * Indica si el arbol esta vacio
     *
     * @return true si esta vacio
     */
    public boolean isEmpty() {
        return root == null;
    }

    /**
     * Devuelve el nodo root
     *
     * @return nodo root
     */
    public NodoArbolBinario<T> getRoot() {
        return root;
    }

    /**
     * Indica si el nodo pasado es el root
     *
     * @param nodo
     * @return true si el nodo es el root
     */
    public boolean isRoot(NodoArbolBinario<T> nodo) {
        return root == nodo;
    }

    /**
     * Indica si es una hoja el nodo pasado como parametro
     *
     * @param nodo
     * @return true si es una hoja
     */
    public boolean isLeaf(NodoArbolBinario<T> nodo) {
        return nodo.getLeft() == null && nodo.getRight() == null;
    }

    /**
     * Indica si el nodo pasado como parametro tiene nodos hijos
     *
     * @param nodo
     * @return
     */
    public boolean isInternal(NodoArbolBinario<T> nodo) {
        return !isLeaf(nodo);
    }
    
    

}
