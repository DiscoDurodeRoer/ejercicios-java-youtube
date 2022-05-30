package ejercicio_arrays_DDR_07;

import java.util.Scanner;

public class Ejercicio_7 {

    public static void main(String[] args) {
        
        Scanner sn=new Scanner(System.in);
        
        //Pedir un número
        System.out.println("Escriba una frase");
        String frase=sn.next();
        
        //Creamos un array de caracteres
        char caracteres[]=new char[frase.length()];
        
        //Recorremos la frase y cogemos cada caracter y lo metemos en el array
        for(int i=0;i<frase.length();i++){
            caracteres[i]=frase.charAt(i);
            System.out.println(caracteres[i]);
        }
        
        
    }
    
}
