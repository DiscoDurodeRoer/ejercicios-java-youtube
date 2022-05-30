package ejercicio_basico_DDR_05;

import java.util.Scanner;

public class Ejercicio_5 {

    public static void main(String[] args) {
        
        Scanner sn=new Scanner(System.in);
        
        //Pedimos dos números
        System.out.println("Introduzca el número 1");
        int num1=sn.nextInt();
        
        System.out.println("Introduzca el número 2");
        int num2=sn.nextInt();
        
        //Comparamos
        if(num1<=num2){
            
            //Comprobamos por si son iguales
            if(num1==num2){
                System.out.println("Son iguales");
            }else{
                System.out.println("El número "+num2+" es el mayor");
            }
            
        }else{
            System.out.println("El número "+num1+" es el mayor");
        }
        
    }
    
}
