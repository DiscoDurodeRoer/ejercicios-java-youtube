package ejercicio_ficheros_ddr_1;

import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Ejercicio_ficheros_DDR_1 {

    public static void main(String[] args) {
        
        //Creamos el objeto y al llegar al catch se cierra automaticamente
        //Solo se puede hacer a partir de Java 7 (1.7)
        try (FileWriter fw=new FileWriter("D:\\test\\holamundo.txt", true)){ 
            
            //Para insertar un salto de linea usa /r/n
            fw.write(" Dale a like si te molo el video");
        
        } catch (IOException ex) {
            Logger.getLogger(Ejercicio_ficheros_DDR_1.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
