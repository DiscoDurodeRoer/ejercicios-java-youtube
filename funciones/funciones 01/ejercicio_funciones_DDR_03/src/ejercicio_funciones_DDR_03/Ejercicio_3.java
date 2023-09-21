/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio_funciones_DDR_03;

/**
 *
 * @author fernandos
 */
public class Ejercicio_3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int num=0;
        
        if(mayorQue0(num)){
            
            System.out.println("El numero "+num+" es mayor que cero");
       
        }else{
            
            System.out.println("El numero "+num+" es menor o igual que cero");
        
        }
        
    }
    
    public static boolean mayorQue0(int num){
        
        return num>0;
        
    }
    
}
