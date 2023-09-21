/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio_funciones_DDR_04;

/**
 *
 * @author fernandos
 */
public class Ejercicio_4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        char caracter='a';
        
        System.out.println("El caracter '"+caracter+"' tiene el código "+devuelveCodigoASCII(caracter));
        
    }
    
    public static int devuelveCodigoASCII(char caracter){
        
        return (int)caracter;
        
    }
    
}
