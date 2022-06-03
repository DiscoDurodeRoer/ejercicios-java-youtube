
package ejercicio_poo_ddr_13;

import java.io.IOException;


public class Ejercicio_POO_DDR_13 {

    public static void main(String[] args) {
        
        Test t=new Test();
        
        try {
            t.cargarFichero("preguntas-incorrecto.txt");
            
             t.realizarTest();
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
    
}
