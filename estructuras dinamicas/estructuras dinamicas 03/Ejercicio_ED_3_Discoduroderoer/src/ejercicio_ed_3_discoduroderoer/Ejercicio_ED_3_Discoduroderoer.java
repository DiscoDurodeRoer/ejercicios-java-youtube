package ejercicio_ed_3_discoduroderoer;

public class Ejercicio_ED_3_Discoduroderoer {

    public static void main(String[] args) {
        
        //Version 1.0
        
        ListaDinamica<Integer> lista = new ListaDinamica<>();
        
        //Añadimos elementos, recordar que devuelve el elemento
        System.out.println("Añadido el elemento "+lista.add(1,0));
        System.out.println("Añadido el elemento "+lista.add(2,1));
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
        
        
        
    }
    
}
