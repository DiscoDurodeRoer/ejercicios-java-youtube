package ejercicio_recursividad_ddr_15;

import arbol.BinarySearchTree;
import arbol.NodoArbolBinario;

public class Ejercicio_recursividad_DDR_15 {

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
        
        System.out.println(cuentaNodos(arbol.getRoot(), 4));
        
    }
    
    
    public static int cuentaNodos(NodoArbolBinario<Integer> nodo, int elemento){
        
        int contador=0;
        
        if(nodo.getElement() == elemento){
            contador++;
        }
        
        if(nodo.getLeft()!=null){
            contador += cuentaNodos(nodo.getLeft(), elemento);
        }
        
        if(nodo.getRight()!=null){
            contador += cuentaNodos(nodo.getRight(), elemento);
        }
        
        return contador;
        
        
    }
    
    
    
}
