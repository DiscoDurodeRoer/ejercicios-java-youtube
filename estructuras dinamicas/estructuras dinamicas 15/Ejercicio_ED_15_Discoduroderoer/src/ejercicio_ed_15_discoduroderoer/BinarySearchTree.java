package ejercicio_ed_15_discoduroderoer;

import lista_dinamica.ListaDinamica;

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

    /**
     * Añade un nodo de forma recursiva
     *
     * @param origen
     * @param elemento
     * @return nodo añadido
     */
    public NodoArbolBinario<T> add(NodoArbolBinario<T> origen, T elemento) {

        NodoArbolBinario<T> nodo = null;
        //Si el root es nulo, lo añade el primero
        if (root == null) {
            nodo = new NodoArbolBinario<>(elemento);
            root = nodo;
        } else if (origen == null) { //el parametro pasado es invalido
            System.out.println("El origen es nulo");
        } else {

            //Comparamos los elementos
            //Si el nodo del origen es mayor que el elemento pasado, pasa a la izquierda
            if (origen.getElement().compareTo(elemento) > 0) {

                //Si tiene nodo izquierdo, hago la llamada recursiva
                if (origen.getLeft() != null) {
                    nodo = add(origen.getLeft(), elemento);
                } else {
                    //Creo el nodo
                    nodo = new NodoArbolBinario<>(elemento);
                    //Indico que el padre del nodo creado
                    nodo.setParent(origen);
                    //Indico que el nodo es el nodo izquierdo del origen
                    origen.setLeft(nodo);
                }

            } else { //sino pasa a la derecha

                //Si tiene nodo derecho, hago la llamada recursiva
                if (origen.getRight() != null) {
                    nodo = add(origen.getRight(), elemento);
                } else {
                    //Creo el nodo
                    nodo = new NodoArbolBinario<>(elemento);
                    //Indico que el padre del nodo creado
                    nodo.setParent(origen);
                    //Indico que el nodo es el nodo izquierdo del origen
                    origen.setRight(nodo);
                }

            }

        }

        return nodo;

    }

    /**
     * Añade un nodo de forma iterativa
     *
     * @param elemento
     * @return nodo añadido
     */
    public NodoArbolBinario<T> add(T elemento) {

        NodoArbolBinario<T> nodo = null;
        //Si el root es nulo, lo añade el primero
        if (root == null) {
            nodo = new NodoArbolBinario<>(elemento);
            root = nodo;
        } else {

            //Creo un nodo auxuliar
            NodoArbolBinario<T> aux = root;
            boolean insertado = false;
            //No salgo hasta que este insertado
            while (!insertado) {

                //Comparamos los elementos
                //Si el nodo del origen es mayor que el elemento pasado, pasa a la izquierda
                if (aux.getElement().compareTo(elemento) > 0) {

                    //Si tiene nodo izquierdo, actualizo el aux
                    if (aux.getLeft() != null) {
                        aux = aux.getLeft();
                    } else {
                        //Creo el nodo
                        nodo = new NodoArbolBinario<>(elemento);
                        //Indico que el padre del nodo creado
                        nodo.setParent(aux);
                        aux.setLeft(nodo);
                        //indico que lo he insertado
                        insertado = true;
                    }

                } else {

                    if (aux.getRight() != null) {
                        aux = aux.getRight();
                    } else {
                        //Creo el nodo
                        nodo = new NodoArbolBinario<>(elemento);
                        //Indico que el padre del nodo creado
                        nodo.setParent(aux);
                        aux.setRight(nodo);
                        //indico que lo he insertado
                        insertado = true;
                    }

                }

            }

        }

        return nodo;

    }

    /**
     * Recorre los nodos, primero el padre y despues los hijos
     *
     * @param nodo
     */
    public void preorder(NodoArbolBinario<T> nodo) {

        System.out.println(nodo.getElement().toString());

        if (nodo.getLeft() != null) {
            preorder(nodo.getLeft());
        }

        if (nodo.getRight() != null) {
            preorder(nodo.getRight());
        }

    }

    /**
     * Recorre los nodos, lo recorre de izquierda a derecha
     *
     * @param nodo
     */
    public void inorder(NodoArbolBinario<T> nodo) {

        if (nodo.getLeft() != null) {
            inorder(nodo.getLeft());
        }

        System.out.println(nodo.getElement().toString());

        if (nodo.getRight() != null) {
            inorder(nodo.getRight());
        }

    }

    /**
     * Recorre los nodos, primero los hijos y luego el padre
     *
     * @param nodo
     */
    public void postorder(NodoArbolBinario<T> nodo) {

        if (nodo.getLeft() != null) {
            postorder(nodo.getLeft());
        }

        if (nodo.getRight() != null) {
            postorder(nodo.getRight());
        }

        System.out.println(nodo.getElement().toString());

    }

    /**
     * Determina la altura del arbol desde el nodo dado
     *
     * @param nodo
     * @return
     */
    public int height(NodoArbolBinario<T> nodo) {

        int height = 0;

        if (isInternal(nodo)) {

            if (nodo.getLeft() != null) {
                height = Math.max(height, height(nodo.getLeft()));
            }

            if (nodo.getRight() != null) {
                height = Math.max(height, height(nodo.getRight()));
            }

            height++;
        }

        return height;

    }

    /**
     * Devuelve la profundidad desde el nodo dado
     *
     * @param nodo
     * @return
     */
    public int depth(NodoArbolBinario<T> nodo) {

        int depth = 0;

        if (nodo != getRoot()) {
            depth = 1 + depth(nodo.getParent());
        }

        return depth;

    }

    private final int ONE_NODE_LEFT = 1;
    private final int ONE_NODE_RIGHT = 2;
    private final int TWO_NODES = 3;

    /**
     * Elimina el nodo indicados
     *
     * @param nodo
     */
    public void remove(NodoArbolBinario<T> nodo) {

        if (root == null) {
            System.out.println("No hay nodos que borrar");
        } else if (isLeaf(nodo)) {
            removeLeaf(nodo);
        } else if (nodo.getRight() != null && nodo.getLeft() == null) {
            removeWithChlid(nodo, ONE_NODE_RIGHT);
        } else if (nodo.getRight() == null && nodo.getLeft() != null) {
            removeWithChlid(nodo, ONE_NODE_LEFT);
        } else {
            removeWithChlid(nodo, TWO_NODES);
        }

    }

    /**
     * Elimina un nodo hoja
     *
     * @param nodo
     */
    private void removeLeaf(NodoArbolBinario<T> nodo) {

        if (isRoot(nodo)) {
            root = null;
        } else {

            NodoArbolBinario<T> parent = nodo.getParent();

            if (parent.getLeft() == nodo) {
                parent.setLeft(null);
            }

            if (parent.getRight() == nodo) {
                parent.setRight(null);
            }

            nodo = null;

        }

    }

    /**
     * Elimina un nodo interno, varia segun el numero de hijos y posicion
     *
     * @param nodo
     * @param type_node
     */
    private void removeWithChlid(NodoArbolBinario<T> nodo, int type_node) {

        NodoArbolBinario<T> siguiente = null;

        switch (type_node) {
            case ONE_NODE_LEFT:
                siguiente = nodo.getLeft();
                break;
            case ONE_NODE_RIGHT:
                siguiente = minSubTree(nodo.getRight());
                break;
            case TWO_NODES:

                siguiente = minSubTree(nodo.getRight());

                if (!isRoot(siguiente.getParent())) {

                    nodo.getLeft().setParent(siguiente);
                    nodo.getRight().setParent(siguiente);

                    if (siguiente.getParent().getLeft() == siguiente) {
                        siguiente.getParent().setLeft(null);
                    } else if (siguiente.getParent().getRight() == siguiente) {
                        siguiente.getParent().setRight(null);
                    }

                }

                break;
        }

        siguiente.setParent(nodo.getParent());

        if (!isRoot(nodo)) {

            if (nodo.getParent().getLeft() == nodo) {
                nodo.getParent().setLeft(siguiente);
            } else if (nodo.getParent().getRight() == nodo) {
                nodo.getParent().setRight(siguiente);
            }

        } else {
            root = siguiente;
        }

        if (nodo.getRight() != null && nodo.getRight() != siguiente) {
            siguiente.setRight(nodo.getRight());
        }

        if (nodo.getLeft() != null && nodo.getLeft() != siguiente) {
            siguiente.setLeft(nodo.getLeft());
        }

        nodo = null;

    }

    /**
     * Calcula el valor minimo de un subarbol
     *
     * @param nodo
     * @return
     */
    private NodoArbolBinario<T> minSubTree(NodoArbolBinario<T> nodo) {

        if (nodo != null && nodo.getLeft() != null) {
            while (!isLeaf(nodo)) {
                nodo = minSubTree(nodo.getLeft());
            }

        }

        return nodo;
    }

    public NodoArbolBinario<T> getNode(NodoArbolBinario<T> nodo, T elemento) {

        NodoArbolBinario<T> aux = null;

        if (nodo.getElement().compareTo(elemento) == 0) {
            aux = nodo;
        } else {
            if (nodo.getLeft() != null) {
                aux = getNode(nodo.getLeft(), elemento);
            }

            if (nodo.getRight() != null) {
                aux = getNode(nodo.getRight(), elemento);
            }
        }

        return aux;
    }

    public T getElement(NodoArbolBinario<T> nodo, T elemento) {

        NodoArbolBinario<T> aux = getNode(nodo, elemento);

        if (aux == null) {
            return null;
        }

        return aux.getElement();
    }

    public void getNodes(NodoArbolBinario<T> nodo, T elemento, ListaDinamica<NodoArbolBinario<T>> lista_nodos) {

        if (nodo.getElement().compareTo(elemento) == 0) {
            lista_nodos.addLast(nodo);
        }

        if (nodo.getLeft() != null) {
            getNodes(nodo.getLeft(), elemento, lista_nodos);
        }

        if (nodo.getRight() != null) {
            getNodes(nodo.getRight(), elemento, lista_nodos);
        }

    }

    public ListaDinamica<T> getElements(NodoArbolBinario<T> nodo, T elemento) {

        ListaDinamica<T> elementos = new ListaDinamica<>();
        ListaDinamica<NodoArbolBinario<T>> lista_nodos = new ListaDinamica<>();

        getNodes(nodo, elemento, lista_nodos);

        for (NodoArbolBinario<T> aux : lista_nodos) {

            elementos.addLast(aux.getElement());

        }

        return elementos;

    }

    public void mostrar(NodoArbolBinario<T> nodo) {

        int profundidad = this.depth(nodo);

        for (int i = 0; i < profundidad; i++) {
            System.out.print(" ");
        }
        
        System.out.println("- "+nodo.getElement().toString());

        if (nodo.getLeft() != null) {
            mostrar(nodo.getLeft());
        }

        if (nodo.getRight() != null) {
            mostrar(nodo.getRight());
        }

    }

}
