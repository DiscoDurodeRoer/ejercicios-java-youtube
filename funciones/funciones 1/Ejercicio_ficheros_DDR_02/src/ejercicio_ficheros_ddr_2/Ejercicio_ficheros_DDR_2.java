package ejercicio_ficheros_ddr_2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Ejercicio_ficheros_DDR_2 {

    public static void main(String[] args) {
        
        //Variables a usar
        String contenido="";
        int c;
        
        try {
            //Creamos el objeto y le pasamos el fichero a leer
            FileReader fr=new FileReader("D:\\test\\holamundo.txt");
        
            //Leemos el fichero
            while((c=fr.read())!=-1){
                contenido+=(char)c;
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Ejercicio_ficheros_DDR_2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Ejercicio_ficheros_DDR_2.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Mostramos el contenido
        System.out.println("El contenido del fichero es: "+contenido);
        
        
    }
    
}
