package ejercicio_basico_DDR_03;

import java.util.Scanner;

public class Ejercicio_3 {

    public static void main(String[] args) {
        
        Scanner sn=new Scanner(System.in);
        
        //Pedimos el número
        System.out.println("Introduzca un número");
        int num=sn.nextInt();
        
        //Cambiamos el numero por el caracter
        char caracter=(char)num;
        
        //Mostramos el caracter
        System.out.println("El número "+num+" corresponde al caracter '"+caracter+"'");
        
    }
    
}
