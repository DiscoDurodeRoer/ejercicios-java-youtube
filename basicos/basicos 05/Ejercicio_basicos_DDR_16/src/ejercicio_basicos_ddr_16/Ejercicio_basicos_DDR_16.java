package ejercicio_basicos_ddr_16;

import java.util.Scanner;

public class Ejercicio_basicos_DDR_16 {

    public static void main(String[] args) {
       
        //Creamos un scanner para leer
        Scanner sn = new Scanner(System.in);
        
        //Pedimos las palabras
        System.out.println("Escribe la palabra 1");
        String palabra1 = sn.next();
        
        System.out.println("Escribe la palabra 2");
        String palabra2 = sn.next();
        
        //Comparamos con el método equals
        //Con equalsIgnoreCase, no considera las mayusculas
        if(palabra1.equals(palabra2)){
            System.out.println("Las palabras son iguales");
        }else{
            System.out.println("Las palabras no son iguales");
        }
        
    }
    
}
