package ejercicio_basicos_ddr_20;

import java.util.Scanner;

public class Ejercicio_basicos_DDR_20 {

    public static void main(String[] args) {
        
        Scanner sn = new Scanner(System.in);
        
        //Hace que podamos escribir espacios en la frase y coja todo el String
        sn.useDelimiter("\n");
        
        System.out.println("Escribe una frase");
        String frase=sn.next();
        
        //Indica la posicion de 'a' desde el inicio
        int pos = frase.indexOf('a');
        
        System.out.println(pos);
        
        //Indica la posicion de 'a' desde la ultima posicion encontrada
        pos = frase.indexOf('a', pos+1);
        
        System.out.println(pos);
        
    }
    
}
