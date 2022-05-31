package ejercicio_recursividad_ddr_16;

public class Ejercicio_recursividad_DDR_16 {

    public static void main(String[] args) {

        int[] a1 = {1,2,2,4,5,6};
        int[] a2 = {1,2,2,4,5};
        
        if(a1.length == a2.length){
            System.out.println(arraysIgualesRec(a1,a2,0));
        }else{
            System.out.println(false);
        }
        
        
        
    }
    
    public static boolean arraysIgualesRec(int[] a1,int[] a2, int indice){
        
        if(indice == a1.length){
            return true;
        }else if(a1[indice] != a2[indice]){
            return false;
        }else{
            return arraysIgualesRec(a1,a2,indice+1);
        }
        
    }

    

}
