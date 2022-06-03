package ejercicio_ed_2_discoduroderoer;

import java.util.LinkedList;
import java.util.Queue;


public class Ejercicio_ED_2_Discoduroderoer {

    public static void main(String[] args) {
      
        //Usamos nuestra clase
        System.out.println("Nuestra implementacion");
        ColaDinamica<Integer> cola = new ColaDinamica<>();
        
        System.out.println("El tamaño es: "+cola.size());
        System.out.println("¿Esta vacia? (inicio) "+cola.isEmpty());
        
        cola.enqueue(5);
        cola.enqueue(10);
        cola.enqueue(15);
        cola.enqueue(20);
        
        System.out.println("El tamaño es: "+cola.size());
        System.out.println("¿Esta vacia? (despues de agregar) "+cola.isEmpty());
        
        System.out.println("El primero es: "+cola.primero());
        
        System.out.println("Quitamos el primero (5) "+cola.dequeue());
        System.out.println("Quitamos el primero (10) "+cola.dequeue());
        System.out.println("Quitamos el primero (15) "+cola.dequeue());
        System.out.println("Quitamos el primero (20) "+cola.dequeue());
        System.out.println("Quitamos el primero (null) "+cola.dequeue());
        
        System.out.println("El tamaño es: "+cola.size());
        System.out.println("¿Esta vacia? (despues de quitar) "+cola.isEmpty());
        
        //Usamos la implementacion de java
        System.out.println("Implementacion de Java");
        Queue<Integer> q = new LinkedList<>();
        System.out.println("El tamaño es: "+q.size());
        System.out.println("¿Esta vacia? (inicio) "+q.isEmpty());
        
        q.offer(5);
        q.offer(10);
        q.offer(15);
        q.offer(20);
        
        System.out.println("El tamaño es: "+q.size());
        System.out.println("¿Esta vacia? (despues de agregar) "+q.isEmpty());
        
        System.out.println("El primero es: "+q.peek());
        
        System.out.println("Quitamos el primero (5) "+q.poll());
        System.out.println("Quitamos el primero (10) "+q.poll());
        System.out.println("Quitamos el primero (15) "+q.poll());
        System.out.println("Quitamos el primero (20) "+q.poll());
        System.out.println("Quitamos el primero (null) "+q.poll());
        
        System.out.println("El tamaño es: "+q.size());
        System.out.println("¿Esta vacia? (despues de quitar) "+q.isEmpty());
        
        
    }
    
}
