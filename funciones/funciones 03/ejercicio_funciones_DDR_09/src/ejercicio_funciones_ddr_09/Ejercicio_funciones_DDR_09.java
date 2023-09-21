package ejercicio_funciones_ddr_09;

import java.util.Scanner;

/**
 * @author Discoduroderoer
 */
public class Ejercicio_funciones_DDR_09 {

    public static void main(String[] args) {
       
        Scanner sc=new Scanner(System.in);
        
        int numero;
        
        //Validamos que el numero sea entero
        do{
            System.out.println("Escribe un numero positivo");
            numero=sc.nextInt();
            
        }while(numero<0);
        
        //llamamos a la funcion
        int cifras=cuentaCifras(numero);
        
        System.out.println("Hay "+cifras+" cifra/s");
        
    }
    
    //Funcion que nos cuenta el numero de cifras
    public static int cuentaCifras(int numero){
        
        int cifras=1;
        
        //Vamos dividiendo entre 10
        for(int i=numero;i>=10;i/=10){
            cifras++;
        }
        
        return cifras;
        
    }
    
}
