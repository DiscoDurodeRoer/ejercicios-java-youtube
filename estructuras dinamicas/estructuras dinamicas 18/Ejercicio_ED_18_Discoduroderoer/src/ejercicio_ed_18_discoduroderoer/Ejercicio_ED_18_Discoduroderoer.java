package ejercicio_ed_18_discoduroderoer;

import arbol.BinarySearchTree;
import arbol.NodoArbolBinario;
import java.util.Scanner;
import piladinamica.PilaDinamica;

public class Ejercicio_ED_18_Discoduroderoer {

    public static void main(String[] args) {

        //Creación del arbol
        BinarySearchTree<Character> letras = new BinarySearchTree<>();

        letras.add('M');
        letras.add('C');
        letras.add('V');
        letras.add('X');
        letras.add('P');
        letras.add('N');
        letras.add('L');
        letras.add('Z');
        letras.add('A');
        letras.add('B');
        letras.add('F');
        letras.add('W');
        letras.add('R');
        letras.add('S');
        letras.add('D');
        letras.add('Y');

        letras.mostrar(letras.getRoot());

        //Creo el scanner para pedir ina letra
        Scanner sn = new Scanner(System.in);
        System.out.println("Inserta una letra");
        char letraDestino = sn.next().toUpperCase().charAt(0);
        System.out.println("");

        //Creo el arbol y la pila dinamica
        NodoArbolBinario<Character> nodo = letras.getRoot();
        PilaDinamica<Character> camino = new PilaDinamica<>();

        //mientras el nodo no sea nulo o no sea la letra que buscas
        while (nodo != null && nodo.getElement() != letraDestino) {

            //Añado la letra
            camino.push(nodo.getElement());

            //Segun la letra cojo uno u otro nodo
            if (nodo.getElement() < letraDestino) {
                nodo = nodo.getRight();
            } else {
                nodo = nodo.getLeft();
            }

        }

        //si lo encuentra, muestro el camino
        if (nodo != null) {
            camino.push(letraDestino);
            camino.reverse();
            System.out.println(camino.toString());
        } else {
            System.out.println("No encontrado");
        }

    }

}
