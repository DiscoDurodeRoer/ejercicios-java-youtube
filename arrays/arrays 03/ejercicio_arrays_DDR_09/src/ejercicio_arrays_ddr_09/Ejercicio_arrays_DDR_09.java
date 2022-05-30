package ejercicio_arrays_ddr_09;

import java.util.Arrays;

public class Ejercicio_arrays_DDR_09 {

    public static void main(String[] args) {
        
        //creo el array
        int num[]=new int[10];
        
        //relleno todo el array con 20
        Arrays.fill(num, 20);
        
        //Relleno desde la posicion 3 hasta el final
        Arrays.fill(num, 3, num.length, -1);
        
        //Muestro el array
        for(int i=0;i<num.length;i++){
            System.out.println(num[i]);
        }
        
    }
    
}
