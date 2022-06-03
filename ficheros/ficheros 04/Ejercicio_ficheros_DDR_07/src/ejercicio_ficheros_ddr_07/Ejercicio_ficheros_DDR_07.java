package ejercicio_ficheros_ddr_07;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author DiscoDurodeRoer
 */
public class Ejercicio_ficheros_DDR_07 {

    public static void main(String[] args) {
        
        //Objeto file con la ruta del fichero
        File f = new File("numeros.txt");
        
        //Abro el Scanner
        //De esta forma, cuando se cierra el try se cierra solo
        try (Scanner sc = new Scanner(f)) {
            
            int num;
            
            //Leo el fichero hasta que no haya mas numeros
            while (sc.hasNext()) {
                //Cojo el numero del fichero
                num = sc.nextInt();
                //Muestro ese numero
                System.out.println(num);   
            }
        
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        
        
    }
    
}
