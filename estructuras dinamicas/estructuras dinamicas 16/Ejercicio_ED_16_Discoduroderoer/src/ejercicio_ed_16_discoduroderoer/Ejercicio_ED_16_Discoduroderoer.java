package ejercicio_ed_16_discoduroderoer;

public class Ejercicio_ED_16_Discoduroderoer {

    public static void main(String[] args) {
     
        PilaDinamica<Integer> pila = new PilaDinamica<>();
        
        pila.push(3);
        pila.push(2);
        pila.push(1);
        
        System.out.println(pila.toString());
        
        pila.reverse();
        
        System.out.println(pila.toString());
        
    }
    
}
