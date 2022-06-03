package ejercicio_ed_11_discoduroderoer;



public class Ejercicio_ED_11_Discoduroderoer {

    public static void main(String[] args) {
        BinarySearchTree<Integer> arbol = new BinarySearchTree<>();

        arbol.add(8);

        arbol.add(4);
        arbol.add(arbol.getRoot(), 10);
        arbol.add(arbol.getRoot(), 12);
        arbol.add(1);
        
        
        arbol.preorder(arbol.getRoot()); // 8, 4, 1, 10, 12
        System.out.println("");
        arbol.inorder(arbol.getRoot()); // 1, 4, 8, 10, 12
        System.out.println("");
        arbol.postorder(arbol.getRoot());// 1, 4, 12, 10, 8
        
        
        
        
    }

}
