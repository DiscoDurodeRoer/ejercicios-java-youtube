package ejercicio_recursividad_ddr_12;

import arbol.BinarySearchTree;
import arbol.NodoArbolBinario;

public class Ejercicio_recursividad_DDR_12 {

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
        
        System.out.println(cuentaNodos(arbol.getRoot()));
    }
    
    public static int cuentaNodos(NodoArbolBinario nodo){
        
        int contador=1;
        
        if(nodo.getLeft()!=null){
            contador += cuentaNodos(nodo.getLeft());
        }
        
        if(nodo.getRight()!=null){
            contador += cuentaNodos(nodo.getRight());
        }
        
        return contador;
        
        
    }
    
    
}
