/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio_funciones_DDR_05;

/**
 *
 * @author fernandos
 */
public class Ejercicio_5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int min=0;
        int max=100;
        
        for(int i=0;i<1000;i++){
            
            System.out.println(generaNumAleatorio(min,max));
        
        }
        
    }
    
    public static int generaNumAleatorio(int minimo,int maximo){
        
        return (int)Math.floor(Math.random()*(minimo-(maximo+1))+(maximo+1));
        
    }
    
}
