package ejercicio_ed_8_discoduroderoer;

import java.util.Iterator;

public class Ejercicio_ED_8_Discoduroderoer {

    public static void main(String[] args) {
       
        //Version 1.0
        
        ListaDinamica<Integer> lista = new ListaDinamica<>();
        
        //Añadimos elementos, recordar que devuelve el elemento
        System.out.println("Añadido el elemento "+lista.addLast(1));
        System.out.println("Añadido el elemento "+lista.addLast(2));
        System.out.println("Añadido el elemento "+lista.addLast(3));
        System.out.println("Añadido el elemento "+lista.addFirst(4));
        System.out.println("Añadido el elemento "+lista.addLast(5));
        System.out.println("Añadido el elemento "+lista.addLast(6));
        System.out.println("Añadido el elemento "+lista.add(7, 2));
        System.out.println("Añadido el elemento "+lista.add(8, 4));
        System.out.println("Añadido el elemento "+lista.addFirst(9));
        
        //Orden actual: 9 4 1 7 2 8 3 5 6
        System.out.println("");
        System.out.println("Estado de la lista");
        System.out.println(lista.toString());
        
        //Cojo el valor de la posicion 7 = 5
        System.out.println("Elemento de la posicion 7: "+lista.get(7));
        
        //Cojo el valor de la posicion 9 = null, ya que no existe esa posición
        System.out.println("Elemento de la posicion 9: "+lista.get(9));
        
        //Cojo el valor de la primera posicion = 9
        System.out.println("Elemento de la primera posicion: "+lista.getFirst());
        
        //Cojo el valor de la ultima posicion = 6
        System.out.println("Elemento de la ultima posicion: "+lista.getLast());
        
        //Version 2.0
        
        System.out.println("Borrado el primer elemento "+lista.removeFirst());
        System.out.println("Borrado el elemento de la tercera posicion "+lista.remove(2));
        System.out.println("Borrado el primer elemento "+lista.removeFirst());
        System.out.println("Borrado el elemento de la sexta posicion "+lista.remove(5));
        System.out.println("Borrado el elemento "+lista.removeLast());
        
        //orden actual: 1 2 8 3
        System.out.println("");
        System.out.println("Estado de la lista");
        System.out.println(lista.toString());
        
        //true
        System.out.println("¿Existe el elemento 2? "+lista.exists(2));
        
        //false
        System.out.println("¿Existe el elemento 2? "+lista.exists(10));
        
        //Posicion 1
        System.out.println("Posicion del elemento 2: "+lista.indexOf(2));
        
        //Posicicon -1, no existe
        System.out.println("Posicion del elemento 10: "+lista.indexOf(10));
        
        //Elemento modificado
        lista.modify(10, 0);
        
        //orden actual: 10 2 8 3
        System.out.println("");
        System.out.println("Estado de la lista");
        System.out.println(lista.toString());
        
        System.out.println("Iterable clasico");
        
        Iterator<Integer> it = lista.iterator();
        
        while(it.hasNext()){
            System.out.println(it.next());
        }
        
        System.out.println("Iterable for each");
        
        for(int i:lista){
            System.out.println(i);
        }
        
    }

}
