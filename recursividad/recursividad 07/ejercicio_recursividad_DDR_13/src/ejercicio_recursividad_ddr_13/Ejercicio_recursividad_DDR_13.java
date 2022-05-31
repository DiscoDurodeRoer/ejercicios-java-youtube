package ejercicio_recursividad_ddr_13;

import arbol.BinarySearchTree;
import arbol.NodoArbolBinario;

public class Ejercicio_recursividad_DDR_13 {

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
        
        System.out.println(cuentaNodos(arbol, arbol.getRoot()));
        
    }
    
    public static int cuentaNodos(BinarySearchTree arbol, NodoArbolBinario nodo){
        
        int contador=0;
        
        if(arbol.isLeaf(nodo)){
            contador++;
        }
        
        if(nodo.getLeft()!=null){
            contador += cuentaNodos(arbol, nodo.getLeft());
        }
        
        if(nodo.getRight()!=null){
            contador += cuentaNodos(arbol, nodo.getRight());
        }
        
        return contador;
        
        
    }
    
}
