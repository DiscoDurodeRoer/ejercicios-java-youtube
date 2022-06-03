package ejercicio_poo_ddr_24;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Ejercicio_POO_DDR_24 {

    public static void main(String[] args) {

        
        try {
            Log myLog = new Log("./log.txt");
            
            myLog.addLine("Linea 1");
            myLog.addLine("Linea 2");
            myLog.addLine("Linea 3");
            myLog.addLine("Linea 4");
            myLog.addLine("Linea 5");
            
            String[] lines = myLog.getLines();
            
            for (int i = 0; i < lines.length; i++) {
                System.out.println(lines[i]);
            }
            
            myLog.resetLog();
            
        } catch (IOException ex) {
            Logger.getLogger(Ejercicio_POO_DDR_24.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }

}
