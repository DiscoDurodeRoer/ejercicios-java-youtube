package ejercicio_ed_14_discoduroderoer;

import lista_dinamica.ListaDinamica;

public class Ejercicio_ED_14_Discoduroderoer {

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
        arbol.add(12);
        arbol.add(12);
        NodoArbolBinario<Integer> t2 = arbol.add(14);
        arbol.add(16);
        arbol.add(15);
        NodoArbolBinario<Integer> t3 = arbol.add(13);

        //mostrar
        arbol.inorder(arbol.getRoot());
        System.out.println("");
        
        NodoArbolBinario<Integer> nodo = arbol.getNode(arbol.getRoot(), 12);
        
        if(nodo!=null){
            System.out.println("getNode: "+nodo.getElement());
        }
        
        Integer elemento = arbol.getElement(nodo, 12);
        
        System.out.println("getElement: "+elemento);
        
        ListaDinamica<NodoArbolBinario<Integer>> nodos = new ListaDinamica<>();
        
        arbol.getNodes(arbol.getRoot(), 12, nodos);
        
        System.out.println("getNodes: ");
        for(NodoArbolBinario<Integer> aux:nodos){
            System.out.println(aux.getElement());
        }
        
        ListaDinamica<Integer> elementos = new ListaDinamica<>();
        
        elementos = arbol.getElements(nodo, 12);
        
        System.out.println("getElements: ");
        for(Integer aux:elementos){
            System.out.println(aux);
        }
        

    }

}
