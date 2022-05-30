package ejercicio_arrays_ddr_10;

import java.util.Arrays;

public class Ejercicio_arrays_DDR_10 {

    public static void main(String[] args) {
       
        //Creo el array
        int num[]=new int[10];
        
        //Rellenamos el array con 1
        Arrays.fill(num, 1);
        
        //Copiamos de las posiciones 2 a la 9 (7 posiciones tendra)
        int num2[]=Arrays.copyOfRange(num, 2, 9);
        
        //Muestro el array
        for(int i=0;i<num2.length;i++){
            System.out.println(num2[i]);
        }
        
    }
    
}
