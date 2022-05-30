package ejercicio_basico_DDR_04;

import java.util.Scanner;

public class Ejercicio_4 {

    public static void main(String[] args) {
        
        Scanner sn=new Scanner(System.in);
        
        System.out.println("Introduzca un número");
        int num=sn.nextInt();
        
        if(num%2==0){
            System.out.println("El numero "+num+" es par");
        }else{
            System.out.println("El numero "+num+" no es par");
        }
        
    }
    
}
