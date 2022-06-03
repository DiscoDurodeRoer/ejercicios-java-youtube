package ejercicio_ed_1_discoduroderoer;

import java.util.Stack;

public class Ejercicio_ED_1_Discoduroderoer {

    public static void main(String[] args) {

        System.out.println("Mi pila Dinamica");

        PilaDinamica<Integer> pilaNumeros = new PilaDinamica<>();

        System.out.println("¿La pila esta vacia? (Inicio) " + pilaNumeros.isEmpty());

        pilaNumeros.push(5);
        pilaNumeros.push(10);
        pilaNumeros.push(15);
        pilaNumeros.push(20);

        System.out.println("¿La pila esta vacia? (despues de agregar) " + pilaNumeros.isEmpty());

        System.out.println("El tamaño ahora es de " + pilaNumeros.size());

        System.out.println("El top es " + pilaNumeros.top());

        int elemento = pilaNumeros.pop();

        System.out.println("He sacado el numero " + elemento);
        System.out.println("El tamaño ahora es de " + pilaNumeros.size());

        System.out.println("El top es " + pilaNumeros.top());

        System.out.println(pilaNumeros);

        System.out.println("");
        System.out.println("Stack de Java");

        Stack<Integer> pilaStack = new Stack<>();

        System.out.println("¿La pila esta vacia? (Inicio) " + pilaStack.empty());

        pilaStack.push(5);
        pilaStack.push(10);
        pilaStack.push(15);
        pilaStack.push(20);

        System.out.println("¿La pila esta vacia? (Despues de agregar) " + pilaStack.empty());

        System.out.println("El tamaño ahora es de " + pilaStack.size());

        System.out.println("El top es " + pilaStack.peek());
        
        int elemento2 = pilaStack.pop();

        System.out.println("He sacado el numero " + elemento2);
        System.out.println("El tamaño ahora es de " + pilaStack.size());

        System.out.println("El top es " + pilaStack.peek());

        System.out.println(pilaStack);

    }

}
