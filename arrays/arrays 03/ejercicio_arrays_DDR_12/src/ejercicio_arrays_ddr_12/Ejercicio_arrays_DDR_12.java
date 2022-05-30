package ejercicio_arrays_ddr_12;

import java.util.Arrays;

public class Ejercicio_arrays_DDR_12 {

    public static void main(String[] args) {
        
        //Creo el array
        int num[]=new int[5];
        
        //Asigno valores
        num[0]=6;
        num[1]=3;
        num[2]=9;
        num[3]=4;
        num[4]=1;
        
        //ordeno
        Arrays.sort(num);
        
        //Muestro el array
        for(int i=0;i<num.length;i++){
            System.out.println(num[i]);
        }
        
    }
    
}
