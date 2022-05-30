package ejercicio_arrays_DDR_08;

import java.util.Arrays;

public class Ejercicio_8 {

    public static void main(String[] args) {
      
        //Creamos un array y uno auxiliar
        int numeros[]={9,0,1,9};
        int aux[]=new int[numeros.length];
        
        //Hacemos igual que en el ejercicio 6
        for(int i=numeros.length-1, j=0;i>=0;i--,j++){
            aux[j]=numeros[i];
            System.out.println(aux[j]);
        }
        
        //Comprobamos si son iguales
        if(Arrays.equals(numeros, aux)){
            System.out.println("Es capicua");
        }else{
            System.out.println("No es capicua");
        }
        
    }
    
}
