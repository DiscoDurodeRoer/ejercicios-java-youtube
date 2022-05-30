package ejercicio_arrays_ddr_11;

import java.util.Arrays;

public class Ejercicio_arrays_DDR_11 {

    public static void main(String[] args) {
        
        //Creo el array
        int num1[]=new int[10];
        int num2[]=new int[10];
        
        //Comparo el contenido de ambos
        if(Arrays.equals(num1, num2)){
            System.out.println("Son iguales");
        }else{
            System.out.println("No son iguales");
        }
        
        
        
    }
    
}
