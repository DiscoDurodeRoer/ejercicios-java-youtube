package ejercicio_basicos_ddr_19;

import java.util.Scanner;

public class Ejercicio_basicos_DDR_19 {

    public static void main(String[] args) {
       
        Scanner sn = new Scanner(System.in);
        
        //Hace que podamos escribir espacios en la frase y coja todo el String
        sn.useDelimiter("\n");
        
        System.out.println("Escribe una frase");
        String frase=sn.next();
    
        //Remplazamos con replace
        //Debemos devolver el resultado a una cadena o a la misma
        frase = frase.replace('a', 'e');
        frase = frase.replace('i', 'o');
        
        System.out.println(frase);
    }
    
}
