package ejercicio_ed_17_discoduroderoer;

public class Ejercicio_ED_17_Discoduroderoer {

    public static void main(String[] args) {
     
        //Creo las pilas
        PilaDinamica<Integer> p1 = new PilaDinamica<>();
        PilaDinamica<Integer> p2 = new PilaDinamica<>();
        
        //Añado elementos 
        p1.push(3);
        p1.push(2);
        p1.push(1);
        
        System.out.println(p1);
        
        //Añado elementos 
        p2.push(3);
        p2.push(4);
        p2.push(6);
        
        System.out.println(p2);
        
        //Sumo las pilas
        PilaDinamica<Integer> p3 = sumaPilas(p1,p2);
         
        //Si la pila no es nula la muestro
        if(p3!=null){
            System.out.println(p3);
        }else{
            System.out.println("Ha ocurrido un error, revisa el tamaño de las pilas o si son nulas");
        }
        
        
    }
    
    public static PilaDinamica<Integer> sumaPilas(PilaDinamica<Integer> p1, PilaDinamica<Integer> p2){
        
        //Si las pilas no son nulas o si el tamaño es distinto, retorna nulo
        if(p1==null || p2 == null || p1.size() != p2.size()){
            return null;
        }else{
            
            //Creo una pila
            PilaDinamica<Integer> p3 = new PilaDinamica<>();
            
            //la relleno
            while(!p1.isEmpty()){
                p3.push(p1.pop() + p2.pop());
            }
            
            //le doy la vuelta
            p3.reverse();
            
            //retorno la pila
            return p3;
        }
        
    }
    
}
