package ejercicio_ficheros_ddr_19;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Ejercicio_ficheros_DDR_19 {

    public static void main(String[] args) {

        String json = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader("ejemplo.json"));

            String linea;
            while ((linea = br.readLine()) != null) {
                json += linea;
            }

            br.close();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Ejercicio_ficheros_DDR_19.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Ejercicio_ficheros_DDR_19.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println(json);
        
        Gson gson = new Gson();
        Persona p = gson.fromJson(json, Persona.class);
        System.out.println(p);
        
    }

}
